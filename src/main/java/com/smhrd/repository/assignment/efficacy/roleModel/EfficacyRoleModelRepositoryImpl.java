package com.smhrd.repository.assignment.efficacy.roleModel;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.efficacy.EfficacyRoleModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.efficacy.QEfficacyRoleModel.efficacyRoleModel;

public class EfficacyRoleModelRepositoryImpl implements EfficacyRoleModelRepositoryCustom  {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<EfficacyRoleModel> getEfficacyRoleModelByUserId(String id) {
        return queryFactory.selectFrom(efficacyRoleModel).where(efficacyRoleModel.user.id.eq(id))
                .orderBy(efficacyRoleModel.createdDate.desc()).fetch();
    }
}
