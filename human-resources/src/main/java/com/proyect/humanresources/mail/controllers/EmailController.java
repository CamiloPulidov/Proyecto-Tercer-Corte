package com.proyect.humanresources.mail.controllers;

import com.proyect.humanresources.mail.service.IEmailService;
import com.proyect.humanresources.mail.service.models.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {
    @Autowired
    IEmailService emailService;

    @PostMapping("/send-email")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto, byte[] attachmentBytes, String attachmentFileName) {
        try {
            emailService.sendEmail(emailDto, attachmentBytes, attachmentFileName);
            return new ResponseEntity<>("Correo enviado exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al enviar el correo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
