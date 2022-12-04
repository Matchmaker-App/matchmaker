package com.matchmaker.matchmaker.meet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetDTO {
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String time;
    @NotEmpty
    private int numberOfPlayers;
    @NotEmpty
    private boolean aviability;
    @NotEmpty
    private String game;

}
