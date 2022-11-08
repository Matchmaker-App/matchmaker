package com.matchmaker.matchmaker.meet;

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

public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String date;
    private String time;
    private boolean aviability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "meet")
    private Set<User> usersReady = new HashSet<User>();

//    Not sure if this works as expected
//
//    private void addUser(User user){
//        this.usersReady.add(user);
//        user.getMeets().add(this);
//    }
//
//    private void removeUser(User user){
//        this.usersReady.remove(user);
//        user.getMeets().remove(this);
//    }

}
