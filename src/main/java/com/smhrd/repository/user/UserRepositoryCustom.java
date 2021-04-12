package com.smhrd.repository.user;

import com.smhrd.model.user.User;

public interface UserRepositoryCustom {
    User findByUserId(String id);
    User findByUserEmail(String email);
}
