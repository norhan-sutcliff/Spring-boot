package com.spring.dto;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
public class UserDto {

    private Long id;

    @NotBlank
    @Size(min = 8, message = "Name must be greater than 7 characters")
    private String name;

    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
            message = "Password must contain upper, lower, number, and special character"
    )
    private String password;
}
