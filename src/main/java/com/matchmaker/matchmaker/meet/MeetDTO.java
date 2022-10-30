package com.matchmaker.matchmaker.meet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetDTO {
    private Long id;
    private LocalDateTime dateAndTime;
    private Game game;
    private Set<User> usersReady = new HashSet<User>();



}
