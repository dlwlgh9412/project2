package com.smhrd.model.assignment.efficacy;


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
@Table(name = "tbl_efficacy_positive")
public class EfficacyPositive extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String positive;

    @Builder
    public EfficacyPositive(User user, String positive) {
        this.user = user;
        this.positive = positive;
    }
}
