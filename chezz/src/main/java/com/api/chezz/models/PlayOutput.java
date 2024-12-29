package com.api.chezz.models;


import com.api.chezz.dtos.HouseDetailsDto;
import com.api.chezz.dtos.PieceDetailsDto;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayOutput {
    private MoveTypeEnum move;
    private PieceDetailsDto piece;
    private HouseDetailsDto house;

    public PlayOutput(MoveTypeEnum move, PieceDetailsDto piece, HouseDetailsDto house) {
        this.move = move;
        this.piece = piece;
        this.house = house;
    }
}
