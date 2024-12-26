package com.api.chezz.infra;

import com.api.chezz.dtos.ExceptionDto;
import com.api.chezz.exceptions.EmailErrorSintaxException;
import com.api.chezz.exceptions.EmailExistsException;
import com.api.chezz.exceptions.UsernameExistsException;
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

    @ExceptionHandler(EmailErrorSintaxException.class)
    public ResponseEntity<ExceptionDto> EmailErrorSintaxHandler(EmailErrorSintaxException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("EmailWrongSyntax", 400, e.getMessage()));
    }

    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<ExceptionDto> UsernameExistsHandler(UsernameExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("UsernameExists", 400, e.getMessage()));
    }
}
