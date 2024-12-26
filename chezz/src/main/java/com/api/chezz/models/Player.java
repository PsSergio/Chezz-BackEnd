package com.api.chezz.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(name = "Player")
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "owner")
    private List<Match> ownerMatches;

    @OneToMany(mappedBy = "guest")
    private List<Match> guestMatches;

    public Boolean isEmailSintaxeValid(){
        var regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(this.email)
                .matches();
    }

}
