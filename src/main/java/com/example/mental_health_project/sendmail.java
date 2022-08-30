package com.example.mental_health_project;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class sendmail extends Authenticator {
    private static String  senderEmail;
    private static String  RecipientEmail;
    private static String messages;
    private static String password;
   public sendmail(String senderEmail,String RecipientEmail,String password,String messages){
       this.senderEmail = senderEmail;
       this.RecipientEmail = RecipientEmail;
       this.password = password;
       this.messages = messages;
       main();
   }
    public static void main() {

        // Recipient's email ID needs to be mentioned.
        String to = RecipientEmail;

        // Sender's email ID needs to be mentioned
        String from = senderEmail;

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("patient reservation");

            // Now set the actual message
            message.setText(String.valueOf(messages)); // add patient data

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}

