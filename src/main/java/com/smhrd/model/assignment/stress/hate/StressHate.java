package com.smhrd.model.assignment.stress.hate;

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
@Table(name = "tbl_stress_hate")
public class StressHate extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String hate;

    @Builder
    public StressHate(User user, String hate) {
        this.user = user;
        this.hate = hate;
    }
}