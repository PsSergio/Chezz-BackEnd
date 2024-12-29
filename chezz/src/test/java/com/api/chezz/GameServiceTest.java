package com.api.chezz;

import com.api.chezz.dtos.HouseDetailsDto;
import com.api.chezz.dtos.PlayInput;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;
import com.api.chezz.models.PlayOutput;
import com.api.chezz.services.GameService;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GameServiceTest {

    @Test
    void validateThereIsSomePieceInTargetHouse(){
        List<PlayOutput> chessMoves = new ArrayList<>();

        // 1. e4 d5
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Pawn, new HouseDetailsDto("e", 4)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Pawn, new HouseDetailsDto("d", 5)));

        // 2. exd5 Qxd5
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Capture, PieceTypeEnum.Pawn, new HouseDetailsDto("d", 5)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Capture, PieceTypeEnum.Queen, new HouseDetailsDto("d", 5)));

        // 3. Nc3 Qa5
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Knight, new HouseDetailsDto("c", 3)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Queen, new HouseDetailsDto("a", 5)));

        // 4. d3 e5
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Pawn, new HouseDetailsDto("d", 3)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Pawn, new HouseDetailsDto("e", 5)));

        // 5. Bd2 Qb6
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Bishop, new HouseDetailsDto("d", 2)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Queen, new HouseDetailsDto("b", 6)));

        // 6. Nf3 Nd7
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Knight, new HouseDetailsDto("f", 3)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Knight, new HouseDetailsDto("d", 7)));

        // 7. Be2 Qxb2
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Bishop, new HouseDetailsDto("e", 2)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Capture, PieceTypeEnum.Queen, new HouseDetailsDto("b", 2)));

        // 8. O-O Qb6
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Castle, PieceTypeEnum.King, new HouseDetailsDto("g", 1)));  // Pequeno roque
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Queen, new HouseDetailsDto("b", 6)));

        // 9. d4 exd4
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Pawn, new HouseDetailsDto("d", 4)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Capture, PieceTypeEnum.Pawn, new HouseDetailsDto("d", 4)));

        // 10. Nd5 Qd6
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Knight, new HouseDetailsDto("d", 5)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Queen, new HouseDetailsDto("d", 6)));

        // 11. Bc4 c6
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Bishop, new HouseDetailsDto("c", 4)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Pawn, new HouseDetailsDto("c", 6)));

        // 12. Qe1+ Be7
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Queen, new HouseDetailsDto("e", 1)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Bishop, new HouseDetailsDto("e", 7)));

        // 13. Bb4 Qe6
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Bishop, new HouseDetailsDto("b", 4)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Queen, new HouseDetailsDto("e", 6)));

        // 14. Nc7+ Kf8
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Capture, PieceTypeEnum.Knight, new HouseDetailsDto("c", 7)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.King, new HouseDetailsDto("f", 8)));

        // 15. Nxe6+ fxe6
        chessMoves.add(new PlayOutput(SidePlayerEnum.White, MoveTypeEnum.Capture, PieceTypeEnum.Knight, new HouseDetailsDto("e", 6)));
        chessMoves.add(new PlayOutput(SidePlayerEnum.Black, MoveTypeEnum.Capture, PieceTypeEnum.Pawn, new HouseDetailsDto("e", 6)));

        var service = new GameService();

        var targetPosition = new HouseDetailsDto("d", 4);
        var lastPosition = new HouseDetailsDto("e", 2);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Pawn, targetPosition, lastPosition);
        boolean results = service.thereIsSomePieceInHouse(chessMoves, play);

        System.out.println("final: "+results);
    }

    @Test
    void validateKgnihtMove(){

        var service = new GameService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("f", 2);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Knight, targetPosition, lastPosition);

        service.validateKnightPlay(play);
    }

    @Test
    void validateBishopMove(){

        var service = new GameService();

        var targetPosition = new HouseDetailsDto("d", 5);
        var lastPosition = new HouseDetailsDto("a", 2);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Bishop, targetPosition, lastPosition);

        service.validateBishopPlay(play);

    }

    @Test
    void validateRookMove(){

        var service = new GameService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("a", 4);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Rook, targetPosition, lastPosition);

        service.validateRookPlay(play);

    }

    @Test
    void validateKingMove(){

        var service = new GameService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("f", 3);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.King, targetPosition, lastPosition);

        service.validateKingPlay(play);

    }

    @Test
    void validateQueenMove(){

        var service = new GameService();

        var targetPosition = new HouseDetailsDto("e", 4);
        var lastPosition = new HouseDetailsDto("e", 3);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Queen, targetPosition, lastPosition);

        service.validateQueenPlay(play);

    }

    @Test
    void validatePawnMove(){

        var service = new GameService();

        var lastPosition = new HouseDetailsDto("e", 7);
        var targetPosition = new HouseDetailsDto("e", 5);

        var play = new PlayInput(SidePlayerEnum.Black, MoveTypeEnum.Move, PieceTypeEnum.Pawn, targetPosition, lastPosition);

        service.validatePawnPlay(play);

    }
}
