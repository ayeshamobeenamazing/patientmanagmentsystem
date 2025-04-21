
package assignment3.models;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;


public class EmailNotification implements Notifyable {

    @Override
    public void sendNotification(String to, String message) {
        // Sender email credentials
        final String from = "ayeshamobeen101004@gmail.com";
        final String password = "hxyn bbfy zosw lpmd"; 

        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Auth
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(from));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            email.setSubject("Healthcare Reminder");
            email.setText(message);

            Transport.send(email);
            System.out.println("✅ Email sent to " + to);
        } catch (MessagingException e) {
            System.out.println("❌ Failed to send email: " + e.getMessage());
        }
    }
}
