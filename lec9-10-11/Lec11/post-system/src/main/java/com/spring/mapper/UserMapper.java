package com.spring.mapper;

import com.spring.dto.SimpleUserDto;
import com.spring.dto.UserDto;
import com.spring.dto.UserWithPostsDto;
import com.spring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

    SimpleUserDto toSimpleDto(User user);

    @Mapping(target = "posts", ignore = true)
    UserWithPostsDto toUserWithPostsDto(User user);

    List<UserDto> toDtoList(List<User> users);

    List<UserWithPostsDto> toUserWithPostsDtoList(List<User> users);
}
