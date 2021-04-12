package com.smhrd.service.assignment;

import com.smhrd.model.assignment.efficacy.*;
import com.smhrd.repository.assignment.efficacy.positive.EfficacyPositiveRepository;
import com.smhrd.repository.assignment.efficacy.roleModel.EfficacyRoleModelRepository;
import com.smhrd.repository.assignment.efficacy.success.EfficacySuccessRepository;
import com.smhrd.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EfficacyService {
    private EfficacySuccessRepository efficacySuccessRepository;
    private EfficacyRoleModelRepository efficacyRoleModelRepository;
    private EfficacyPositiveRepository efficacyPositiveRepository;
    private UserRepository userRepository;

    @Transactional
    public List<EfficacySuccessResponseDto> getEfficacySuc(String id) {
        List<EfficacySuccess> efficacySuccessList = efficacySuccessRepository.getEfficacySuccessByUserId(id);
        List<EfficacySuccessResponseDto> efficacySuccessResponseDtoList = new ArrayList<>();
        for(EfficacySuccess efficacySuccess : efficacySuccessList) {
            efficacySuccessResponseDtoList.add(EfficacySuccessResponseDto.builder()
                .createdDate(efficacySuccess.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .success(efficacySuccess.getSuccess())
                .build());
        }

        return efficacySuccessResponseDtoList;
    }

    @Transactional
    public List<EfficacyPositiveResponseDto> getEfficacyPositive(String id) {
        List<EfficacyPositive> efficacyPositiveList = efficacyPositiveRepository.getEfficacyPositiveByUserId(id);
        List<EfficacyPositiveResponseDto> efficacySuccessResponseDtoList = new ArrayList<>();
        for(EfficacyPositive efficacyPositive : efficacyPositiveList) {
            efficacySuccessResponseDtoList.add(EfficacyPositiveResponseDto.builder()
                    .createdDate(efficacyPositive.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .positive(efficacyPositive.getPositive())
                    .build());
        }
        return efficacySuccessResponseDtoList;
    }

    @Transactional
    public List<EfficacyRoleModelResponseDto> getEfficacyRoleModel(String id) {
        List<EfficacyRoleModel> efficacyRoleModelList = efficacyRoleModelRepository.getEfficacyRoleModelByUserId(id);
        List<EfficacyRoleModelResponseDto> efficacyRoleModelResponseDtoList = new ArrayList<>();
        for(EfficacyRoleModel efficacyRoleModel : efficacyRoleModelList) {
            efficacyRoleModelResponseDtoList.add(EfficacyRoleModelResponseDto.builder()
                .createdDate(efficacyRoleModel.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .roleModel(efficacyRoleModel.getRoleModel())
                .build());
        }

        return efficacyRoleModelResponseDtoList;
    }

    @Transactional
    public Long saveSucPost(EfficacySucSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return efficacySuccessRepository.save(dto.toEntity()).getUser().getNum();
    }

    @Transactional
    public Long saveRolePost(EfficacyRoleSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return efficacyRoleModelRepository.save(dto.toEntity()).getUser().getNum();
    }

    @Transactional
    public Long savePositivePost(EfficacyPositiveSaveDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dto.setUser(userRepository.findByUserId(authentication.getName()));
        return efficacyPositiveRepository.save(dto.toEntity()).getUser().getNum();

    }
}
