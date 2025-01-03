package com.api.chezz.controllers;

import com.api.chezz.services.CodeService;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("code/")
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping("sendEmail/{email}")
    public ResponseEntity<Void> sendEmail(@PathVariable(value = "email") String email){
        codeService.sendCodeToEmail(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("validate/{email}/{code}")
    public ResponseEntity<Void> validateCode(@PathVariable(value = "email") String email, @PathVariable(value = "code") String code){
        codeService.validateCode(email, code);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
