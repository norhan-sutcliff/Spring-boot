package com.spring.dao;

import com.spring.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);
}
