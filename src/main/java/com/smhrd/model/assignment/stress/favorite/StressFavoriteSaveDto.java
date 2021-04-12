package com.smhrd.model.assignment.stress.favorite;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StressFavoriteSaveDto {
    private User user;
    private String favorite;

    public StressFavorite toEntity() {
        return StressFavorite.builder()
                .user(user)
                .favorite(favorite)
                .build();
    }

}
