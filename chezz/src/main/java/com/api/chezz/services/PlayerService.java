package com.api.chezz.services;

import com.api.chezz.dtos.PlayerLoginDto;
import com.api.chezz.dtos.SingResponseDto;
import com.api.chezz.exceptions.*;
import com.api.chezz.models.Player;
import com.api.chezz.repositories.PlayerRepository;
import com.api.chezz.repositories.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final SessionService sessionService;

    private final CodeService codeService;
    private final SessionRepository sessionRepository;

    public PlayerService(PlayerRepository playerRepository, SessionService sessionService, CodeService codeService, SessionRepository sessionRepository) {
        this.playerRepository = playerRepository;
        this.sessionService = sessionService;

        this.codeService = codeService;
        this.sessionRepository = sessionRepository;
    }

    public SingResponseDto savePlayer(Player player){

        var doesEmailExists = playerRepository.findByEmail(player.getEmail()).isPresent();
        if(doesEmailExists) throw new EmailExistsException();

        if(!player.isEmailSintaxeValid()) throw new EmailErrorSintaxException();

        var doesUsernameExists = playerRepository.findByUsername(player.getUsername()).isPresent();
        if(doesUsernameExists) throw new UsernameExistsException();

        player.setRating(600); // default rating

        var playerInDB = playerRepository.save(player);
        var sessionID = sessionService.createSession(playerInDB);

        return new SingResponseDto(player.getUsername(), player.getRating(), sessionID);

    }

    public SingResponseDto singin(PlayerLoginDto model){
        var player = playerRepository.findByEmail(model.email()).orElseThrow(LoginFailedException::new);

        if(!player.isLogginValid(model.email(), model.password())) throw new LoginFailedException();

        var sessionId = sessionService.loginValidationSession(player);

        return new SingResponseDto(player.getUsername(), player.getRating(), sessionId);

    }

    public void refinePassword(String code, String email, String newPassword){
        var player = playerRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);

        if(!codeService.validateCode(email, code)) throw new WrongCodeException();

        player.setPassword(newPassword);
        playerRepository.save(player);
    }

}
