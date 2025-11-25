package com.spring.service;

import com.spring.dto.PostDto;
import com.spring.dto.PostWithUserDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto dto);

    PostDto getPostById(Long id);

    List<PostDto> getAllPosts();

    PostDto updatePost(Long id, PostDto dto);

    void deletePost(Long id);

    List<PostWithUserDto> getAllPostsWithUsers();

    PostWithUserDto getPostWithUserById(Long id);
}
