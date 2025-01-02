package com.api.chezz.infra;

import com.api.chezz.dtos.ExceptionDto;
import com.api.chezz.exceptions.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestHandlerExceptions {

    // Email Exception

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<ExceptionDto> EmailExistsHandler(EmailExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("EmailExists", 400, e.getMessage()));
    }

    @ExceptionHandler(EmailErrorSintaxException.class)
    public ResponseEntity<ExceptionDto> EmailErrorSintaxHandler(EmailErrorSintaxException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("EmailWrongSyntax", 400, e.getMessage()));
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ExceptionDto> EmailNotFoundSintaxHandler(EmailNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto("EmailNotFound", 404, e.getMessage()));
    }

    // Username Exception
    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<ExceptionDto> UsernameExistsHandler(UsernameExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("UsernameExists", 400, e.getMessage()));
    }

    // Session Exception

    @ExceptionHandler(SessionExpiredException.class)
    public ResponseEntity<ExceptionDto> SessionExpiredHandler(SessionExpiredException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionDto("SessionExpired", 401, e.getMessage()));
    }

    @ExceptionHandler(SessionNotFoundException.class)
    public ResponseEntity<ExceptionDto> SessionNotFoundHandler(SessionNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto("SessionNotFound", 404, e.getMessage()));
    }

    // Login Exceptions

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<ExceptionDto> LoginFailedHandler(LoginFailedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("LoginFailed", 400, e.getMessage()));
    }

    @ExceptionHandler(UserAlreadyLoggedException.class)
    public ResponseEntity<ExceptionDto> UserAlreadyLoggedHandler(UserAlreadyLoggedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("UserAlreadyLogged", 400, e.getMessage()));
    }

    // Code Exception

    @ExceptionHandler(WrongCodeException.class)
    public ResponseEntity<ExceptionDto> WrongCodeHandler(WrongCodeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("WrongCode", 400, e.getMessage()));
    }

    // Match Exception

    @ExceptionHandler(UserAlreadyInMatchException.class)
    public ResponseEntity<ExceptionDto> UserAlreadyInMatchHandler(UserAlreadyInMatchException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("UserAlreadyInMatch", 400, e.getMessage()));
    }

    @ExceptionHandler(MatchNotFoundException.class)
    public ResponseEntity<ExceptionDto> MatchNotFoundHandler(MatchNotFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("MatchNotFound", 400, e.getMessage()));
    }

    // Play Exception

    @ExceptionHandler(InvalidPlayException.class)
    public ResponseEntity<ExceptionDto> InvalidPlayHandler(InvalidPlayException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto("InvalidPlay", 400, e.getMessage()));
    }
}
