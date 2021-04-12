package com.smhrd.security;

import com.smhrd.model.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class UserDetailsVO implements UserDetails {
    @Delegate
    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPwd();
    }

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExp();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLoc();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExp();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnb();
    }
}
