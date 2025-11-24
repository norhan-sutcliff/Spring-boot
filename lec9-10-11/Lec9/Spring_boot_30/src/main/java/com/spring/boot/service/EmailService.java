package com.spring.boot.service;

import com.spring.boot.dto.EmailDto;

import java.util.List;

public interface EmailService {
    EmailDto createEmail(EmailDto dto);

    EmailDto updateEmail(Long id, EmailDto dto);

    void deleteEmail(Long id);

    List<EmailDto> getAllEmails();

    List<EmailDto> getEmailsByName(String name);

    List<EmailDto> getEmailsByNames(List<String> names);

    List<EmailDto> getEmailsByContent(String content);
}
