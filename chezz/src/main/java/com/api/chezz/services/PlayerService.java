package com.api.chezz.services;

import com.api.chezz.dtos.PlayerLoginDto;
import com.api.chezz.exceptions.EmailErrorSintaxException;
import com.api.chezz.exceptions.EmailExistsException;
import com.api.chezz.exceptions.LoginFailedException;
import com.api.chezz.exceptions.UsernameExistsException;
import com.api.chezz.models.Player;
import com.api.chezz.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final SessionService sessionService;

    public PlayerService(PlayerRepository playerRepository, SessionService sessionService) {
        this.playerRepository = playerRepository;
        this.sessionService = sessionService;

    }

    public void savePlayer(Player player){

        var doesEmailExists = playerRepository.findByEmail(player.getEmail()).isPresent();
        if(doesEmailExists) throw new EmailExistsException();

        System.out.println(player.isEmailSintaxeValid());
        if(!player.isEmailSintaxeValid()) throw new EmailErrorSintaxException();

        var doesUsernameExists = playerRepository.findByUsername(player.getUsername()).isPresent();
        if(doesUsernameExists) throw new UsernameExistsException();

        var playerInDB = playerRepository.save(player);
        sessionService.createSession(playerInDB);

    }

    public void singin(PlayerLoginDto model){
        var player = playerRepository.findByEmail(model.email()).orElseThrow(LoginFailedException::new);

        if(!player.isLogginValid(model.email(), model.password())) throw new LoginFailedException();

        sessionService.loginValidationSession(player);

    }
}
