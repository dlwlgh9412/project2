package com.smhrd.controller.API;

import com.smhrd.model.assignment.stress.hate.StressHateSaveDto;
import com.smhrd.model.assignment.stress.favorite.StressFavoriteSaveDto;
import com.smhrd.service.assignment.StressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state/assignment/stress")
public class StressApiController {
    @Autowired
    private StressService stressService;

    @PostMapping("/save/hate")
    public Long saveHate(@RequestBody StressHateSaveDto dto) {
        return stressService.saveHatePost(dto);
    }

    @PostMapping("/save/like")
    public Long saveLike(@RequestBody StressFavoriteSaveDto dto) {
        return stressService.saveLikePost(dto);
    }

}
