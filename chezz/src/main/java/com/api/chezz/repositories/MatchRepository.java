package com.api.chezz.repositories;

import com.api.chezz.dtos.FindingMatchDto;
import com.api.chezz.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(
            value = "select MatchGame.id, Player.username, Player.rating from MatchGame \n" +
                    "inner join Player \n" +
                    "on MatchGame.owner_id = Player.id\n" +
                    "where Player.rating >= ?1 and Player.rating <= ?2\n" +
                    "order by Player.rating asc",
            nativeQuery = true)
    List<FindingMatchDto> findingMatchByRating(Integer minValue, Integer maxValue);

}
