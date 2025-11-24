package com.spring.boot.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;

    @NotBlank(message = "Employee name cannot be empty")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 16, message = "Age should be greater than 15")
    @Max(value = 39, message = "Age should be less than 40")
    private Integer age;

    @NotNull(message = "Salary cannot be empty")
    @Min(value = 5001, message = "Salary must be greater than 5000")
    @Max(value = 9999, message = "Salary must be less than 10000")
    private Integer salary;

    @Valid
    private List<EmailDto> emails;
}
