package com.api.chezz.services;

import com.api.chezz.dtos.PlayInput;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.models.PlayOutput;
import com.api.chezz.enums.SidePlayerEnum;
import com.api.chezz.exceptions.InvalidPlayException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {

//    public PlayOutput newPlay(PlayInput playInput){
//
//    }

    public boolean thereIsSomePieceInHouse(List<PlayOutput> allPlays, PlayInput playInput){

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

    public void validatePawnPlay(PlayInput playInput){
        if(playInput.piece() != PieceTypeEnum.Pawn) return;

        if(playInput.sidePlayer() == SidePlayerEnum.White){

            if(playInput.lastPosition().numberHouse() == 2
                    && playInput.actPosition().numberHouse() > 4) throw new InvalidPlayException();

            if(playInput.actPosition().numberHouse() != playInput.lastPosition().numberHouse()+1 && playInput.move() == MoveTypeEnum.Move)
                throw new InvalidPlayException();
        }

        if(playInput.sidePlayer() == SidePlayerEnum.Black){

            if(playInput.lastPosition().numberHouse() == 7
                    && playInput.actPosition().numberHouse() < 5) throw new InvalidPlayException();

            if(playInput.actPosition().numberHouse() != playInput.lastPosition().numberHouse()-1 && playInput.move() == MoveTypeEnum.Move)
                throw new InvalidPlayException();

        }


    }
    public void validateKnightPlay (PlayInput playInput){

        if(playInput.piece() != PieceTypeEnum.Knight) return;

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var indexLastPlayLetter = letters.indexOf(playInput.lastPosition().letterHouse());
        var indexActPlayLetter = letters.indexOf(playInput.actPosition().letterHouse());

        var lastNumber = playInput.lastPosition().numberHouse();
        var actNumber = playInput.actPosition().numberHouse();


        var possibleMatches = Arrays.asList(
                new int[]{2, -1}, new int[]{2, 1}, new int[]{-2, -1}, new int[]{-2, 1},
                new int[]{1, 2}, new int[]{1, -2}, new int[]{-1, 2}, new int[]{-1, -2});

        var x = indexLastPlayLetter - indexActPlayLetter;
        var y = lastNumber - actNumber;

        for (var possibleMatch : possibleMatches){

            if(Arrays.equals(possibleMatch, new int[]{x, y})) return;

        }

        throw new InvalidPlayException();

    }

    public void validateBishopPlay(PlayInput playInput){

        if(playInput.piece() != PieceTypeEnum.Bishop) return;

        // validar direçao do movimento <- -> cima ou baixo

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var x = letters.indexOf(playInput.lastPosition().letterHouse()) - letters.indexOf(playInput.actPosition().letterHouse());
        var y = playInput.lastPosition().numberHouse() - playInput.actPosition().numberHouse();

        if(x != y) throw new InvalidPlayException();
    }


}
