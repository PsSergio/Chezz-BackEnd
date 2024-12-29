package com.api.chezz.services;

import com.api.chezz.dtos.PlayInput;
import com.api.chezz.models.PlayOutput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HouseValidationService {

    public boolean thereIsSomePieceInHouse(List<PlayOutput> allPlays, PlayInput playInput){ // tests failed

        boolean results = false;
        var targetHouse = playInput.actPosition();

        var tempPlay = new PlayOutput(null ,null, null, null);
        for (var play : allPlays) {


            if(Objects.equals(targetHouse.letterHouse(), play.getHouse().letterHouse()) &&
                    Objects.equals(targetHouse.numberHouse(), play.getHouse().numberHouse())) {
                results = true;
                tempPlay.setColor(play.getColor());
                tempPlay.setHouse(play.getHouse());
                tempPlay.setPiece(play.getPiece());
                tempPlay.setMove(play.getMove());
                System.out.println(play.getPiece()+" "+play.getHouse().letterHouse()+play.getHouse().numberHouse()+" "+results);

                continue;
            }
            System.out.println(play.getPiece()+" "+play.getHouse().letterHouse()+play.getHouse().numberHouse()+" "+results);

            if(tempPlay.getPiece() == play.getPiece() // to validate that house is clean after a move
                    && tempPlay.getColor() == play.getColor()
                    && !Objects.equals(tempPlay.getHouse().numberHouse(), play.getHouse().numberHouse())){
                results = false;
            }



        }

        return results;
    }

}
