package com.api.chezz.controllers;

import com.api.chezz.dtos.FindingMatchDto;
import com.api.chezz.dtos.MatchFoundDto;
import com.api.chezz.models.Player;
import com.api.chezz.services.MatchService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("match/")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("find/{id}")
    public ResponseEntity<MatchFoundDto> findMatchByRating(@PathVariable(value = "id") Player player){
        return ResponseEntity.status(HttpStatus.OK).body(matchService.findMatch(player));
    }
}
