package com.smhrd.controller.assignment;

import com.smhrd.service.assignment.HabitService;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/state/assignment/habit")
public class Habit {
    @Autowired
    private HabitService habitService;

    @GetMapping
    public String habit(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "habit";
    }

    @GetMapping("/sleep")
    public String sleep(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "habit_sleep";
    }

    @GetMapping("/eat")
    public String eat(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "habit_eat";
    }

    @GetMapping("/workout")
    public String workout(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "habit_workout";
    }

    @GetMapping("/eat/com")
    public String eatCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("habit_eat", habitService.getEat(authentication.getName()));
        return "habit_eat_com";
    }

    @GetMapping("/sleep/com")
    public String sleepCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("habit_sleep", habitService.getSleep(authentication.getName()));
        return "habit_sleep_com";
    }

    @GetMapping("/workout/com")
    public String workoutCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("habit_workout", habitService.getWorkout(authentication.getName()));
        return "habit_workout_com";
    }
}
