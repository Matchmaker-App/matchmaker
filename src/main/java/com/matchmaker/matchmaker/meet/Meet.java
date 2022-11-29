package com.matchmaker.matchmaker.meet;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.matchmaker.matchmaker.game.Game;
import com.matchmaker.matchmaker.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "meets")
public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meet_id")
    private Long id;

    private String date;
    private String time;
    private boolean aviability;

    @ManyToOne
    private Game game;

    @ManyToMany
    @JoinTable(name = "user_meets",
            joinColumns = @JoinColumn(name = "meet_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<User>();

    @OneToOne
    @JoinColumn(name = "creator_user_id", referencedColumnName = "user_id")
    private  User creatorUser;

    public Meet(String date,String time,boolean aviability){
        this.date = date;
        this.time = time;
        this.aviability = aviability;
    }
}