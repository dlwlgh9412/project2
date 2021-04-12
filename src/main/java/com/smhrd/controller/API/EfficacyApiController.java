package com.smhrd.controller.API;

import com.smhrd.model.assignment.efficacy.EfficacyPositiveSaveDto;
import com.smhrd.model.assignment.efficacy.EfficacyRoleSaveDto;
import com.smhrd.model.assignment.efficacy.EfficacySucSaveDto;
import com.smhrd.service.assignment.EfficacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state/assignment/efficacy")
public class EfficacyApiController {
    @Autowired
    private EfficacyService efficacyService;

    @PostMapping("/save/suc")
    public Long saveSuc(@RequestBody EfficacySucSaveDto dto) {
        return efficacyService.saveSucPost(dto);
    }

    @PostMapping("/save/role")
    public Long saveRole(@RequestBody EfficacyRoleSaveDto dto) {
        return efficacyService.saveRolePost(dto);
    }

    @PostMapping("/save/positive")
    public Long savePositive(@RequestBody EfficacyPositiveSaveDto dto) {
        return efficacyService.savePositivePost(dto);
    }



}
