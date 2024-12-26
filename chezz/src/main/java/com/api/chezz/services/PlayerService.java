package com.api.chezz.services;

import com.api.chezz.models.Player;
import com.api.chezz.repositories.PlayerRepository;

public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void savePlayer(Player player){

    }
}
