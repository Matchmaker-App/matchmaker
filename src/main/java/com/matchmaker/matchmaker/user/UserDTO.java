package com.matchmaker.matchmaker.user;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;

    public static UserDTO dateTransferUser(User user){
        return UserDTO.builder()
                .id(Long.valueOf(user.getId()))
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

}
