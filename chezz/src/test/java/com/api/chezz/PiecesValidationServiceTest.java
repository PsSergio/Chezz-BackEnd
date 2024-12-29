package com.api.chezz;

import com.api.chezz.dtos.HouseDetailsDto;
import com.api.chezz.dtos.PlayInput;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;
import com.api.chezz.models.PlayOutput;
import com.api.chezz.services.PiecesValidationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PiecesValidationServiceTest {

    @Test
    void validateKgnihtMove(){

        var service = new PiecesValidationService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("f", 2);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Knight, targetPosition, lastPosition);

        service.validateKnightPlay(play);
    }

    @Test
    void validateBishopMove(){

        var service = new PiecesValidationService();

        var targetPosition = new HouseDetailsDto("d", 5);
        var lastPosition = new HouseDetailsDto("a", 2);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Bishop, targetPosition, lastPosition);

        service.validateBishopPlay(play);

    }

    @Test
    void validateRookMove(){

        var service = new PiecesValidationService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("a", 4);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Rook, targetPosition, lastPosition);

        service.validateRookPlay(play);

    }

    @Test
    void validateKingMove(){

        var service = new PiecesValidationService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("f", 3);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.King, targetPosition, lastPosition);

        service.validateKingPlay(play);

    }

    @Test
    void validateQueenMove(){

        var service = new PiecesValidationService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("e", 3);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Queen, targetPosition, lastPosition);

        service.validateQueenPlay(play);

    }

    @Test
    void validatePawnMove(){

        var service = new PiecesValidationService();

        var lastPosition = new HouseDetailsDto("e", 7);
        var targetPosition = new HouseDetailsDto("e", 5);

        var play = new PlayInput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Pawn, targetPosition, lastPosition);

        service.validatePawnPlay(play);

    }
}
