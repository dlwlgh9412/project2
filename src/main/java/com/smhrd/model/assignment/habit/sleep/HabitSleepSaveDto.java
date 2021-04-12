package com.smhrd.model.assignment.habit.sleep;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitSleepSaveDto {
    private User user;
    private String regular;
    private String caffeine;
    private String hour;

    public HabitSleep toEntity() {
        return HabitSleep.builder()
                .user(user)
                .regular(regular)
                .caffeine(caffeine)
                .hour(hour)
                .build();
    }
}