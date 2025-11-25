package com.spring.controller;

import com.spring.dto.*;
import com.spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @Valid @RequestBody UserDto dto) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getUserPosts(@PathVariable Long id) {
        return userService.getPostsByUserId(id);
    }

    @GetMapping("/usersWithPost")
    public List<UserWithPostsDto> getUsersWithPosts() {
        return userService.getAllUsersWithPosts();
    }

    @GetMapping("/userWithPost/{id}")
    public UserWithPostsDto getUserWithPosts(@PathVariable Long id) {
        return userService.getUserWithPostsById(id);
    }
}
