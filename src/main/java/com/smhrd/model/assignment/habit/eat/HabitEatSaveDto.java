package com.smhrd.model.assignment.habit.eat;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitEatSaveDto {
    private User user;
    private String junk;
    private String cook;
    private String onTime;

    public HabitEat toEntity() {
        return HabitEat.builder()
                .user(user)
                .cook(cook)
                .junk(junk)
                .onTime(onTime)
                .build();
    }
}
