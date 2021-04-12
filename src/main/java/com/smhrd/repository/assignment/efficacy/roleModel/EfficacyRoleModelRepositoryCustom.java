package com.smhrd.repository.assignment.efficacy.roleModel;

import com.smhrd.model.assignment.efficacy.EfficacyRoleModel;
import com.smhrd.model.assignment.efficacy.EfficacySuccess;

import java.util.List;

public interface EfficacyRoleModelRepositoryCustom {
    List<EfficacyRoleModel> getEfficacyRoleModelByUserId(String id);
}
