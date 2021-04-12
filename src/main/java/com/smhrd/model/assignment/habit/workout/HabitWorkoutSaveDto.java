package com.smhrd.model.assignment.habit.workout;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitWorkoutSaveDto {
    private User user;
    private String walking;
    private String stretching;
    private String workout;

    public HabitWorkout toEntity() {
        return HabitWorkout.builder()
                .user(user)
                .workout(workout)
                .stretching(stretching)
                .walking(walking)
                .build();
    }
}
