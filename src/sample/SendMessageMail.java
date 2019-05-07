package sample;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class SendMessageMail {


    static void sendFromGMail(String[] to, String subject, String body) {
        String from = "b1rr0game";  // GMail user name (just the part before "@gmail.com")
        String pass = "zifibe02"; // GMail password
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }

    }

    public static int generCode() {
        Random rnd = new Random(System.currentTimeMillis());
        return rnd.nextInt(9000) + 1000;
    }

    public static int mailRegis(String RECIPIENT, int g) {

        String[] to = {RECIPIENT}; // list of recipient email addresses
        String subject = "Регистрация в игре";
        String body = "Добро пожаловать введите код для продолжения регистрации - ";//
        SendMessageMail.sendFromGMail(to, subject, body + g);

        return g;
    }


}






