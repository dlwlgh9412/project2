package com.smhrd.controller.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.smhrd.model.MachineLearningRequestDto;
import com.smhrd.model.State;
import com.smhrd.model.user.SurveyDto;
import com.smhrd.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
@RestController
public class PredictApi {
    private UserService userService;
    private RestTemplate restTemplate;

    @PostMapping("/survey")
    public Long survey(@RequestBody SurveyDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MachineLearningRequestDto machineLearningRequestDto = userService.buildMachineLearningDto(dto);
        userService.changeState(authentication.getName(), requestPredict(machineLearningRequestDto));
        return userService.findByUserId(authentication.getName()).getNum();
    }

    public State requestPredict(MachineLearningRequestDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        String url = "http://127.0.0.1:5000/predict";

        ResponseEntity<Integer> getResult = restTemplate.postForEntity(url, dto, Integer.class);
        Integer result = getResult.getBody();
        if (result != null) {
            if (result == 1) {
                return State.ONE;
            } else if (result == 2) {
                return State.TWO;
            } else if (result == 3) {
                return State.THREE;
            } else if (result == 4) {
                return State.FOUR;
            }
        }
        return State.ONE;
    }
}
