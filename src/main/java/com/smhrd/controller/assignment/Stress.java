package com.smhrd.controller.assignment;

import com.smhrd.service.assignment.StressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/state/assignment/stress")
public class Stress {
    @Autowired
    private StressService stressService;

    @GetMapping
    public String stress(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "stress";
    }

    @GetMapping("/like")
    public String like(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "stress_like";
    }

    @GetMapping("/hate")
    public String hate(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "stress_hate";
    }

    @GetMapping("/manage")
    public String manage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "stress_manage";
    }

    @GetMapping("/like/com")
    public String likeCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("stress_like", stressService.getFavorite(authentication.getName()));
        return "stress_like_com";
    }

    @GetMapping("/hate/com")
    public String hateCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("stress_hate", stressService.getHate(authentication.getName()));
        return "stress_hate_com";
    }
}
