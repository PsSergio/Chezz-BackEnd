package com.api.chezz.dtos;


import com.api.chezz.exceptions.InvalidPlayException;

public record HouseDetailsDto (String letterHouse, Integer numberHouse){
    public HouseDetailsDto {
        if(!letterHouse.matches("[a-hA-H]") || numberHouse < 1 || numberHouse > 8){
            throw new InvalidPlayException();
        }
    }
}
