package com.smhrd.model.assignment.habit.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class HabitWorkoutResponseDto {
    private String createdDate;
    private String walking;
    private String stretching;
    private String workout;
}
