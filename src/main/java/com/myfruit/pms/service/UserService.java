package com.myfruit.pms.service;

import com.myfruit.pms.dto.RoleDto;
import com.myfruit.pms.dto.UserDto;
import com.myfruit.pms.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void signup(String username, String password){

        // 회원 정보
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(passwordEncoder.encode(password));
        userDto.setEnabled(true);

        // 역할 정보
        // RoleDto roleDto = new RoleDto();

       userMapper.save(userDto);
//       userMapper.insertUserRole(userDto.getId(),1);
    }
}
