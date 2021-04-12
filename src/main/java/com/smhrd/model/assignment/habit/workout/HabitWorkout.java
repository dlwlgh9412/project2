package com.smhrd.model.assignment.habit.workout;

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
@Table(name = "tbl_habit_workout")
public class HabitWorkout extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String walking;

    private String stretching;

    private String workout;

    @Builder
    public HabitWorkout(User user, String walking, String stretching, String workout) {
        this.user = user;
        this.walking = walking;
        this.stretching = stretching;
        this.workout = workout;
    }
}
