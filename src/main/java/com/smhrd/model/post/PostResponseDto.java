package com.smhrd.model.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String text;
    private String createdDate;
    private String modifiedDate;
}
