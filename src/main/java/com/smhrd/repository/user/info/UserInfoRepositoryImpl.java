package com.smhrd.repository.user.info;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import static com.smhrd.model.user.QUserInfo.userInfo;
public class UserInfoRepositoryImpl implements UserInfoRepositoryCustom  {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public UserInfo getUserInfoById(String id) {
        return jpaQueryFactory.selectFrom(userInfo).where(userInfo.user.id.eq(id)).fetchOne();
    }

}
