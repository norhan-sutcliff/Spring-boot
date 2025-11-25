package com.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private Long id;

    @NotBlank
    @Size(min = 20, message = "Text must be at least 20 characters")
    private String text;

    private String imagePath;

    private Long userId;
}
