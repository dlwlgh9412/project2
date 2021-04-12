package com.smhrd.repository.assignment.efficacy.success;

import com.smhrd.model.assignment.efficacy.EfficacySuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfficacySuccessRepository extends JpaRepository<EfficacySuccess, Long>, EfficacySuccessRepositoryCustom {
}
