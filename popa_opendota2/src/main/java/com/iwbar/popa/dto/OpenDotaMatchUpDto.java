package com.iwbar.popa.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenDotaMatchUpDto {
    @JsonProperty("hero_id")
    private int heroId;

    @JsonProperty("games_played")
    private int gamesPlayed;

    @JsonProperty("wins")
    private int wins;

    public double getWinRate() {
        double popa = 0;
        if (gamesPlayed > 0) {
            popa = (double) wins / gamesPlayed * 100;
        }
        return popa;
    }
}
