package javatutorials.javamail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.*;
public class JavaMailUtil {
    public static void sendMail(String recipient) throws Exception {

        System.out.println("Preparing Message");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put(" mail.smtp.starttls.enable","true");
        properties.put(" mail.smtp.host","smtp.gmail.com");
        properties.put(" mail.smtp.port","587");



        String myAccountEmail= "evansasuboahcapp@gmail.com";
        String password= "Asuboah99$";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });



        Message message = prepareMessage(session,myAccountEmail,recipient);
        Transport.send(message);
        System.out.println("Message Sent Successfully");

    }
    private  static Message prepareMessage(Session session, String myAccountEmail,String recipient){

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
            message.setSubject("Email confirmation");
            message.setText("You have registered for scholarship blog");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }



}
