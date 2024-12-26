package com.api.chezz.services;

import com.api.chezz.exceptions.SessionExpiredException;
import com.api.chezz.exceptions.UserAlreadyLoggedException;
import com.api.chezz.models.Player;
import com.api.chezz.models.Session;
import com.api.chezz.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void createSession(Player player){

        var session = new Session();
        session.setPlayer(player);
        session.setAllDatesTime();

        sessionRepository.save(session);
    }

    public void updateSession(Session session){

        session.setAllDatesTime();
        sessionRepository.save(session);

    }

    public void loginValidationSession(Player _player){

        var session = sessionRepository.findByPlayer(_player);

        if(session.isEmpty()) {
            createSession(_player);
            return;
        }

        if(session.get().isSessionValid()) throw new UserAlreadyLoggedException();

        sessionRepository.delete(session.get());

        createSession(_player);

    }

    public void validateSession(Session session){

        if(session.isSessionValid()){
            updateSession(session);
            return;
        }

        sessionRepository.delete(session);
        throw new SessionExpiredException();

    }
}
