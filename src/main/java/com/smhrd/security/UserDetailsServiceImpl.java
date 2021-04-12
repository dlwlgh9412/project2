package com.smhrd.security;

import com.smhrd.model.user.User;
import com.smhrd.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private static final String Role_PREFIX = "ROLE_";


    @Transactional(readOnly = true)
    @Override
    public UserDetailsVO loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(id);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(Role_PREFIX + user.getRole().name()));
        grantedAuthorities.add(new SimpleGrantedAuthority(Role_PREFIX + user.getUserState().getState()));
        return new UserDetailsVO(user, grantedAuthorities);
    }
}
