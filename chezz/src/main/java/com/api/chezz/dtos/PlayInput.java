package com.api.chezz.dtos;

import com.api.chezz.enums.SidePlayerEnum;

public record PlayInput(SidePlayerEnum sidePlayer, String prefix, HouseDetailsDto actPosition, HouseDetailsDto lastPosition) {
}
