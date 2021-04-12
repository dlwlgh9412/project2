package com.smhrd.model.assignment.habit.eat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class HabitEatResponseDto {
    private String createdDate;
    private String junk;
    private String cook;
    private String onTime;
}
