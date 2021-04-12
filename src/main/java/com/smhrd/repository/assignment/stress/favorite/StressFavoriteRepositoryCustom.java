package com.smhrd.repository.assignment.stress.favorite;

import com.smhrd.model.assignment.stress.favorite.StressFavorite;

import java.util.List;

public interface StressFavoriteRepositoryCustom {
    List<StressFavorite> getStressFavoriteByUserId(String id);

}
