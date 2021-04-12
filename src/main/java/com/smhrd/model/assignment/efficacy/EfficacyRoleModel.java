package com.smhrd.model.assignment.efficacy;


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
@Table(name = "tbl_efficacy_role")
public class EfficacyRoleModel extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String roleModel;

    @Builder
    public EfficacyRoleModel(User user, String roleModel) {
        this.user = user;
        this.roleModel = roleModel;
    }
}
