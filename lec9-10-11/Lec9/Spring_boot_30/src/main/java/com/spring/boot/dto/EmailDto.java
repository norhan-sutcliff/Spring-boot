package com.spring.boot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDto {
    private Long id;
    @NotBlank(message = "Email name cannot be empty")
    private String name;
    @NotBlank(message = "Email content cannot be empty")
    private String content;
    @NotNull(message = "employeeId cannot be null")
    @Email(message = "Email content should be valid email")
    private Long employeeId;
}
