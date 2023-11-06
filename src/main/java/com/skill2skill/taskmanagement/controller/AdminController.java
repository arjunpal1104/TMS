package com.skill2skill.taskmanagement.controller;
import com.skill2skill.taskmanagement.dto.request.AdminLoginRegistrationRequest;
import com.skill2skill.taskmanagement.dto.request.AdminRegistrationRequest;
import com.skill2skill.taskmanagement.dto.request.PasswordforgetRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.service.abstraction.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.skill2skill.taskmanagement.utils.EndPoints.*;

@RestController
@RequestMapping(value =Admin)
public class AdminController {


    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(value = Registration)
    public GenericResponse register(@RequestBody AdminRegistrationRequest adminRegistrationRequest) {
        return adminService.register(adminRegistrationRequest);
    }

    @PostMapping(value = Login)
    public GenericResponse login(@RequestBody AdminLoginRegistrationRequest adminLoginRegistrationRequest) {
        return adminService.login(adminLoginRegistrationRequest);
    }


    @PostMapping(value=FORGETPASSWORD)
    public GenericResponse forgotPassword(@RequestParam PasswordforgetRequest request) {
        return adminService.forgetpassword(request);
    }
}