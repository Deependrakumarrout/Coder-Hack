package com.crio.in.CoderHack.CoderHack.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("user_id")
    private Long id;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("score")
    private int score;

    @JsonProperty("badges")
    private String badges;


}
