package com.skill2skill.taskmanagement.service.abstraction;

import com.skill2skill.taskmanagement.dto.request.EmployeeRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;

public interface EmployeeService {
    GenericResponse register(EmployeeRegistrationRequest request);
}
