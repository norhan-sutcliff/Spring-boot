package com.spring.service;

import com.spring.dto.*;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto dto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto dto);

    void deleteUser(Long id);

    List<PostDto> getPostsByUserId(Long userId);

    List<UserWithPostsDto> getAllUsersWithPosts();

    UserWithPostsDto getUserWithPostsById(Long id);
}
