package com.myfruit.pms.mapper;

import com.myfruit.pms.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void save(UserDto user);

    UserDto findByUsername(String username);

}
