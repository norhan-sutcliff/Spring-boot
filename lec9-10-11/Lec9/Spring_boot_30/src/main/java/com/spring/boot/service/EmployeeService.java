package com.spring.boot.service;

import com.spring.boot.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto dto);

    EmployeeDto updateEmployee(Long id, EmployeeDto dto);

    void deleteEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getEmployeesByIds(List<Long> ids);

    List<EmployeeDto> getEmployeesByNames(List<String> names);
}
