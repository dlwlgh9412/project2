package com.smhrd.model.assignment.habit.eat;

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
@Table(name = "tbl_habit_eat")
public class HabitEat extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String junk;

    private String cook;

    private String onTime;

    @Builder
    public HabitEat(User user, String junk, String cook, String onTime) {
        this.user = user;
        this.junk = junk;
        this.cook = cook;
        this.onTime = onTime;
    }
}
