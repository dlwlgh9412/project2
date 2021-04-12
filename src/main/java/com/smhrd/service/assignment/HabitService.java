package com.smhrd.service.assignment;

import com.smhrd.model.assignment.habit.eat.HabitEat;
import com.smhrd.model.assignment.habit.eat.HabitEatResponseDto;
import com.smhrd.model.assignment.habit.eat.HabitEatSaveDto;
import com.smhrd.model.assignment.habit.sleep.HabitSleep;
import com.smhrd.model.assignment.habit.sleep.HabitSleepResponseDto;
import com.smhrd.model.assignment.habit.sleep.HabitSleepSaveDto;
import com.smhrd.model.assignment.habit.workout.HabitWorkout;
import com.smhrd.model.assignment.habit.workout.HabitWorkoutResponseDto;
import com.smhrd.model.assignment.habit.workout.HabitWorkoutSaveDto;
import com.smhrd.repository.assignment.habit.eat.HabitEatEatRepository;
import com.smhrd.repository.assignment.habit.sleep.HabitSleepRepository;
import com.smhrd.repository.assignment.habit.workout.HabitWorkoutRepository;
import com.smhrd.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class HabitService {
    private HabitEatEatRepository habitEatRepository;
    private HabitSleepRepository habitSleepRepository;
    private HabitWorkoutRepository habitWorkoutRepository;
    private UserRepository userRepository;

    @Transactional
    public List<HabitSleepResponseDto> getSleep(String id) {
        List<HabitSleep> habitSleepList = habitSleepRepository.getHabitSleepByUserId(id);
        List<HabitSleepResponseDto> habitSleepResponseDtoList = new ArrayList<>();

        for(HabitSleep habitSleep : habitSleepList) {
            habitSleepResponseDtoList.add(
                    HabitSleepResponseDto.builder()
                            .createdDate(habitSleep.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .caffeine(habitSleep.getCaffeine())
                            .regular(habitSleep.getRegular())
                            .hour(habitSleep.getHour())
                            .build()
            );
        }
        return habitSleepResponseDtoList;
    }

    @Transactional
    public List<HabitEatResponseDto> getEat(String id) {
        List<HabitEat> habitEatList = habitEatRepository.getHabitEatByUserId(id);
        List<HabitEatResponseDto> habitSleepResponseDtoList = new ArrayList<>();

        for(HabitEat habitEat : habitEatList) {
            habitSleepResponseDtoList.add(
                    HabitEatResponseDto.builder()
                            .createdDate(habitEat.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .onTime(habitEat.getOnTime())
                            .cook(habitEat.getCook())
                            .junk(habitEat.getJunk())
                            .build()
            );
        }
        return habitSleepResponseDtoList;
    }

    @Transactional
    public List<HabitWorkoutResponseDto> getWorkout(String id) {
        List<HabitWorkout> habitWorkoutList = habitWorkoutRepository.getHabitWorkoutUserId(id);
        List<HabitWorkoutResponseDto> habitWorkoutResponseDtoList = new ArrayList<>();

        for(HabitWorkout habitWorkout : habitWorkoutList) {
            habitWorkoutResponseDtoList.add(
                    HabitWorkoutResponseDto.builder()
                            .createdDate(habitWorkout.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .workout(habitWorkout.getWorkout())
                            .walking(habitWorkout.getWalking())
                            .stretching(habitWorkout.getStretching())
                            .build()
            );
        }
        return habitWorkoutResponseDtoList;
    }

    @Transactional
    public Long saveEatPost(HabitEatSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return habitEatRepository.save(dto.toEntity()).getUser().getNum();
    }

    @Transactional
    public Long saveSleepPost(HabitSleepSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return habitSleepRepository.save(dto.toEntity()).getUser().getNum();
    }

    @Transactional
    public Long saveWorkOutPost(HabitWorkoutSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return habitWorkoutRepository.save(dto.toEntity()).getUser().getNum();
    }
}
