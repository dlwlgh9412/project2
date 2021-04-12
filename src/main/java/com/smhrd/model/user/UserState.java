package com.smhrd.model.user;

import com.smhrd.model.State;
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
@Table(name = "tbl_user_state")
public class UserState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "userState")
    private User user;

    @Enumerated(EnumType.STRING)
    private State state;

    @Builder
    public UserState(User user, State state) {
        this.user = user;
        this.state = state;
    }

    public void update(State state) {
        this.state = state;
    }
}
