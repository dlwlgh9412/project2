package com.smhrd.model.post;

import com.smhrd.model.BaseTimeEntity;
import com.smhrd.model.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Entity
@Table(name = "tbl_posts")
@NoArgsConstructor
public class Posts extends BaseTimeEntity {
    // 게시글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    // 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String text;

    @Builder
    public Posts(String title, User user, String text) {
        this.title = title;
        this.user = user;
        this.text = text;
    }

    public void update(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
