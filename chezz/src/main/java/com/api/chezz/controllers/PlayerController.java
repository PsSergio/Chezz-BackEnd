package com.api.chezz.controllers;

import com.api.chezz.dtos.PlayerLoginDto;
import com.api.chezz.dtos.SingResponseDto;
import com.api.chezz.models.Player;
import com.api.chezz.services.PlayerService;
import com.api.chezz.services.SessionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("player/")
public class PlayerController {

    private final PlayerService playerService;
    private final SessionService sessionService;

    public PlayerController(PlayerService playerService, SessionService sessionService) {
        this.playerService = playerService;
        this.sessionService = sessionService;
    }

    @PostMapping("save")
    public ResponseEntity<SingResponseDto> singupPlayer(@RequestBody Player player){

        return ResponseEntity.status(HttpStatus.OK).body(playerService.savePlayer(player));
    }

    @GetMapping("login/{email}/{password}")
    public ResponseEntity<SingResponseDto> singinPlayer(@PathVariable(value = "email") String email, @PathVariable(value="password") String password){
        var model = new PlayerLoginDto(email, password);
        return ResponseEntity.status(HttpStatus.OK).body(playerService.singin(model));
    }

    @PutMapping("refine/{code}")
    public ResponseEntity<Void> refinePassword(@PathVariable(value = "code") String code, @RequestBody PlayerLoginDto model){
        playerService.refinePassword(code, model.email(), model.password());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("logout/{id}")
    public ResponseEntity<Void> logout (@PathVariable(value = "id") Long sessionId){
        sessionService.logout(sessionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
