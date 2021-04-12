package com.smhrd.repository.assignment.stress.favorite;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smhrd.model.assignment.stress.favorite.StressFavorite;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.smhrd.model.assignment.stress.favorite.QStressFavorite.stressFavorite;


public class StressFavoriteRepositoryImpl implements StressFavoriteRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;


    @Override
    public List<StressFavorite> getStressFavoriteByUserId(String id) {
        return queryFactory.selectFrom(stressFavorite).where(stressFavorite.user.id.eq(id))
                .orderBy(stressFavorite.createdDate.desc()).fetch();
    }

}
