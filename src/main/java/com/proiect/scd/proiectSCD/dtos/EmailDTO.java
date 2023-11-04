package com.proiect.scd.proiectSCD.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EmailDTO {
    private String subject;
    private String message;
    List<RecipientDetails> recipientDetailsList;
}
