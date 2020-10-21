package com.platform.oauth2.service.mapper;

import com.platform.oauth2.dto.UserDto;
import com.platform.oauth2.entity.user.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(UserDto source);

    @InheritInverseConfiguration
    UserDto map(User entity);
}
