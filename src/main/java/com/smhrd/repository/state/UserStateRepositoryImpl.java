package com.smhrd.repository.state;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.user.UserState;
import org.springframework.beans.factory.annotation.Autowired;

import static com.smhrd.model.user.QUserState.userState;

public class UserStateRepositoryImpl implements UserStateRepositoryCustom  {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public UserState findByUserId(String id) {
        return queryFactory.selectFrom(userState).where(userState.user.id.eq(id)).fetchOne();
    }

}
