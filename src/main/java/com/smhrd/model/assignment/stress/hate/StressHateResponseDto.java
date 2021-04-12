package com.smhrd.model.assignment.stress.hate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class StressHateResponseDto {
    private String createdDate;
    private String hate;
}
