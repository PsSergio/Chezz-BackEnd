package com.api.chezz.repositories;

import com.api.chezz.models.Player;
import com.api.chezz.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> findByPlayer(Player player);

}
