package com.smhrd.model.assignment.habit.sleep;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class HabitSleepResponseDto {
    private String createdDate;
    private String regular;
    private String caffeine;
    private String hour;
}
