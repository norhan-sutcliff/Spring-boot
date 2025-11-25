package com.spring.mapper;

import com.spring.dto.PostDto;
import com.spring.dto.PostWithUserDto;
import com.spring.dto.SimpleUserDto;
import com.spring.model.Post;
import com.spring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "user.id", target = "userId")
    PostDto toDto(Post post);

    @Mapping(target = "user", ignore = true)
    Post toEntity(PostDto dto);

    @Mapping(source = "user", target = "user")
    PostWithUserDto toPostWithUserDto(Post post);

    List<PostDto> toDtoList(List<Post> posts);

    List<PostWithUserDto> toPostWithUserDtoList(List<Post> posts);

    default SimpleUserDto userToUserSimpleDto(User user) {
        if (user == null) return null;
        SimpleUserDto dto = new SimpleUserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        return dto;
    }
}
