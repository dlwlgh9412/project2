package com.smhrd.model.user;

import com.smhrd.model.BaseTimeEntity;
import com.smhrd.model.GenderRole;
import com.smhrd.model.Role;
import com.smhrd.model.assignment.efficacy.EfficacyPositive;
import com.smhrd.model.assignment.efficacy.EfficacyRoleModel;
import com.smhrd.model.assignment.efficacy.EfficacySuccess;
import com.smhrd.model.assignment.habit.eat.HabitEat;
import com.smhrd.model.assignment.habit.sleep.HabitSleep;
import com.smhrd.model.assignment.habit.workout.HabitWorkout;
import com.smhrd.model.assignment.stress.favorite.StressFavorite;
import com.smhrd.model.assignment.stress.hate.StressHate;
import com.smhrd.model.post.Posts;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "tbl_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email", "id"})
})
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @NotBlank
    private String id;

    @NotBlank
    private String pwd;

    @Column(length = 50)
    @NotBlank
    private String name;

    private LocalDate birthday;

    @Column(name = "gender", length = 10)
    @Enumerated(EnumType.STRING)
    private GenderRole gender;

    @Column(length = 50)
    @Email
    @NotBlank
    private String email;

    @Column(length = 20)
    private String number;

    @Column(name = "role", length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;

    // 계정만료 여부
    private boolean isAccountNonExp = true;

    // 계정 잠금여부
    private boolean isAccountNonLoc = true;

    //계정 패스워드 만료 여부
    private boolean isCredentialsNonExp = true;

    // 사용 가능계정 여부
    private boolean isEnb = true;

    @OneToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @OneToOne(fetch = FetchType.LAZY)
    private UserState userState;

    @OneToMany(mappedBy = "user")
    private List<Posts> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<EfficacySuccess> efficacySuccessList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<EfficacyRoleModel> efficacyRoleModelList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<EfficacyPositive> efficacyPositiveList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<HabitEat> habitEats = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<HabitEat> habitEatList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<HabitSleep> habitSleepList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<HabitWorkout> habitWorkoutList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<StressFavorite> stressFavoriteList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<StressHate> stressHateList = new ArrayList<>();

    @Builder
    public User(String id, String email, String name, LocalDate birthday, GenderRole gender, String number, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.number = number;
        this.role = role;
    }


}
