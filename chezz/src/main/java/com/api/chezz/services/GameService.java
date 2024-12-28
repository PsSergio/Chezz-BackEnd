package com.api.chezz.services;

import com.api.chezz.dtos.HouseDetailsDto;
import com.api.chezz.dtos.PlayInput;
import com.api.chezz.dtos.PlayOutput;
import com.api.chezz.enums.SidePlayerEnum;
import com.api.chezz.exceptions.InvalidPlayException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GameService {

//    public PlayOutput newPlay(PlayInput playInput){
//
//    }

    public boolean thereIsSomePieceInHouse(List<PlayOutput> allPlays, PlayInput playInput){

        boolean results = false;
        var actHouse = playInput.actPosition();
        var tempPiece = "";
        var tempLetter = "";
        var tempNumber = 0;

        for (var play : allPlays) {
            if (play.house() == actHouse) {
                tempPiece = play.prefix();
                tempLetter = play.house().letter();
                tempNumber = play.house().number();
                results = true;
            }

            if (Objects.equals(play.prefix(), tempPiece)
            && !Objects.equals(play.house().letter(), tempLetter)
            || play.house().number() != tempNumber) results = false;

        }

        return results;
    }

    public void validatePawnPlay(PlayInput playInput){
        if(!(playInput.prefix() == null)) return;

        if(playInput.sidePlayer() == SidePlayerEnum.White
        && playInput.lastPosition().number() == 2
        && playInput.actPosition().number() > 4) throw new InvalidPlayException();

        if(playInput.sidePlayer() == SidePlayerEnum.Black
                && playInput.lastPosition().number() == 7
                && playInput.actPosition().number() < 5) throw new InvalidPlayException();

//        if()
    }

}
