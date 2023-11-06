package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.AdminDao;
import com.skill2skill.taskmanagement.dto.request.AdminLoginRegistrationRequest;
import com.skill2skill.taskmanagement.dto.request.AdminRegistrationRequest;
import com.skill2skill.taskmanagement.dto.request.PasswordforgetRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Admin;
import com.skill2skill.taskmanagement.service.abstraction.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j

public class AdminServiceImpl implements AdminService {

//    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
//    private static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static final String NUMBER = "0123456789";
//    private static final String SPECIAL = "!@#$%^&*()_+";
//    private static SecureRandom random = new SecureRandom();

    private final AdminDao adminDao;

    private  final JavaMailSender javaMailSender;
    @Autowired
    public AdminServiceImpl(AdminDao adminDao, JavaMailSender javaMailSender) {
        this.adminDao = adminDao;

        this.javaMailSender = javaMailSender;
    }

    @Override
    public GenericResponse register(AdminRegistrationRequest request) {


        Admin admin = new Admin();
        admin.setUserName(request.getUserName());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        Admin admin1 = adminDao.save(admin);
        log.info("AdminService ->Admin details : {}", admin1);
        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("success")
                .messageCode("200")
                .build();
    }

    @Override
    public GenericResponse login(AdminLoginRegistrationRequest request) {
        Admin admin = adminDao.findByEmail(request.getEmail());
        if (admin == null)
            return GenericResponse.builder()
                    .message("Invalid user name or password")
                    .messageCode("401")
                    .build();
        else if (request.getPassword().equals(admin.getPassword())) {

            return GenericResponse.builder()
                    .status(String.valueOf(1))
                    .message("Success")
                    .messageCode("200")
                    .build();
        } else {
            return GenericResponse.builder()
                    .message("Invalid user name or password")
                    .messageCode("401")
                    .build();
        }

    }

    @Override
    public GenericResponse forgetpassword(PasswordforgetRequest request) {
        Admin adminEmail = adminDao.findByEmail(request.getEmail());

        if (adminEmail != null) {
//            String randomPassword = generateRandomPassword(8);
            String resetToken = generateResetToken();
            adminEmail.setToken(resetToken);
//            adminEmail.setPassword(randomPassword);
            adminDao.save(adminEmail);
            log.info("password reset->" + adminEmail);

            sendResetEmail(adminEmail,resetToken);
            return GenericResponse.builder().
                    message("success password reset").
                    messageCode("200")
                    .build();


        } else {
            log.info("Admin email not found");
            return GenericResponse.builder()
                    .message("Email not found")
                    .messageCode("401").
                    build();
        }

    }

    private void sendResetEmail(Admin adminEmail,String resetToken) {
        String resetPasswordLink = "https://example.com/reset-password?token=" +resetToken;


        sendPasswordResetEmail(adminEmail, "Click the link to reset your password:" + resetPasswordLink);
    }

    private void sendPasswordResetEmail(Admin to, String link) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to.getEmail());
        message.setSubject("Password Reset Request");
        message.setText("To reset your password, click the following link: " + link);
        javaMailSender.send(message);
    }

    private String generateResetToken() {
        return UUID.randomUUID().toString();
    }
//    private String generateRandomPassword(int length) {
//
//        String allChars = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL;
//        StringBuilder password = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            int randomIndex = random.nextInt(allChars.length());
//            password.append(allChars.charAt(randomIndex));
//        }
//        return password.toString();
//
//    }


}


