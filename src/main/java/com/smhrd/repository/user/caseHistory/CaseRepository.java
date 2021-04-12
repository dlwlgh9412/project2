package com.smhrd.repository.user.caseHistory;

import com.smhrd.model.user.CaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<CaseHistory, Long>, CaseRepositoryCustom {
}
