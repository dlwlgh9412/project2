package com.smhrd.repository.assignment.stress.hate;

import com.smhrd.model.assignment.stress.hate.StressHate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StressHateRepository extends JpaRepository<StressHate, Long>, StressHateRepositoryCustom {
}
