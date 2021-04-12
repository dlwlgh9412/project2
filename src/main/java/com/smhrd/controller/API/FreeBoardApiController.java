package com.smhrd.controller.API;

import com.smhrd.model.post.PostSaveDto;
import com.smhrd.model.post.PostUpdateDto;
import com.smhrd.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/board")
public class FreeBoardApiController {
    private PostService postService;

    @PostMapping("/save")
    public Long savePost(@RequestBody PostSaveDto dto) {
        return postService.savePost(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PutMapping("/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateDto dto) {
        return postService.updatePost(id, dto);
    }
}
