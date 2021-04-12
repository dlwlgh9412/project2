package com.smhrd.controller.assignment;

import com.smhrd.service.assignment.EfficacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/state/assignment/efficacy")
public class Efficacy {
    @Autowired
    private EfficacyService efficacyService;

    @GetMapping
    public String efficacy(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "efficacy";
    }

    @GetMapping("/suc")
    public String suc(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "efficacy_suc";
    }

    @GetMapping("/role")
    public String role(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "efficacy_role";
    }

    @GetMapping("/positive")
    public String posi(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "efficacy_posi";
    }

    @GetMapping("/suc/com")
    public String sucCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("suc_post", efficacyService.getEfficacySuc(authentication.getName()));
        return "efficacy_suc_com";
    }

    @GetMapping("/role/com")
    public String roleCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("role_post", efficacyService.getEfficacyRoleModel(authentication.getName()));
        return "efficacy_role_com";
    }

    @GetMapping("/positive/com")
    public String positiveCom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        model.addAttribute("posi_post", efficacyService.getEfficacyPositive(authentication.getName()));
        return "efficacy_posi_com";
    }
}
