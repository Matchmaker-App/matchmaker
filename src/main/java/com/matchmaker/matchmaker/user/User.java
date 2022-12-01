package com.matchmaker.matchmaker.user;

import com.matchmaker.matchmaker.meet.Meet;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.security.AuthProvider;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
//    private String imageUrl;

    @JsonIgnore
    private String password;
    private String email;
//    private AuthProvider provider;
//    private String providerId;

    private String firstName;
    private String lastName;
    private LocalDate birthDay;

    @ManyToMany(mappedBy = "users")
    private Set<Meet> meets;

}