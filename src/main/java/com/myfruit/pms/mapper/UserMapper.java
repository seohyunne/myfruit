package com.myfruit.pms.mapper;

import com.myfruit.pms.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void save(UserDto user);
    void insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);
}
