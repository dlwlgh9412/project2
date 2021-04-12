package com.smhrd.model.assignment.efficacy;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EfficacySucSaveDto {
    private String success;
    private User user;

    public EfficacySuccess toEntity() {
        return EfficacySuccess.builder()
                .user(user)
                .success(success)
                .build();
    }
}
