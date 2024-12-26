package com.api.chezz.controllers;

import com.api.chezz.models.Player;
import com.api.chezz.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player/")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("save")
    public ResponseEntity<Void> singupPlayer(@RequestBody Player player){
        playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
