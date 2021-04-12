package com.smhrd.repository.assignment.habit.eat;

import com.smhrd.model.assignment.habit.eat.HabitEat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitEatEatRepository extends JpaRepository<HabitEat, Long>, HabitEatRepositoryCustom {
}
