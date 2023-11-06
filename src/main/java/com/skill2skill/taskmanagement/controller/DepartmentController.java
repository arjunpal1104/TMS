package com.skill2skill.taskmanagement.controller;


import com.skill2skill.taskmanagement.dto.request.AddUpdateDepartmentDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.DepartmentDetail;
import com.skill2skill.taskmanagement.dto.response.DepartmentDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.service.abstraction.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.skill2skill.taskmanagement.utils.EndPoints.*;

@RestController
@RequestMapping(value = DEPARTMENT)
public class DepartmentController {

    private final DepartmentService departmentService;


    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping(value = ADD_UPDATE_DEPARTMENT_DETAILS)
    public GenericResponse addUpdateCompany(@Valid @RequestBody AddUpdateDepartmentDetailsRequest request, Company match) {
        return departmentService.addUpdateDepartmentDetails(request);
    }

    @GetMapping(value = DEPARTMENT_LIST)
    public DepartmentDetailsListResponse DepartmentList() {
        return departmentService.DepartmentList();
    }

    @DeleteMapping(value = DELETE_DEPARTMENT)

    public GenericResponse deleteDepartmentById(@PathVariable Integer departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }
    @GetMapping(value =DEPARTMENT_SEARCH_BY_DEPARTMENT_NAME)
    public ResponseEntity<List<DepartmentDetail>> searchByDepartmentName(@RequestParam("departmentName") String departmentName) {
        List<DepartmentDetail> results = departmentService.searchByDepartmentName(departmentName);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
