package com.smhrd.repository.assignment.efficacy.positive;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.efficacy.EfficacyPositive;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.efficacy.QEfficacyPositive.efficacyPositive;

public class EfficacyPositiveRepositoryImpl implements EfficacyPositiveRepositoryCustom  {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<EfficacyPositive> getEfficacyPositiveByUserId(String id) {
        return queryFactory.selectFrom(efficacyPositive).where(efficacyPositive.user.id.eq(id))
                .orderBy(efficacyPositive.createdDate.desc()).fetch();
    }
}
