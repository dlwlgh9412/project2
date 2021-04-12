package com.smhrd.repository.assignment.habit.sleep;

import com.smhrd.model.assignment.habit.eat.HabitEat;
import com.smhrd.model.assignment.habit.sleep.HabitSleep;
import com.smhrd.model.assignment.habit.workout.HabitWorkout;

import java.util.List;

public interface HabitSleepRepositoryCustom {
    List<HabitSleep> getHabitSleepByUserId(String id);
}
