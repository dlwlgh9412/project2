package com.smhrd.repository.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.post.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.smhrd.model.post.QPosts.posts;

import java.util.List;

@Repository
public class PostsRepositoryImpl implements PostsRepositoryCustom {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Posts> getListDesc() {
        return jpaQueryFactory.selectFrom(posts).orderBy(posts.id.desc()).fetch();
    }

}
