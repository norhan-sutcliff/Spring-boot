package com.spring.boot.service.impl;

import com.spring.boot.model.Employee;
import com.spring.boot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceEmpl {

    EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeServiceEmpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public List<Employee> findEmployeesByIds(List<Long> ids) {
        List<Employee> employees = employeeRepo.findAllById(ids);
        return employees;
    }
    public void saveEmployee(Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("New employee ID must be null when saving a new record.");
        }
        employeeRepo.save(employee);
    }
    public Employee updateEmployee(Employee employee) {
        if(employee.getId() == null){
            throw new IllegalArgumentException("Employee ID must not be null when updating a record.");
        }
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }
    public void deleteEmployeesByIds(List<Long> ids) {
        employeeRepo.deleteAllById(ids);
    }
    public List<Employee> findByNameLike(String namePattern) {
        return employeeRepo.findByNameLike(namePattern);
    }
    public List<Employee> searchByNameNative(String namePattern) {
        return employeeRepo.searchByNameNative(namePattern);
    }
}
