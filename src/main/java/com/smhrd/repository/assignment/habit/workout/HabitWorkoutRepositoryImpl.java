package com.smhrd.repository.assignment.habit.workout;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.habit.workout.HabitWorkout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.habit.workout.QHabitWorkout.habitWorkout;


public class HabitWorkoutRepositoryImpl implements HabitWorkoutRepositoryCustom  {
    @Autowired
    private JPAQueryFactory queryFactory;


    @Override
    public List<HabitWorkout> getHabitWorkoutUserId(String id) {
        return queryFactory.selectFrom(habitWorkout).where(habitWorkout.user.id.eq(id))
                .orderBy(habitWorkout.createdDate.desc()).fetch();
    }

}
