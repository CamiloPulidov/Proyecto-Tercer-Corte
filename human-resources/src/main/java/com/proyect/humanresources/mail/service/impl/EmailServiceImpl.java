package com.proyect.humanresources.mail.service.impl;

import com.proyect.humanresources.domain.service.EmployeeService;
import com.proyect.humanresources.mail.service.IEmailService;
import com.proyect.humanresources.mail.service.models.EmailDto;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

@Service
@EnableScheduling
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private EmployeeService employeeService;

    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl( TemplateEngine templateEngine, JavaMailSender javaMailSender) {

        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "0 42 18 * * ?") // Ejecutar todos los días a las 5:00 PM
    public void sendScheduledEmail() {

        String pdfContent = "El pago ha sido realizaado";//nuevo
        byte[] pdfBytes = generatePdf(pdfContent);//nuevo

        EmailDto email = new EmailDto();
        //email.setDestinatario(Arrays.asList("estaplicado@gmail.com","pulidios04@gmail.com"));
        email.setDestinatario(employeeService.allEmail());
        email.setAsunto("Pago Nomina");
        email.setMensaje("Adjunto desprendible de pago.");

        sendEmail(email,pdfBytes,"Pago.pdf");
    }
    @Override
    public void sendEmail(EmailDto emailDto, byte[] attachmentBytes, String attachmentFileName)  {

        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(emailDto.getDestinatario().toArray(new String[0]));
            helper.setSubject(emailDto.getAsunto());

            Context context = new Context();
            context.setVariable("mensaje", emailDto.getMensaje());
            String contentHtml = templateEngine.process("email", context);

            helper.setText(contentHtml, true);

            // Adjuntar el archivo PDF
            InputStreamSource attachmentSource = new ByteArrayResource(attachmentBytes);
            helper.addAttachment(attachmentFileName, attachmentSource);

            javaMailSender.send(message);
        }catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }

    private byte[] generatePdf(String content) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            String htmlContent = "<html><body>" + content + "</body></html>";
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF: " + e.getMessage(), e);
        }
    }

}
