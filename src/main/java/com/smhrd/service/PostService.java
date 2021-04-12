package com.smhrd.service;

import com.smhrd.model.user.User;
import com.smhrd.model.post.*;
import com.smhrd.repository.post.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public Long updatePost(Long id, PostUpdateDto dto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        posts.update(dto.getTitle(), dto.getText());
        return id;
    }

    @Transactional
    public void deletePost(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        postsRepository.delete(posts);
    }

    @Transactional
    public PostResponseDto getPost(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Posts posts = postsRepository.getOne(id);
        if(authentication.getName().equals(posts.getUser().getId()))
            return PostResponseDto.builder()
                    .id(posts.getId())
                    .author(posts.getUser().getId())
                    .title(posts.getTitle())
                    .text(posts.getText())
                    .createdDate(posts.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .modifiedDate(posts.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        else
            return PostResponseDto.builder()
                    .id(posts.getId())
                    .author("익명")
                    .title(posts.getTitle())
                    .text(posts.getText())
                    .createdDate(posts.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .modifiedDate(posts.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();

    }

    @Transactional
    public List<PostListResponseDto> getList() {
        return postsRepository.getListDesc().stream().map(posts -> {
            return new PostListResponseDto(posts.getId(), posts.getTitle(), "익명");
        }).collect(Collectors.toList());
    }

    @Transactional
    public Long savePost(PostSaveDto dto) {
        User user = userService.findByUserId(SecurityContextHolder.getContext().getAuthentication().getName());
        dto.setUser(user);
        Posts posts = dto.toEntity();
        return postsRepository.save(posts).getId();
    }
}
