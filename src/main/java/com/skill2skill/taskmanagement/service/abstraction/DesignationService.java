package com.skill2skill.taskmanagement.service.abstraction;

import com.skill2skill.taskmanagement.dto.request.AddUpdateDesignationDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.CompanyDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.DesignationDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.repository.DesignationRepository;

import java.util.List;

public interface DesignationService {

    GenericResponse addUpdateDesignationDetails(AddUpdateDesignationDetailsRequest request);

    DesignationDetailsListResponse designationList();
    GenericResponse deleteDesignationById(Integer designationId);

    List<String> fetchCompanyName();
    List<String>fetchDepartmentName();
}
