package com.spring.boot.service.impl;

import com.spring.boot.dto.EmailDto;
import com.spring.boot.entity.Email;
import com.spring.boot.entity.Employee;
import com.spring.boot.repo.EmailRepository;
import com.spring.boot.repo.EmployeeRepository;
import com.spring.boot.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository,EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.emailRepository = emailRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmailDto createEmail(EmailDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).get();
        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }
        Email emailNew = modelMapper.map(dto, Email.class);

        emailNew.setEmployee(employee);
        return modelMapper.map(emailRepository.save(emailNew), EmailDto.class);
    }

    @Override
    public EmailDto updateEmail(Long id, EmailDto dto) {
        Email email = emailRepository.findById(id).get();
        if (email == null) {
            throw new RuntimeException("Email not existed");
        }
        // mapping between objects transfers data from dto to email
        modelMapper.map(dto, email);

        if (dto.getEmployeeId() != null &&
                !dto.getEmployeeId().equals(email.getEmployee().getId())) {

            Employee newEmp = employeeRepository.findById(dto.getEmployeeId()).get();
            email.setEmployee(newEmp);
        }

        Email newEmail = emailRepository.save(email);
        return modelMapper.map(email, EmailDto.class);
    }

    @Override
    public void deleteEmail(Long id) {
        if (!emailRepository.existsById(id)) {
            throw new RuntimeException("Email not existed with id " + id);
        }
        emailRepository.deleteById(id);
    }

    @Override
    public List<EmailDto> getAllEmails() {
        return emailRepository.findAll().stream()
                .map(email -> modelMapper.map(email, EmailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByName(String name) {
        return emailRepository.findByName(name).stream()
                .map(email -> modelMapper.map(email, EmailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByNames(List<String> names) {
        return emailRepository.findByNameList(names).stream()
                .map(email -> modelMapper.map(email, EmailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByContent(String content) {
        return emailRepository.findByContent(content).stream()
                .map(email -> modelMapper.map(email, EmailDto.class))
                .collect(Collectors.toList());
    }
}
