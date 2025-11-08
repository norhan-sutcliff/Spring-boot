package com.spring.boot.service;

import com.spring.boot.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    List<Employee> findEmployeesByIds(List<Long> ids);
    void saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    void deleteAllEmployees();
    void deleteEmployeesByIds(List<Long> ids);
    List<Employee> findByNameLike(String namePattern);
    List<Employee> searchByNameNative(String namePattern);
}