package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.dao.PostDao;
import com.spring.dto.*;
import com.spring.mapper.UserMapper;
import com.spring.mapper.PostMapper;
import com.spring.model.User;
import com.spring.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PostDao postDao;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public UserServiceImpl(UserDao userDao, PostDao postDao, UserMapper userMapper, PostMapper postMapper) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.userMapper = userMapper;
        this.postMapper = postMapper;
    }

    @Override
    public UserDto createUser(UserDto dto) {
        User user = userMapper.toEntity(dto);
        user.setId(null);
        return userMapper.toDto(userDao.save(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.toDto(
                userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtoList(userDao.findAll());
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());

        return userMapper.toDto(userDao.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<PostDto> getPostsByUserId(Long id) {
        return postMapper.toDtoList(postDao.findByUserId(id));
    }

    @Override
    public List<UserWithPostsDto> getAllUsersWithPosts() {
        List<User> users = userDao.findAll();
        List<UserWithPostsDto> dtoList = userMapper.toUserWithPostsDtoList(users);

        for (int i = 0; i < users.size(); i++) {
            dtoList.get(i).setPosts(
                    postMapper.toDtoList(users.get(i).getPosts())
            );
        }
        return dtoList;
    }

    @Override
    public UserWithPostsDto getUserWithPostsById(Long id) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserWithPostsDto dto = userMapper.toUserWithPostsDto(user);
        dto.setPosts(postMapper.toDtoList(user.getPosts()));
        return dto;
    }
}
