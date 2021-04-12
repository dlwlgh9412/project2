package com.smhrd.controller.API;

import com.smhrd.exception.ErrorResponse;
import com.smhrd.exception.MemberExceptionController;
import com.smhrd.model.State;
import com.smhrd.model.user.SignUpDto;
import com.smhrd.security.UserDetailsVO;
import com.smhrd.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserApiController {
    private UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/check")
    public String checkRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        UserDetailsVO user = (UserDetailsVO) authentication.getPrincipal();
        return user.getUsername() + " " + user.getAuthorities();
    }

    @GetMapping("/setState2")
    public void state2() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.changeState(authentication.getName(), State.TWO);
    }

    @GetMapping("/setState3")
    public void state3() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.changeState(authentication.getName(), State.THREE);
    }

    @GetMapping("/setState4")
    public void state4() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.changeState(authentication.getName(), State.FOUR);
    }

    @PostMapping("/signup/registry")
    public Long registration(@RequestBody @Valid SignUpDto dto , BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            log.debug("valid error");
            ErrorResponse errorResponse = MemberExceptionController.makeErrorResponse(bindingResult);
            throw new Exception();
        }

        log.debug("userInfo" + dto.toString());
        log.debug("email" + dto.getEmail() + "|" + dto.getPassword());

        return userService.save(dto);

        //memberValidator.validate(userForm, bindingResult);

        /*
        userForm.setRole(MemberRole.USER);
        memberService.save(userForm);
        log.debug("userInfo" + userForm.toString());
        log.debug("email" + userForm.getEmail() + "|" + userForm.getPassword());
         */
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
