package com.skill2skill.taskmanagement.service.abstraction;

import com.skill2skill.taskmanagement.dto.request.AddUpdateCompanyDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.CompanyDetail;
import com.skill2skill.taskmanagement.dto.response.CompanyDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;

import java.util.List;

public interface CompanyService {

    GenericResponse addUpdateCompanyDetails(AddUpdateCompanyDetailsRequest request);

    CompanyDetailsListResponse companyList();
    List<CompanyDetail> searchByLocation(String location);
}
