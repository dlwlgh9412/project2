package com.smhrd.repository.state;

import com.smhrd.model.user.UserState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStateRepository extends JpaRepository<UserState, Long>, UserStateRepositoryCustom {
}
