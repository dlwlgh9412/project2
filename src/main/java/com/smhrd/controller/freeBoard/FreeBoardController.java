package com.smhrd.controller.freeBoard;

import com.smhrd.model.post.PostResponseDto;
import com.smhrd.model.post.Posts;
import com.smhrd.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class FreeBoardController {
    @Autowired
    private PostService postService;

    // 게시글 조회
    @GetMapping("/{id}")
    public String selectBoard(@PathVariable Long id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PostResponseDto post = postService.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("name", authentication.getName());
        if(post.getAuthor().equals(authentication.getName())) {
            model.addAttribute("author", authentication.getName());
        }
        return "board_view";
    }

    // 글쓰기 화면
    @GetMapping("/writePage")
    public String writePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "board_write";
    }

    // 글 수정 화면
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        PostResponseDto post = postService.getPost(id);
        model.addAttribute("post", post);
        return "board_edit";
    }
}
