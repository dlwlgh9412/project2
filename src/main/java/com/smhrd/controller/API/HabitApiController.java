package com.smhrd.controller.API;

import com.smhrd.model.assignment.habit.eat.HabitEatSaveDto;
import com.smhrd.model.assignment.habit.sleep.HabitSleepSaveDto;
import com.smhrd.model.assignment.habit.workout.HabitWorkoutSaveDto;
import com.smhrd.service.assignment.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state/assignment/habit")
public class HabitApiController {
    @Autowired
    private HabitService habitService;

    @PostMapping("/save/workout")
    public Long saveWorkout(@RequestBody HabitWorkoutSaveDto dto) {
        return habitService.saveWorkOutPost(dto);
    }

    @PostMapping("/save/sleep")
    public Long saveSleep(@RequestBody HabitSleepSaveDto dto) {
        return habitService.saveSleepPost(dto);
    }

    @PostMapping("/save/eat")
    public Long saveEat(@RequestBody HabitEatSaveDto dto) {
        return habitService.saveEatPost(dto);
    }
}
