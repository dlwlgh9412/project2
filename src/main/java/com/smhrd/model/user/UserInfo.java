package com.smhrd.model.user;

import com.smhrd.model.BaseTimeEntity;
import com.smhrd.model.GenderRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_userInfo")
public class UserInfo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "userInfo")
    private User user;

    private Float height;

    private Float weight;

    private Integer grade;

    private Integer sleepTime;
    private Integer studyTime;
    // 자퇴 생각 여부
    private boolean isDropOut;

    @OneToOne
    private CaseHistory caseHistory;

    @Builder
    public UserInfo(User user, Float height, Float weight, Integer sleepTime, Integer studyTime, Integer grade, boolean isDropOut, CaseHistory caseHistory) {
        this.user = user;
        this.weight = weight;
        this.height = height;
        this.studyTime = studyTime;
        this.grade = grade;
        this.sleepTime = sleepTime;
        this.isDropOut = isDropOut;
        this.caseHistory = caseHistory;
    }
}
