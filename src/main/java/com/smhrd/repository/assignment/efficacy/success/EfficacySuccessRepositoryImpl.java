package com.smhrd.repository.assignment.efficacy.success;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.efficacy.EfficacySuccess;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.efficacy.QEfficacySuccess.efficacySuccess;

public class EfficacySuccessRepositoryImpl implements EfficacySuccessRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<EfficacySuccess> getEfficacySuccessByUserId(String id) {
        return queryFactory.selectFrom(efficacySuccess).where(efficacySuccess.user.id.eq(id))
                .orderBy(efficacySuccess.createdDate.desc()).fetch();
    }
}
