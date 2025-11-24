package com.spring.boot.controller;

import com.spring.boot.dto.EmailDto;
import com.spring.boot.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {
    private EmailService emailService;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping
    public ResponseEntity<EmailDto> createEmail(@Valid @RequestBody EmailDto dto) {
        EmailDto created = emailService.createEmail(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmailDto> updateEmail(@PathVariable Long id,
                                                @Valid @RequestBody EmailDto dto) {
        EmailDto updated = emailService.updateEmail(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }


    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<EmailDto>> getEmailsByName(@PathVariable String name) {
        return ResponseEntity.ok(emailService.getEmailsByName(name));
    }


    @PostMapping("/by-names")
    public ResponseEntity<List<EmailDto>> getEmailsByNames(@RequestBody List<String> names) {
        return ResponseEntity.ok(emailService.getEmailsByNames(names));
    }


    @GetMapping("/by-content")
    public ResponseEntity<List<EmailDto>> getEmailsByContent(@RequestParam String content) {
        return ResponseEntity.ok(emailService.getEmailsByContent(content));
    }
}
