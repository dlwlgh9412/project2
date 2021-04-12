package com.smhrd.repository.assignment.habit.sleep;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.habit.sleep.HabitSleep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.habit.sleep.QHabitSleep.habitSleep;


public class HabitSleepRepositoryImpl implements HabitSleepRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<HabitSleep> getHabitSleepByUserId(String id) {
        return queryFactory.selectFrom(habitSleep).where(habitSleep.user.id.eq(id))
                .orderBy(habitSleep.createdDate.desc()).fetch();
    }

}
