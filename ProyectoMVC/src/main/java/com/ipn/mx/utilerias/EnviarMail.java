/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author axel_
 */
public class EnviarMail {
    public void enviarCorreo(String destinatario, String asunto, String mensaje){
        try {
            //Propiedades de la Conexión
            Properties p = new Properties();
            p.setProperty("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", "axelcuevas4321@gmail.com");
            p.setProperty("mail.smtp.auth", "true");
            
            //Crear la sesión
            Session session = Session.getDefaultInstance(p);
            //Trabajar con el mensaje
            MimeMessage m = new MimeMessage(session);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            m.setSubject(asunto);
            m.setText(mensaje);
            Transport t = session.getTransport("smtp");
            t.connect(p.getProperty("mail.smtp.user"), "ruben1980");
            t.sendMessage(m, m.getAllRecipients());
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarCorreoArchivo(String destinatario, String asunto, String mensaje, File pdf){
        try {
            //Propiedades de la Conexión
            Properties p = new Properties();
            p.setProperty("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", "axelcuevas4321@gmail.com");
            p.setProperty("mail.smtp.auth", "true");
            
            //Crear la sesión
            Session session = Session.getDefaultInstance(p);
            //Trabajar con el mensaje
            MimeMessage m = new MimeMessage(session);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            m.setSubject(asunto);
            m.setText(mensaje);
            m.setFileName(pdf.getPath());
            Transport t = session.getTransport("smtp");
            t.connect(p.getProperty("mail.smtp.user"), "ruben1980");
            t.sendMessage(m, m.getAllRecipients());
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        EnviarMail mail = new EnviarMail();
        mail.enviarCorreo("axelcoevas@gmail.com", "ia te kayo la lei", "k pedo perro moriste");
    }
}
