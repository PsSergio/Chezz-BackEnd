package com.api.chezz.services;

import com.api.chezz.exceptions.EmailNotFoundException;
import com.api.chezz.exceptions.WrongCodeException;
import com.api.chezz.models.CodeValidation;
import com.api.chezz.models.Player;
import com.api.chezz.repositories.CodeRepository;
import com.api.chezz.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    private final CodeRepository codeRepository;
    private final PlayerRepository playerRepository;

    private final EmailService emailService;

    public CodeService(CodeRepository codeRepository, PlayerRepository playerRepository, EmailService emailService) {
        this.codeRepository = codeRepository;
        this.playerRepository = playerRepository;
        this.emailService = emailService;
    }

    public String createCode(Player player){
        var code = new CodeValidation();
        code.setPlayer(player);
        code.setCode();

        codeRepository.save(code);
        return code.getRandomCode();
    }

    public void sendCodeToEmail(String email){

        var player = playerRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);

        var codeByEmail = codeRepository.findByPlayer(player);
        codeByEmail.ifPresent(codeRepository::delete);

        var code = createCode(player);

        emailService.sendEmail(email, "CÓDIGO DE VALIDAÇÃO - CHEZZ", "Aqui está o seu código para validação: " + code);

    }

    public void validateCode(String email, String _code){

        var player = playerRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);

        var code = codeRepository.findByPlayer(player);

        if(code.isEmpty()) throw new WrongCodeException();

        if(!code.get().getRandomCode().equals(_code)) throw new WrongCodeException();

    }

}
