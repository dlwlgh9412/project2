package com.smhrd.model.user;

import com.smhrd.model.GenderRole;
import com.smhrd.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SignUpDto {
    private String id;
    private String email;
    private String password;
    private String passwordConfirm;
    private String name;
    private String birthday;
    private GenderRole gender;
    private String number;
    private Role role;

    public User toEntity() {
        return User.builder()
                .id(id)
                .email(email)
                .name(name)
                .birthday(LocalDate.parse(birthday))
                .gender(gender)
                .number(number)
                .build();
    }
}
