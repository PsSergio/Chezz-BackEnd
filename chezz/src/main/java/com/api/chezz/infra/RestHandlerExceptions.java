package com.api.chezz.infra;

import com.api.chezz.dtos.ExceptionDto;
import com.api.chezz.exceptions.EmailExistsException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestHandlerExceptions {

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<ExceptionDto> EmailExistsHandler(EmailExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("EmailExists", 400, e.getMessage()));
    }

}
