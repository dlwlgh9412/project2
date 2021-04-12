package com.smhrd.model.assignment.stress.favorite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class StressFavoriteResponseDto {
    private String createdDate;
    private String favorite;
}
