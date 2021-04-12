package com.smhrd.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
public class SurveyDto {
    private int phq1;
    private int phq2;
    private int phq3;
    private int phq4;
    private int phq5;
    private int phq6;
    private int phq7;
    private int phq8;
    private int phq9;
}
