package com.api.chezz.dtos;

import com.api.chezz.enums.PieceTypeEnum;
import com.api.chezz.enums.SidePlayerEnum;

public record PieceDetailsDto(SidePlayerEnum color, PieceTypeEnum pieceType, Integer id) {
}
