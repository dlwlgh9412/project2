package com.smhrd.model.post;

import com.smhrd.model.user.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PostSaveDto {
    private String title;
    private String text;
    private User user;


    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .user(user)
                .text(text)
                .build();
    }
}
