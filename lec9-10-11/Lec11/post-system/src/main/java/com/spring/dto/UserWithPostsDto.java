package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithPostsDto {

    private Long id;
    private String name;
    private Integer age;

    private List<PostDto> posts;
}
