package com.skill2skill.taskmanagement.controller;

import com.skill2skill.taskmanagement.dto.request.AddUpdateDesignationDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.DesignationDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.service.abstraction.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.skill2skill.taskmanagement.utils.EndPoints.*;

@RestController
@RequestMapping(value =DESIGNATION)
public class DesignationController {
    private final DesignationService designationService;

    @Autowired
    public DesignationController(DesignationService designationService) {
        this.designationService = designationService;
    }

    @PostMapping(value =ADD_UPDATE_DESIGNATION_DETAILS)
    GenericResponse addUpdateDesignationDetails(AddUpdateDesignationDetailsRequest request){
        return  designationService.addUpdateDesignationDetails(request);
    }
    @GetMapping(value =DESIGNATION_LIST)
    DesignationDetailsListResponse designationList(){
        return designationService.designationList();
    }
    @DeleteMapping(value =DESIGNATION_DELETE)
    public GenericResponse deleteDesignationById(Integer designationId){
         return designationService.deleteDesignationById(designationId);
    }
    @GetMapping(value =FETCH_COMPANY_NAME_IN_DESIGNATION)
    public List<String> fetchCompanyNames() {
        return designationService.fetchCompanyName();
    }

    @GetMapping(value =FETCH_DEPARTMENT_NAME_IN_DESIGNATION)
    public List<String> fetchDepartmentNames() {
        return designationService.fetchDepartmentName();
    }

}
