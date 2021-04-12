package com.smhrd.repository.assignment.efficacy.success;

import com.smhrd.model.assignment.efficacy.EfficacySuccess;

import java.util.List;

public interface EfficacySuccessRepositoryCustom {
    List<EfficacySuccess> getEfficacySuccessByUserId(String id);
}
