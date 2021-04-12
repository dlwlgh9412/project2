package com.smhrd.service;

import com.smhrd.model.MachineLearningRequestDto;
import com.smhrd.model.State;
import com.smhrd.model.user.UserState;
import com.smhrd.model.user.*;
import com.smhrd.model.Role;
import com.smhrd.repository.state.UserStateRepository;
import com.smhrd.repository.user.UserRepository;
import com.smhrd.repository.user.caseHistory.CaseRepository;
import com.smhrd.repository.user.info.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserStateRepository userStateRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private CaseRepository caseRepository;

    @Transactional
    public MachineLearningRequestDto buildMachineLearningDto(SurveyDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserId(authentication.getName());
        UserInfo userInfo = userInfoRepository.getUserInfoById(authentication.getName());
        return MachineLearningRequestDto.builder()
                .age(getAge(user.getBirthday()))
                .genderRole(user.getGender())
                .height(userInfo.getHeight())
                .weight(userInfo.getWeight())
                .isDropOut(userInfo.isDropOut())
                .surveyDto(dto)
                .sleepTime(userInfo.getSleepTime())
                .studyTime(userInfo.getStudyTime())
                .build();
    }

    @Transactional
    public Long saveUserInfo(UserInfoSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserId(authentication.getName());
        UserInfo userInfo = dto.toUserInfo();
        CaseHistory caseHistory = dto.toCaseHistory();
        caseHistory.setUserInfo(userInfo);
        caseRepository.save(caseHistory);
        userInfo.setCaseHistory(caseHistory);
        userInfo.setUser(user);
        user.setUserInfo(userInfo);
        return userInfoRepository.save(userInfo).getUser().getNum();
    }

    @Transactional
    public void changeState(String id, State state) {
        UserState userState = userStateRepository.findByUserId(id);
        State exist = userState.getState();
        userState.update(state);
        updateAuth(exist, state);
    }

    @Transactional
    public User findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

    @Transactional
    public Long save(SignUpDto dto) {
        User user = dto.toEntity();
        UserState userState = UserState.builder().user(user).state(State.ONE).build();
        if(dto.getPassword().equals(dto.getPasswordConfirm())) {
           user.setPwd(passwordEncoder.encode(dto.getPassword()));
        }
        user.setRole(Role.USER);
        user.setUserState(userState);
        user.setBirthday(LocalDate.parse(dto.getBirthday()));
        userStateRepository.save(userState);
        return userRepository.save(user).getNum();
    }

    public Integer getAge(LocalDate birth) {
        LocalDate now = LocalDate.now();

        Period period = birth.until(now);

        return period.getYears();
    }

    private void updateAuth(State exist, State now) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String Role_PREFIX = "ROLE_";
        Set<GrantedAuthority> authorities = new HashSet<>(authentication.getAuthorities());
        authorities.remove(new SimpleGrantedAuthority(Role_PREFIX + exist));
        authorities.add(new SimpleGrantedAuthority(Role_PREFIX + now));
        Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                authentication.getCredentials(), authorities);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }
}
