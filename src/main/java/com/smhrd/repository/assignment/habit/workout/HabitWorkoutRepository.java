package com.smhrd.repository.assignment.habit.workout;

import com.smhrd.model.assignment.habit.workout.HabitWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitWorkoutRepository extends JpaRepository<HabitWorkout, Long>, HabitWorkoutRepositoryCustom {
}
