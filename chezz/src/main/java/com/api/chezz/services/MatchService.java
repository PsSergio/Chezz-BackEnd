package com.api.chezz.services;

import com.api.chezz.dtos.FindingMatchDto;
import com.api.chezz.dtos.MatchFoundDto;
import com.api.chezz.exceptions.UserAlreadyInMatchException;
import com.api.chezz.models.Match;
import com.api.chezz.models.Player;
import com.api.chezz.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void createMatch(Player player){
        var match = new Match();
        match.setOwner(player);

        matchRepository.save(match);
    }

    public MatchFoundDto joiningSelectedMatch(Player guest, Match match){

        match.setGuest(guest);
        matchRepository.save(match);

        return new MatchFoundDto(match.getId(), match.getOwner().getUsername(), match.getOwner().getRating(), match.getGuest().getUsername(), match.getGuest().getRating());
    }

    public MatchFoundDto findMatch(Player guest){

        if( matchRepository.findByGuest(guest).isPresent() ) throw new UserAlreadyInMatchException();

        if( matchRepository.findByOwner(guest).isPresent() ) throw new UserAlreadyInMatchException();

        for(int i = 20; i <= 100; i+=20){
            var matchs = matchRepository.findingMatchByRating(guest.getRating()-i, guest.getRating()+i);
            if(!matchs.isEmpty()) {
                var match = matchs.get(0);
                return joiningSelectedMatch(guest, match);

            }
        }

        return null;
    }
}
