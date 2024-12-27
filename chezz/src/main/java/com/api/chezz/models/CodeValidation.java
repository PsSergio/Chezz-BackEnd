package com.api.chezz.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Entity
@Table(name = "CodeValidation")
@Getter
@Setter
public class CodeValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "playerId")
    @OneToOne
    private Player player;

    @Column(name = "random_code")
    private String randomCode;

    public void setCode(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        this.randomCode = String.format("%06d", number);

    }
}
