package com.smhrd.model.assignment.stress.favorite;

import com.smhrd.model.BaseTimeEntity;
import com.smhrd.model.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_stress_favorite")
public class StressFavorite extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String favorite;

    @Builder
    public StressFavorite(User user, String favorite) {
        this.user = user;
        this.favorite = favorite;
    }
}
