package com.proiect.scd.proiectSCD.service;

import com.mailjet.client.errors.MailjetException;
import com.proiect.scd.proiectSCD.entity.Employee;

import java.util.List;

public interface EmailService {
    boolean sendEmail(List<Employee> employeeList) throws MailjetException;
}
