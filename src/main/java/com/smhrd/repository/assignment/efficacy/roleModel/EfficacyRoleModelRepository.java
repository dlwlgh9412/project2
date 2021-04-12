package com.smhrd.repository.assignment.efficacy.roleModel;

import com.smhrd.model.assignment.efficacy.EfficacyRoleModel;
import com.smhrd.model.assignment.efficacy.EfficacySuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfficacyRoleModelRepository extends JpaRepository<EfficacyRoleModel, Long>, EfficacyRoleModelRepositoryCustom {
}
