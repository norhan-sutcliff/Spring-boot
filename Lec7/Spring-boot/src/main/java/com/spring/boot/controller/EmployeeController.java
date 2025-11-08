package com.spring.boot.controller;

import com.spring.boot.model.Employee;
import com.spring.boot.service.EmployeeService;
import com.spring.boot.service.impl.EmployeeServiceEmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeServiceEmpl employeeServiceEmpl;
    @Autowired
    public EmployeeController(EmployeeServiceEmpl employeeServiceEmpl) {
        this.employeeServiceEmpl = employeeServiceEmpl;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeServiceEmpl.findAllEmployees();
    }
    @GetMapping("/employeesbyids")
    public List<Employee> getEmployeesByIds(@RequestBody List<Long> ids) {
        return employeeServiceEmpl.findEmployeesByIds(ids);
    }
    @PostMapping("/save")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeServiceEmpl.saveEmployee(employee);
    }
    @PostMapping("/saveall")
    public void saveAllEmployees(@RequestBody List<Employee> employees) {
        employees.forEach(employeeServiceEmpl::saveEmployee);
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeServiceEmpl.updateEmployee(employee);
    }
    @PutMapping("/updateall")
    public List<Employee> UpdateEmployees(@RequestBody List<Employee> employees) {
        return employees.stream().map(employeeServiceEmpl::updateEmployee).toList();
    }
    @DeleteMapping("/delete")
    public void deleteEmployee(Long id){
        employeeServiceEmpl.deleteEmployee(id);
    }
    @DeleteMapping("/deletelist")
    public void deleteAllEmployees(@RequestBody List<Long> ids){
        employeeServiceEmpl.deleteEmployeesByIds(ids);
    }
    @DeleteMapping("/deleteall")
    public void deleteAllEmployees(){
        employeeServiceEmpl.deleteAllEmployees();
    }
    // replace % with %25 in url so the parameter is passed as we wish.
    @GetMapping("/search")
    public List<Employee> searchEmployeesByName(@RequestParam String namePattern) {
        return employeeServiceEmpl.findByNameLike(namePattern);
    }

    @GetMapping("/search/native")
    public List<Employee> searchEmployeesByNameNative(@RequestParam String namePattern) {
        return employeeServiceEmpl.searchByNameNative(namePattern);
    }
}
