package com.api.chezz.controllers;

import com.api.chezz.dtos.PlayerLoginDto;
import com.api.chezz.models.Player;
import com.api.chezz.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("login")
    public ResponseEntity<Void> singinPlayer(@RequestBody PlayerLoginDto model){
        playerService.singin(model);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
