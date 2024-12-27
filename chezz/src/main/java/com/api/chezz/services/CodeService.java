package com.api.chezz.services;

import com.api.chezz.models.CodeValidation;
import com.api.chezz.models.Player;
import com.api.chezz.repositories.CodeRepository;
import com.api.chezz.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    private final CodeRepository codeRepository;
    private final PlayerRepository playerRepository;

    public CodeService(CodeRepository codeRepository, PlayerRepository playerRepository) {
        this.codeRepository = codeRepository;
        this.playerRepository = playerRepository;
    }

    public String createCode(Player player){
        var code = new CodeValidation();
        code.setPlayer(player);
        code.setCode();

        codeRepository.save(code);
        return code.getRandomCode();
    }


}
