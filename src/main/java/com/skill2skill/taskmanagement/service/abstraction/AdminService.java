package com.skill2skill.taskmanagement.service.abstraction;

import com.skill2skill.taskmanagement.dto.request.AdminLoginRegistrationRequest;
import com.skill2skill.taskmanagement.dto.request.AdminRegistrationRequest;
import com.skill2skill.taskmanagement.dto.request.PasswordforgetRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Admin;
import org.apache.el.parser.Token;

public interface AdminService {
    GenericResponse register(AdminRegistrationRequest adminRegistrationRequest);


    GenericResponse login(AdminLoginRegistrationRequest adminLoginRegistrationRequest);

    GenericResponse forgetpassword(PasswordforgetRequest request);

}
