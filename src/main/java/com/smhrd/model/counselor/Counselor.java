package com.smhrd.model.counselor;

import com.smhrd.model.GenderRole;
import com.smhrd.model.Role;
import com.smhrd.model.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Table(name = "tbl_counselor", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email", "id"})
})
@ToString
@NoArgsConstructor
//@Entity
public class Counselor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long num;

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @Column(length = 50)
    @NotBlank
    private String name;

    @Column(length = 15)
    private String birthday;

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

    @OneToMany(mappedBy = "num")
    private List<User> users = new ArrayList<>();

    @Builder
    public Counselor(String id, String email, String name, String birthday, GenderRole gender, String number, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.number = number;
        this.role = role;
    }
}
