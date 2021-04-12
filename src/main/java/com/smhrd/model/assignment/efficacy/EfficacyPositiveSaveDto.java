package com.smhrd.model.assignment.efficacy;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EfficacyPositiveSaveDto {
    private String positive;
    private User user;

    public EfficacyPositive toEntity() {
        return EfficacyPositive.builder()
                .user(user)
                .positive(positive)
                .build();
    }
}
