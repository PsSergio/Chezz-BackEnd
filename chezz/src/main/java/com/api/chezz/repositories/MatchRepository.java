package com.api.chezz.repositories;

import com.api.chezz.dtos.FindingMatchDto;
import com.api.chezz.models.Match;
import com.api.chezz.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(
            value = "select MatchGame.id, MatchGame.owner_id, MatchGame.guest_id from MatchGame \n" +
                    "inner join Player \n" +
                    "on MatchGame.owner_id = Player.id\n" +
                    "where Player.rating >= ?1 and Player.rating <= ?2 and MatchGame.guest_id is null\n" +
                    "order by Player.rating asc",
            nativeQuery = true)
    List<Match> findingMatchByRating(Integer minValue, Integer maxValue);

    Optional<Match> findByGuest(Player guest);
    Optional<Match> findByOwner(Player owner);
}
