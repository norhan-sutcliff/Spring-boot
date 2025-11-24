package com.spring.boot.service.impl;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.entity.Employee;
import com.spring.boot.repo.EmployeeRepository;
import com.spring.boot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = modelMapper.map(dto, Employee.class);
        if (employee.getEmails() != null) {
            employee.getEmails().forEach(email -> email.setEmployee(employee));
        }
        EmployeeDto newDto = modelMapper.map(employeeRepository.save(employee),EmployeeDto.class);
        return newDto;
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee employee = employeeRepository.findById(id).get();
        // mapping to another object transfers the data from dto to employee
        modelMapper.map(dto, employee);
        if (employee.getEmails() != null) {
            employee.getEmails().forEach(email -> email.setEmployee(employee));
        }


        Employee newDto = employeeRepository.save(employee);
        return modelMapper.map(newDto, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not existed with id " + id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not existed with id " + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getEmployeesByIds(List<Long> ids) {
        return employeeRepository.findByIdList(ids).stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByNames(List<String> names) {
        return employeeRepository.findByNameList(names).stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
