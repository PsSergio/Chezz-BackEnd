package com.api.chezz.services;

import com.api.chezz.dtos.PlayInput;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.models.PlayOutput;
import com.api.chezz.enums.SidePlayerEnum;
import com.api.chezz.exceptions.InvalidPlayException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PiecesValidationService {


    public void validatePawnPlay(PlayInput playInput){
        if(playInput.piece() != PieceTypeEnum.Pawn) return;

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var indexLastPlayLetter = letters.indexOf(playInput.lastPosition().letterHouse());
        var indexActPlayLetter = letters.indexOf(playInput.actPosition().letterHouse());

        var lastNumber = playInput.lastPosition().numberHouse();
        var actNumber = playInput.actPosition().numberHouse();

        var x = letters.indexOf(playInput.lastPosition().letterHouse()) - letters.indexOf(playInput.actPosition().letterHouse());
        var y = playInput.lastPosition().numberHouse() - playInput.actPosition().numberHouse();

        System.out.println(x);
        System.out.println(y);

        if(playInput.move() == MoveTypeEnum.Capture && (Math.abs(x) != Math.abs(y) || Math.abs(x) != 1)) throw new InvalidPlayException();

        if(playInput.move() == MoveTypeEnum.Move && indexLastPlayLetter != indexActPlayLetter) throw new InvalidPlayException();

        if(playInput.sidePlayer() == SidePlayerEnum.White){

            if(lastNumber != 2 && actNumber > lastNumber+1
            || lastNumber == 2 && actNumber > lastNumber+2) throw new InvalidPlayException();

            if(lastNumber < actNumber) return;

        }

        if(playInput.sidePlayer() == SidePlayerEnum.Black){

            if(lastNumber != 7 && actNumber < lastNumber-1
            || lastNumber == 7 && actNumber < lastNumber-2) throw new InvalidPlayException();

            if(lastNumber > actNumber) return;

        }

        throw new InvalidPlayException();

    }
    public void validateKnightPlay (PlayInput playInput){ // test approved

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

    public void validateBishopPlay(PlayInput playInput){ // test approved

        if(playInput.piece() != PieceTypeEnum.Bishop) return;

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var x = letters.indexOf(playInput.lastPosition().letterHouse()) - letters.indexOf(playInput.actPosition().letterHouse());
        var y = playInput.lastPosition().numberHouse() - playInput.actPosition().numberHouse();

        if(Math.abs(x) != Math.abs(y)) throw new InvalidPlayException();
    }

    public void validateRookPlay(PlayInput playInput){ // test approved
        if(playInput.piece() != PieceTypeEnum.Rook) return;

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var x = letters.indexOf(playInput.lastPosition().letterHouse()) - letters.indexOf(playInput.actPosition().letterHouse());
        var y = playInput.lastPosition().numberHouse() - playInput.actPosition().numberHouse();

        if( x == 0 && y != 0 || x != 0 && y == 0) return;

        throw new InvalidPlayException();
    }

    public void validateKingPlay(PlayInput playInput){ // needs to implement castle

        if(playInput.piece() != PieceTypeEnum.King) return;

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var x = letters.indexOf(playInput.lastPosition().letterHouse()) - letters.indexOf(playInput.actPosition().letterHouse());
        var y = playInput.lastPosition().numberHouse() - playInput.actPosition().numberHouse();

        if(x > 1 || y > 1 || x < -1 || y < -1) throw new InvalidPlayException();
    }

    public void validateQueenPlay(PlayInput playInput){ // test approved

        if(playInput.piece() != PieceTypeEnum.Queen) return;

        var letters = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

        var x = letters.indexOf(playInput.lastPosition().letterHouse()) - letters.indexOf(playInput.actPosition().letterHouse());
        var y = playInput.lastPosition().numberHouse() - playInput.actPosition().numberHouse();

        System.out.println(x);
        System.out.println(y);

        if( ( x == 0 && y != 0 || x != 0 && y == 0 )
                || (x >= -1 && x <= 1 && y >= -1 && y <= 1)
                || ( Math.abs(x) == Math.abs(y) ) ) return;

        throw new InvalidPlayException();


    }


}
