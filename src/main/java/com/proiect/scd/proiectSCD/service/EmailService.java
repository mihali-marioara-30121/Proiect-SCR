package com.proiect.scd.proiectSCD.service;

import com.mailjet.client.errors.MailjetException;
import com.proiect.scd.proiectSCD.dtos.EmailDTO;

import java.util.List;

public interface EmailService {
    boolean sendEmail(EmailDTO employees) throws MailjetException;
}
