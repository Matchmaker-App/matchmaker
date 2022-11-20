package com.matchmaker.matchmaker.meet;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "meets")
public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String date;
    private String time;
    private boolean aviability;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "game_id", referencedColumnName = "id")
//   // private Game game;
//
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//    @JoinTable(name = "meet_users",
//            joinColumns = @JoinColumn(name = "meets_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<User> usersReady = new HashSet<User>();



}
