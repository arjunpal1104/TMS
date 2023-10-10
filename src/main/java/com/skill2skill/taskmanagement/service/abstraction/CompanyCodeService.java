package com.skill2skill.taskmanagement.service.abstraction;


import com.skill2skill.taskmanagement.dto.request.CompanyRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;

public interface CompanyCodeService {
    GenericResponse CompanyCode(CompanyRegistrationRequest request);
}
