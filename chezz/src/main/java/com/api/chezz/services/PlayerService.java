package com.api.chezz.services;

import com.api.chezz.exceptions.EmailErrorSintaxException;
import com.api.chezz.exceptions.EmailExistsException;
import com.api.chezz.exceptions.UsernameExistsException;
import com.api.chezz.models.Player;
import com.api.chezz.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void savePlayer(Player player){

        var doesEmailExists = playerRepository.findByEmail(player.getEmail()).isPresent();
        if(doesEmailExists) throw new EmailExistsException();

        System.out.println(player.isEmailSintaxeValid());
        if(!player.isEmailSintaxeValid()) throw new EmailErrorSintaxException();

        var doesUsernameExists = playerRepository.findByUsername(player.getUsername()).isPresent();
        if(doesUsernameExists) throw new UsernameExistsException();

        playerRepository.save(player);

    }
}
