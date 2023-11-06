package com.skill2skill.taskmanagement.service.abstraction;


import com.skill2skill.taskmanagement.dto.request.AddUpdateDepartmentDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.DepartmentDetail;
import com.skill2skill.taskmanagement.dto.response.DepartmentDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Company;

import java.util.List;

public interface DepartmentService {
    GenericResponse addUpdateDepartmentDetails(AddUpdateDepartmentDetailsRequest request);

    DepartmentDetailsListResponse DepartmentList();

    GenericResponse deleteDepartmentById(Integer departmentId);

    List<DepartmentDetail> searchByDepartmentName(String departmentName);
}
