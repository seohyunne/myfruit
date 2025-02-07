package com.myfruit.pms.service;

import java.util.List;
import java.util.stream.Collectors;

import com.myfruit.pms.dto.UserDto;
import com.myfruit.pms.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDTO = userMapper.findByUsername(username);
        if (userDTO == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<GrantedAuthority> authorities = userDTO.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.isEnabled(),
                true, true, true,
                //Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
                authorities);
    }

}

