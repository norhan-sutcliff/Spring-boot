package com.spring.controller;

import com.spring.dto.PostDto;
import com.spring.dto.PostWithUserDto;
import com.spring.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostDto createPost(@Valid @RequestBody PostDto dto) {
        return postService.createPost(dto);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable Long id,
                              @Valid @RequestBody PostDto dto) {
        return postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/postsWithUsers")
    public List<PostWithUserDto> getPostsWithUsers() {
        return postService.getAllPostsWithUsers();
    }

    @GetMapping("/postWithUsers/{id}")
    public PostWithUserDto getPostWithUser(@PathVariable Long id) {
        return postService.getPostWithUserById(id);
    }
}
