package com.smhrd.repository.assignment.efficacy.positive;

import com.smhrd.model.assignment.efficacy.EfficacyPositive;
import com.smhrd.model.assignment.efficacy.EfficacySuccess;

import java.util.List;

public interface EfficacyPositiveRepositoryCustom {
    List<EfficacyPositive> getEfficacyPositiveByUserId(String id);
}
