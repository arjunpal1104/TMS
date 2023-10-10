package com.skill2skill.taskmanagement.service.abstraction;


import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
import com.skill2skill.taskmanagement.dto.request.EmployeeRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Employee;
import org.springframework.context.annotation.Bean;


public interface EmployeeService {
    GenericResponse register(EmployeeRegistrationRequest request);
    GenericResponse login(EmployeeLoginRequest request);


}
