package com.skill2skill.taskmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your-mail-server-host"); // Replace with your mail server host
        mailSender.setPort(587); // Replace with your mail server port
        mailSender.setUsername("arjunpal1104@gmail.com"); // Replace with your email
        mailSender.setPassword("95460261104"); // Replace with your email password
        return mailSender;
    }
}
