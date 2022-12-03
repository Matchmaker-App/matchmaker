package com.matchmaker.matchmaker.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matchmaker.matchmaker.meet.Meet;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id")
    private String id;
    private String name;
    private String email;
    private Boolean emailVerified = false;
    private String imageUrl;
    @JsonIgnore
    private String password = null;
    private AuthProvider provider;
    private String providerId;
//    private String firstName;
//    private String lastName;
//    private LocalDate birthDay;

    @ManyToMany(mappedBy = "users")
    private Set<Meet> meets;

}