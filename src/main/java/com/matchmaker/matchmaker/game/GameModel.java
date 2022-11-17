package com.matchmaker.matchmaker.game;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "Game")
public class GameModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "game_id")
        private Long id;
        @Column(length = 30)
        private String name;
        @Column(length = 30)
        private Double rating;
        @Column(length = 30)
        private String description;
        @Column(length = 30)
        private String platform;

    @Override
    public String toString() {
        return "GameModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
