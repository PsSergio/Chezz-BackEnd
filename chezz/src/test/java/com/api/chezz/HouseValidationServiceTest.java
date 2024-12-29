package com.api.chezz;

import com.api.chezz.dtos.HouseDetailsDto;
import com.api.chezz.dtos.PieceDetailsDto;
import com.api.chezz.dtos.PlayInput;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;
import com.api.chezz.models.PlayOutput;
import com.api.chezz.services.HouseValidationService;
import com.api.chezz.services.PiecesValidationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HouseValidationServiceTest {

    @Test
    void validateThereIsSomePieceInTargetHouse(){
        List<PlayOutput> chessMoves = new ArrayList<>();

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Pawn, 4), new HouseDetailsDto("d", 4)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Pawn, 4), new HouseDetailsDto("d", 5)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Pawn, 3), new HouseDetailsDto("c", 4)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Pawn, 5), new HouseDetailsDto("e", 6)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Knight, 2), new HouseDetailsDto("f", 3)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Knight, 2), new HouseDetailsDto("f", 6)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Bishop, 1), new HouseDetailsDto("g", 5)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Bishop, 2), new HouseDetailsDto("e", 7)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Knight, 1), new HouseDetailsDto("c", 3)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Castle, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.King, 1), new HouseDetailsDto("g", 8)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Pawn, 5), new HouseDetailsDto("e", 3)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Knight, 1), new HouseDetailsDto("d", 7)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Capture, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Pawn, 3), new HouseDetailsDto("d", 5)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Capture, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Pawn, 5), new HouseDetailsDto("d", 5)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Bishop, 2), new HouseDetailsDto("b", 5)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Pawn, 3), new HouseDetailsDto("c", 6)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Bishop, 2), new HouseDetailsDto("d", 3)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Pawn, 2), new HouseDetailsDto("b", 6)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Queen, 1), new HouseDetailsDto("c", 2)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Bishop, 1), new HouseDetailsDto("b", 7)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Castle, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.King, 1), new HouseDetailsDto("g", 1)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Rook, 2), new HouseDetailsDto("e", 8)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Capture, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Bishop, 1), new HouseDetailsDto("f", 6)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Capture, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Knight, 1), new HouseDetailsDto("f", 6)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Knight, 2), new HouseDetailsDto("e", 5)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Move, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Pawn, 3), new HouseDetailsDto("c", 5)));

        chessMoves.add(new PlayOutput(MoveTypeEnum.Capture, new PieceDetailsDto(SidePlayerEnum.White, PieceTypeEnum.Pawn, 4), new HouseDetailsDto("c", 5)));
        chessMoves.add(new PlayOutput(MoveTypeEnum.Capture, new PieceDetailsDto(SidePlayerEnum.Black, PieceTypeEnum.Bishop, 2), new HouseDetailsDto("c", 5)));


        var service = new HouseValidationService();

        var lastPosition = new HouseDetailsDto("d", 3);
        var targetPosition = new HouseDetailsDto("e", 8);

        var play = new PlayInput(SidePlayerEnum.White, MoveTypeEnum.Move, PieceTypeEnum.Pawn, targetPosition, lastPosition);
        boolean results = service.thereIsSomePieceInHouse(chessMoves, play);

        System.out.println("final: "+results);
    }

}
