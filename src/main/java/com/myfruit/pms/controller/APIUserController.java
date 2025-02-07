package com.myfruit.pms.controller;

import com.myfruit.pms.component.JwtUtil;
import com.myfruit.pms.dto.UserDto;
import com.myfruit.pms.service.APIUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class APIUserController {

    private final APIUserService apiUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto userDTO) {
        apiUserService.signup(userDTO);
        return ResponseEntity.ok("Signup successful");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.get("username"), user.get("password"))
            );

            String token = jwtUtil.generateToken(authentication.getName());
            return Map.of("token", token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
