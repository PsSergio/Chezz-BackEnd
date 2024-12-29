package com.api.chezz.dtos;

import com.api.chezz.enums.MoveTypeEnum;
import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;

public record PlayInput(SidePlayerEnum sidePlayer, MoveTypeEnum move, PieceTypeEnum piece, HouseDetailsDto actPosition, HouseDetailsDto lastPosition) {
}
