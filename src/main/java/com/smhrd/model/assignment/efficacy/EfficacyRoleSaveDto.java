package com.smhrd.model.assignment.efficacy;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EfficacyRoleSaveDto {
    private String rolemodel;
    private User user;

    public EfficacyRoleModel toEntity() {
        return EfficacyRoleModel.builder()
                .user(user)
                .roleModel(rolemodel)
                .build();
    }
}
