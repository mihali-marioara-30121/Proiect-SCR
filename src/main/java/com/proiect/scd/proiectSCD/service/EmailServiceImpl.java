package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.dtos.EmailDTO;
import com.proiect.scd.proiectSCD.dtos.RecipientDetails;
import com.proiect.scd.proiectSCD.entity.Employee;

import java.util.List;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class EmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(EmailDTO employees) throws MailjetException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient("370d3bafade5bef577969e9dbed8f180", "5b02dd0eb17c77d92d56853941d4521b");

        JSONArray recieversList = new JSONArray();
        for (RecipientDetails recipientDetails: employees.getRecipientDetailsList()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Email", recipientDetails.getEmail());
            jsonObject.put("Name", recipientDetails.getName());

            recieversList.put(jsonObject);
        }

        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "scdemailsender@gmail.com")
                                        .put("Name", "Mailjet Pilot"))
                                .put(Emailv31.Message.TO, recieversList)
                                .put(Emailv31.Message.SUBJECT, employees.getSubject())
                                .put(Emailv31.Message.TEXTPART, employees.getMessage())));

        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());

        return response.getStatus() == 200;
    }
}
