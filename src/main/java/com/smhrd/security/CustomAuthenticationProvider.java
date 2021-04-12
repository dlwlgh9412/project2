package com.smhrd.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String id = token.getName();
        String pw = (String)token.getCredentials();
        UserDetailsVO userDetailsVO = (UserDetailsVO) userDetailsService.loadUserByUsername(id);
        if(!passwordEncoder.matches(pw, userDetailsVO.getPassword())) {
            throw new BadCredentialsException(userDetailsVO.getUsername() + "Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userDetailsVO, id, userDetailsVO.getAuthorities());
        /*
        System.out.println("authenticate");
        String user_id = (String)authentication.getPrincipal();
        String user_pw = (String)authentication.getCredentials();

        System.out.println("input id: " + user_id);
        System.out.println("input pw: " + user_pw);

        UserDetails account = userDetailsService.loadUserByUsername(user_id);
        if(account != null) {
            if (!passwordEncoder.matches(user_pw, account.getPassword())) {
                throw new BadCredentialsException("비밀번호가 일치 하지 않습니다.");
            }
        } else {
            throw new NullPointerException();
        }
        return new UsernamePasswordAuthenticationToken(user_id, null, account.getAuthorities());

         */
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
        //return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
