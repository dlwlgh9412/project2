package com.smhrd.model;

import com.smhrd.model.user.SurveyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MachineLearningRequestDto {
    private Integer age;
    private GenderRole genderRole;
    private Float height;
    private Float weight;
    private SurveyDto surveyDto;
    private Integer sleepTime;
    private Integer studyTime;
    private boolean isDropOut;

    @Builder
    public MachineLearningRequestDto(Integer age, GenderRole genderRole, Float height, Float weight, SurveyDto surveyDto, boolean isDropOut, Integer sleepTime, Integer studyTime) {
        this.age = age;
        this.genderRole = genderRole;
        this.height = height;
        this.weight = weight;
        this.surveyDto = surveyDto;
        this.isDropOut = isDropOut;
        this.sleepTime = sleepTime;
        this.studyTime = studyTime;
    }
}
