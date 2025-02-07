package com.myfruit.pms.dto;

import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private boolean enabled;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    //	private String role;
    private List<RoleDto> roles;
}
