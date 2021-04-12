package com.smhrd.model.user;

import com.smhrd.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_caseHistory")
public class CaseHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "caseHistory")
    private UserInfo userInfo;

    // 우울증 진단 여부
    private boolean isDepression;

    // 우울증 치료 여부
    private boolean isCureDepression;

    // 불안장애 진단 여부
    private boolean isAnxiety;

    // 불안장애 치료 여부부
    private boolean isCureAnxiety;

    @Builder
    public CaseHistory(UserInfo userInfo, boolean isDepression, boolean isCureDepression, boolean isAnxiety, boolean isCureAnxiety) {
        this.userInfo = userInfo;
        this.isAnxiety = isAnxiety;
        this.isCureAnxiety = isCureAnxiety;
        this.isDepression = isDepression;
        this.isCureDepression = isCureDepression;
    }
}
