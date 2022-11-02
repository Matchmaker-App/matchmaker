package com.matchmaker.matchmaker.meet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String time;
    @ManyToOne()
    private Game game;
    @ManyToMany(mappedBy = "meet")
    private Set<User> usersReady = new HashSet<User>();
}
