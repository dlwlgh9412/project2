package com.smhrd.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoSaveDto {
    private User user;
    private UserInfo userInfo;
    private Float height;
    private Float weight;
    private Integer grade;
    private Integer studyTime;
    //private boolean isDropOut;
    private String isDropOut;
    private Integer sleepTime;
    //private boolean isAnxiety;
    private String isAnxiety;
    //private boolean isCureAnxiety;
    private String isCureAnxiety;
    //private boolean isDepression;
    private String isDepression;
    //private boolean isCureDepression;
    private String isCureDepression;

    public CaseHistory toCaseHistory() {
        return CaseHistory.builder()
                .userInfo(userInfo)
                .isAnxiety(Boolean.parseBoolean(isAnxiety))
                .isCureAnxiety(Boolean.parseBoolean(isCureAnxiety))
                .isDepression(Boolean.parseBoolean(isDepression))
                .isCureDepression(Boolean.parseBoolean(isCureDepression))
                .build();
    }

    public UserInfo toUserInfo() {
        return UserInfo.builder()
                .height(height)
                .weight(weight)
                .grade(grade)
                .user(user)
                .sleepTime(sleepTime)
                .studyTime(studyTime)
                .isDropOut(Boolean.parseBoolean(isDropOut))
                .build();
    }
}
