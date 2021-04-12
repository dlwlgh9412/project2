package com.smhrd.repository.user;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.smhrd.model.user.QUser.user;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public User findByUserId(String id) {
        return jpaQueryFactory.selectFrom(user).where(user.id.eq(id)).fetchOne();
    }

    @Override
    public User findByUserEmail(String email) {
        return jpaQueryFactory.selectFrom(user).where(user.email.eq(email)).fetchOne();
    }


}


