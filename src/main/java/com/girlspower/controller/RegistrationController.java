package com.girlspower.controller;

import com.girlspower.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping()
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          Map<String, Object> model) {

        String message = userService.addUser(username, password);
        if (!StringUtils.isEmpty(message)) {
            model.put("message", message);
            return "registration";
        }

        return "redirect:/login";
    }
}
