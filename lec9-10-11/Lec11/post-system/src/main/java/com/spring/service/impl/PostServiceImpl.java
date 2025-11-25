package com.spring.service.impl;

import com.spring.dao.PostDao;
import com.spring.dao.UserDao;
import com.spring.dto.PostDto;
import com.spring.dto.PostWithUserDto;
import com.spring.mapper.PostMapper;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostDao postDao;
    private final UserDao userDao;
    private final PostMapper postMapper;

    public PostServiceImpl(PostDao postDao, UserDao userDao, PostMapper postMapper) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto createPost(PostDto dto) {
        Post post = postMapper.toEntity(dto);

        if (dto.getUserId() != null) {
            User user = userDao.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            post.setUser(user);
        }

        return postMapper.toDto(postDao.save(post));
    }

    @Override
    public PostDto getPostById(Long id) {
        return postMapper.toDto(
                postDao.findById(id).orElseThrow(() -> new RuntimeException("Post not found"))
        );
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postMapper.toDtoList(postDao.findAll());
    }

    @Override
    public PostDto updatePost(Long id, PostDto dto) {
        Post post = postDao.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());

        if (dto.getUserId() != null) {
            User user = userDao.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            post.setUser(user);
        }

        return postMapper.toDto(postDao.save(post));
    }

    @Override
    public void deletePost(Long id) {
        postDao.deleteById(id);
    }

    @Override
    public List<PostWithUserDto> getAllPostsWithUsers() {
        return postMapper.toPostWithUserDtoList(postDao.findAll());
    }

    @Override
    public PostWithUserDto getPostWithUserById(Long id) {
        Post post = postDao.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return postMapper.toPostWithUserDto(post);
    }
}
