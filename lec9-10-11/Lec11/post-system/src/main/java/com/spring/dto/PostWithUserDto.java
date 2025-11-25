package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostWithUserDto {

    private Long id;
    private String text;
    private String imagePath;

    private SimpleUserDto user;
}
