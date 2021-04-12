package com.smhrd.model.assignment.stress.hate;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StressHateSaveDto {
    private String hate;
    private User user;

    public StressHate toEntity() {
        return StressHate.builder()
                .user(user)
                .hate(hate)
                .build();
    }
}
