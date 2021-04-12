package com.smhrd.repository.assignment.stress.favorite;

import com.smhrd.model.assignment.stress.favorite.StressFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StressFavoriteRepository extends JpaRepository<StressFavorite, Long>, StressFavoriteRepositoryCustom {
}
