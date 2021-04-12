package com.smhrd.service.assignment;

import com.smhrd.model.assignment.stress.favorite.StressFavorite;
import com.smhrd.model.assignment.stress.favorite.StressFavoriteResponseDto;
import com.smhrd.model.assignment.stress.hate.StressHate;
import com.smhrd.model.assignment.stress.hate.StressHateResponseDto;
import com.smhrd.model.assignment.stress.hate.StressHateSaveDto;
import com.smhrd.model.assignment.stress.favorite.StressFavoriteSaveDto;
import com.smhrd.repository.assignment.stress.favorite.StressFavoriteRepository;
import com.smhrd.repository.assignment.stress.hate.StressHateRepository;
import com.smhrd.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class StressService {
    private StressHateRepository stressHateRepository;
    private StressFavoriteRepository stressFavoriteRepository;
    private UserRepository userRepository;

    @Transactional
    public List<StressHateResponseDto> getHate(String id) {
        List<StressHate> stressHateList = stressHateRepository.getStressHateByUserId(id);
        List<StressHateResponseDto> stressHateResponseDtoList = new ArrayList<>();
        for(StressHate stressHate : stressHateList) {
            stressHateResponseDtoList.add(
                    StressHateResponseDto.builder()
                        .createdDate(stressHate.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .hate(stressHate.getHate())
                        .build()
            );
        }
        return stressHateResponseDtoList;
    }

    @Transactional
    public List<StressFavoriteResponseDto> getFavorite(String id) {
        List<StressFavorite> stressFavoriteList = stressFavoriteRepository.getStressFavoriteByUserId(id);
        List<StressFavoriteResponseDto> stressFavoriteResponseDtoList = new ArrayList<>();
        for(StressFavorite stressFavorite : stressFavoriteList) {
            stressFavoriteResponseDtoList.add(
                    StressFavoriteResponseDto.builder()
                    .createdDate(stressFavorite.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .favorite(stressFavorite.getFavorite())
                    .build()
            );
        }
        return stressFavoriteResponseDtoList;
    }

    @Transactional
    public Long saveHatePost(StressHateSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return stressHateRepository.save(dto.toEntity()).getUser().getNum();
    }

    @Transactional
    public Long saveLikePost(StressFavoriteSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return stressFavoriteRepository.save(dto.toEntity()).getUser().getNum();
    }
}
