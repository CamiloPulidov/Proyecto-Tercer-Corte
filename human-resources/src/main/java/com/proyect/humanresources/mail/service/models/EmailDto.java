package com.proyect.humanresources.mail.service.models;

import java.util.List;

public class EmailDto {
    private List<String> destinatario;
    private String asunto;
    private String mensaje;

    public List<String> getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(List<String> destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}