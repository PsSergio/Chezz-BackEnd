package com.api.chezz.models;


import com.api.chezz.dtos.HouseDetailsDto;
import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayOutput {
    private SidePlayerEnum color;
    private MoveTypeEnum move;
    private PieceTypeEnum piece;
    private HouseDetailsDto house;

    public PlayOutput(SidePlayerEnum color, MoveTypeEnum move, PieceTypeEnum piece, HouseDetailsDto house) {
        this.color = color;
        this.move = move;
        this.piece = piece;
        this.house = house;
    }
}
