package com.smhrd.model.university;

import com.smhrd.model.user.User;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "tbl_university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "university")
    private List<User> users;
}
