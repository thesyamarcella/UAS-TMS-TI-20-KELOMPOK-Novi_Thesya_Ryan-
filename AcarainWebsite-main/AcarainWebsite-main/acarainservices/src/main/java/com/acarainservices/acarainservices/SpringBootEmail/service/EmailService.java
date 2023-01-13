// Java Program to Illustrate Creation Of
// Service Interface
package com.acarainservices.acarainservices.SpringBootEmail.service;

import com.acarainservices.acarainservices.SpringBootEmail.EmailDetails;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails emaildetails);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails emaildetails);
}