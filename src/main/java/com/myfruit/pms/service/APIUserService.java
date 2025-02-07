package com.myfruit.pms.service;

import com.myfruit.pms.dto.UserDto;
import com.myfruit.pms.mapper.APIUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class APIUserService {
    private final APIUserMapper apiUserMapper;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserDto userDTO) {
        String encodedPw = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPw);
        userDTO.setEnabled(userDTO.isEnabled());

        // 사용자 등록
        apiUserMapper.save(userDTO);
        // 권한 등록
        apiUserMapper.insertUserRole(userDTO.getId(), 1);
    }
}