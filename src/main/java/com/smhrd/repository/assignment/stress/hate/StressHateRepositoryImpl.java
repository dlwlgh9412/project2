package com.smhrd.repository.assignment.stress.hate;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.stress.hate.StressHate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.stress.hate.QStressHate.stressHate;


public class StressHateRepositoryImpl implements StressHateRepositoryCustom  {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<StressHate> getStressHateByUserId(String id) {
        return queryFactory.selectFrom(stressHate).where(stressHate.user.id.eq(id))
                .orderBy(stressHate.createdDate.desc()).fetch();
    }

}
