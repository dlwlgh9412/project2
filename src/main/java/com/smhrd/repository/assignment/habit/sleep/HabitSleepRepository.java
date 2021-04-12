package com.smhrd.repository.assignment.habit.sleep;

import com.smhrd.model.assignment.habit.eat.HabitEat;
import com.smhrd.model.assignment.habit.sleep.HabitSleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitSleepRepository extends JpaRepository<HabitSleep, Long>, HabitSleepRepositoryCustom {
}
