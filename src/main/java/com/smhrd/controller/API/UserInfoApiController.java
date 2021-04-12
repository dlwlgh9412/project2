package com.smhrd.controller.API;

import com.smhrd.model.user.UserInfoSaveDto;
import com.smhrd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UserInfoApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/setUserEnv")
    public RedirectView setEnv(@ModelAttribute UserInfoSaveDto dto)  {
        if(userService.saveUserInfo(dto) != null)
            return new RedirectView("/test_survey");

        return new RedirectView("/home");
    }
}
