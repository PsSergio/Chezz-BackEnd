package com.api.chezz.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MatchGame")
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private Player owner;

    @JoinColumn(name = "guest_id")
    @ManyToOne
    private Player guest;

}
