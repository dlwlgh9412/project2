package com.smhrd.repository.rememberme;

import com.smhrd.model.rememberMe.RememberMeToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RememberMeTokenRepository extends JpaRepository<RememberMeToken, String> {
    RememberMeToken findBySeries(String series);
    List<RememberMeToken> findByUsername(String id);

}
