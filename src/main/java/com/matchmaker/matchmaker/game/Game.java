package com.matchmaker.matchmaker.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matchmaker.matchmaker.meet.Meet;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;
    private String name;
    private Double rating;
    private String description;
    private String platform;

    @OneToMany
    @JsonIgnore
    private List<Meet> meets;


}