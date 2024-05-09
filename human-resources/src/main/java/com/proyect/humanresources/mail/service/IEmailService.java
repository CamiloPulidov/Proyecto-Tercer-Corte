package com.proyect.humanresources.mail.service;

import com.proyect.humanresources.mail.service.models.EmailDto;

public interface IEmailService {
    public void sendEmail(EmailDto emailDto, byte[] attachmentBytes, String attachmentFileName);
}