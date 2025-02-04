package com.myfruit.pms.controller;

import com.myfruit.pms.dto.UserDto;
import com.myfruit.pms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/auth/signup")
    public String signup(){
        return "/user/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password) {

        // 사용자 저장 <= user
        // useGeneratedKeys="true" keyProperty="id" 맵퍼 xml에 추가해야 함!!!
        userService.signup( username, password);
        // 권한 부여 ROLE_USER
//        userMapper.insertUserRole(user.getId(), 1L);

        return "redirect:/auth/login";
    }



}
