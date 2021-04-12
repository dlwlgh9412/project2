package com.smhrd.model.assignment.efficacy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class EfficacyPositiveResponseDto {
    private String createdDate;
    private String positive;
}
