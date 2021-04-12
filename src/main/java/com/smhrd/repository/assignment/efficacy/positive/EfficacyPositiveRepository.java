package com.smhrd.repository.assignment.efficacy.positive;

import com.smhrd.model.assignment.efficacy.EfficacyPositive;
import com.smhrd.model.assignment.efficacy.EfficacySuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfficacyPositiveRepository extends JpaRepository<EfficacyPositive, Long>, EfficacyPositiveRepositoryCustom {
}
