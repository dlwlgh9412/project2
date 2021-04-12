package com.smhrd.controller.assignment;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/state/assignment/draw")
public class Draw {
    @GetMapping
    public String draw(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "draw";
    }

    @GetMapping("/mh")
    public String draw_mh(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "draw_mh";
    }

    @GetMapping("/self")
    public String draw_self(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "draw_self";
    }

    @GetMapping("/flo")
    public String draw_flo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "draw_flo";
    }
}
