package com.matchmaker.matchmaker.meet;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.matchmaker.matchmaker.game.Game;
import com.matchmaker.matchmaker.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "meet")
public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;
    private String time;
    private boolean aviability;

    @ManyToOne
    private Game game;

    @ManyToMany
    private Set<User> users = new HashSet<User>();

    @OneToOne
    @JoinColumn(name = "creator_user_id", referencedColumnName = "user_id")
    private  User creatorUser;
}