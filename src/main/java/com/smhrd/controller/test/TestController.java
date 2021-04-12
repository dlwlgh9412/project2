package com.smhrd.controller.test;

import com.smhrd.model.user.User;
import com.smhrd.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/test_environment")
    public String test_environment(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "test_environment";
    }
    // 설문 화면
    @GetMapping("/test_survey")
    public String test_survey(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserId(authentication.getName());
        if(user.getUserInfo() == null) {
            return "redirect:test_environment";
        }
        model.addAttribute("name", authentication.getName());
        return "test_survey";
    }
    // 결과 화면
    @GetMapping("/state")
    public String state(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserId(authentication.getName());
        if(user.getUserInfo() == null)
            return "redirect:test_environment";
        model.addAttribute("name", authentication.getName());
        model.addAttribute("state", user.getUserState().getState());
        return "state";
    }
}
