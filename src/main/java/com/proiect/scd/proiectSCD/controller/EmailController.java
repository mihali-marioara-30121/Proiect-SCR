package com.proiect.scd.proiectSCD.controller;

import com.mailjet.client.errors.MailjetException;
import com.proiect.scd.proiectSCD.dtos.EmailDTO;
import com.proiect.scd.proiectSCD.dtos.EmployeeDTO;
import com.proiect.scd.proiectSCD.entity.Employee;
import com.proiect.scd.proiectSCD.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;
    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTOList) {
        boolean sendSuccessfully = false;
        try {
            sendSuccessfully = emailService.sendEmail(emailDTOList);
        } catch (MailjetException e) {
            return new ResponseEntity<>("Sending email failed!", HttpStatus.BAD_REQUEST);
        }
        if (sendSuccessfully) {
            return new ResponseEntity<>("Email sent successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sending email failed", HttpStatus.BAD_REQUEST);
        }
    }
}
