package com.smhrd.model.assignment.efficacy;

import com.smhrd.model.BaseTimeEntity;
import com.smhrd.model.user.User;
import com.smhrd.service.assignment.EfficacyService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_efficacy_suc")
public class EfficacySuccess extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String success;

    @Builder
    public EfficacySuccess(User user, String success) {
        this.user = user;
        this.success = success;
    }
}
