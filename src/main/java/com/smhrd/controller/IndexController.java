package com.smhrd.controller;

import com.smhrd.model.post.PostListResponseDto;
import com.smhrd.model.user.User;
import com.smhrd.service.PostService;
import com.smhrd.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Controller
public class IndexController {
    @Autowired
    private PostService postService;

    // 메인 화면
    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!checkAnonymous(authentication))
            model.addAttribute("name", authentication.getName());
        return "home";
    }

    // 로그인 화면
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referrer);
        return "login";
    }

    // 소개 화면
    @GetMapping("/about")
    public String about(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!checkAnonymous(authentication))
            model.addAttribute("name", authentication.getName());
        return "about";
    }

    // 자유게시판 화면
    @GetMapping("/board")
    public String board(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!checkAnonymous(authentication))
            model.addAttribute("name", authentication.getName());
        List<PostListResponseDto> posts = postService.getList();
        model.addAttribute("posts", posts);
        return "Board";
    }

    // 회원가입 화면
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }



    // 익명사용자 체크함수
    private boolean checkAnonymous(Authentication authentication) {
        return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
    }
}
