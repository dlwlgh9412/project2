package com.smhrd.model.assignment.habit.sleep;


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
@Table(name = "tbl_habit_sleep")
public class HabitSleep extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String regular;

    private String caffeine;

    private String hour;

    @Builder
    public HabitSleep(User user, String regular, String caffeine, String hour) {
        this.user = user;
        this.regular = regular;
        this.caffeine = caffeine;
        this.hour = hour;
    }
}
