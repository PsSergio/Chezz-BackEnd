package com.api.chezz.services;

import com.api.chezz.dtos.PlayInput;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.models.PlayOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HouseValidationService {

    public boolean thereIsSomePieceInHouse(List<PlayOutput> allPlays, PlayInput playInput){ // tests failed

        boolean results = false;
        var targetHouse = playInput.actPosition();

        if(targetHouse.numberHouse() <= 2 || targetHouse.numberHouse() >= 7) results = true;

        var tempPlay = new PlayOutput(null ,null, null);
        for (var play : allPlays) {

            if(Objects.equals(targetHouse.letterHouse(), play.getHouse().letterHouse()) &&
                    Objects.equals(targetHouse.numberHouse(), play.getHouse().numberHouse())) {
                results = true;

                BeanUtils.copyProperties(play, tempPlay);

                continue;
            }

            if(tempPlay.getPiece() == null) {
                continue;
            }

            if(Objects.equals(tempPlay.getPiece().id(), play.getPiece().id())
            && tempPlay.getPiece().pieceType() == play.getPiece().pieceType()
            && tempPlay.getPiece().color() == play.getPiece().color()
            ) results = false;

        }

        return results;
    }

}
