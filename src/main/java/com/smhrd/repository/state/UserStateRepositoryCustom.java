package com.smhrd.repository.state;

import com.smhrd.model.user.UserState;

public interface UserStateRepositoryCustom {
    UserState findByUserId(String id);
}
