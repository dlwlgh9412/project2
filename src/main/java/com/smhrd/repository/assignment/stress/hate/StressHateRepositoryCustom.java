package com.smhrd.repository.assignment.stress.hate;

import com.smhrd.model.assignment.stress.hate.StressHate;

import java.util.List;

public interface StressHateRepositoryCustom {
    List<StressHate> getStressHateByUserId(String id);

}
