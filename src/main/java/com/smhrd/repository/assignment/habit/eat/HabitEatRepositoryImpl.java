package com.smhrd.repository.assignment.habit.eat;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.habit.eat.HabitEat;
import com.smhrd.model.assignment.habit.sleep.HabitSleep;
import com.smhrd.model.assignment.habit.workout.HabitWorkout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.habit.eat.QHabitEat.habitEat;
import static com.smhrd.model.assignment.habit.sleep.QHabitSleep.habitSleep;
import static com.smhrd.model.assignment.habit.workout.QHabitWorkout.habitWorkout;



public class HabitEatRepositoryImpl implements HabitEatRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;
    @Override
    public List<HabitEat> getHabitEatByUserId(String id) {
        return queryFactory.selectFrom(habitEat).where(habitEat.user.id.eq(id))
                .orderBy(habitEat.createdDate.desc()).fetch();
    }
}
