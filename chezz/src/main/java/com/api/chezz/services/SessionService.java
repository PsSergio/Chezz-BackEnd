package com.api.chezz.services;

import com.api.chezz.exceptions.SessionExpiredException;
import com.api.chezz.exceptions.SessionNotFoundException;
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

    public Long createSession(Player player){

        var session = new Session();
        session.setPlayer(player);
        session.setAllDatesTime();

        return sessionRepository.save(session).getId();
    }

    public void updateSession(Session session){

        session.setAllDatesTime();
        sessionRepository.save(session);

    }

    public Long loginValidationSession(Player _player){

        var session = sessionRepository.findByPlayer(_player);

        if(session.isEmpty()) {
            return createSession(_player);
        }

        if(session.get().isSessionValid()) throw new UserAlreadyLoggedException();

        sessionRepository.delete(session.get());

        return createSession(_player);

    }

    public void validateSession(Session session){

        if(session.isSessionValid()){
            updateSession(session);
            return;
        }

        sessionRepository.delete(session);
        throw new SessionExpiredException();

    }

    public void logout(Long sessionId){
        var session = sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);

        sessionRepository.delete(session);
    }
}
