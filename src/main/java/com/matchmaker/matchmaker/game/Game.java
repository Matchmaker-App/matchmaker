package com.matchmaker.matchmaker.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matchmaker.matchmaker.meet.Meet;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;
    private String name;
    private String genre;
    private String platform;

    @OneToMany(mappedBy = "game")
    @JsonIgnore
    private List<Meet> meets;


}