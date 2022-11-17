package com.matchmaker.matchmaker.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
}
