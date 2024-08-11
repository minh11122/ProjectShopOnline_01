/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.RegistrationDTO;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.catalina.User;

/**
 *
 * @author ADMIN
 */
public class SendMail {

    public boolean sendEmailRegister(String toMail) throws javax.mail.MessagingException {
        boolean test = false;
        String fromEmail = "truonghmhe163617@fpt.edu.vn";
        String password = "aose lzcu dxzb yvna";
        // Thông tin tài khoản email người nhận
        String toEmail = toMail;
// Cấu hình các thuộc tính cho việc gửi email
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
// Tạo session để gửi email sử dụng thông tin tài khoản email của fromEmail và password để xác thực 
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        //content gmail
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("Comfirm Register");
        message.setText("Click the following link to comfirm your account: http://localhost:9999/PROJECT/verify");
        // Gửi email
        Transport.send(message);
        test = true;
        // neu gui email thanh cong test = true

        return test;
        //   // neu gui email khong thanh cong test = false  
    }

    public boolean sendEmailResetPass(String emailReset) {
        boolean test = false;
        String fromEmail = "truonghmhe163617@fpt.edu.vn";
        String password = "aose lzcu dxzb yvna";
        // Thông tin tài khoản email người nhận
        String toEmail = emailReset;
// Cấu hình các thuộc tính cho việc gửi email
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
// Tạo session để gửi email sử dụng thông tin tài khoản email của fromEmail và password để xác thực 
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            //content gmail 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Reset Password");
            message.setText("Click the following link to reset your password: http://localhost:9999/PROJECT/changePassResetServlet");
// Gửi email
            Transport.send(message);
            test = true;
            // neu gui email thanh cong test = true 
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return test;
        //   // neu gui email khong thanh cong test = false  
    }

}
