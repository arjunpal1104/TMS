package com.skill2skill.taskmanagement.controller;

import com.skill2skill.taskmanagement.dto.request.AddUpdateCompanyDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.CompanyDetail;
import com.skill2skill.taskmanagement.dto.response.CompanyDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.service.abstraction.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.skill2skill.taskmanagement.utils.EndPoints.*;

@RestController
@RequestMapping(value = COMPANY)
@CrossOrigin("*")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @CrossOrigin(origins = "http://localhost:5501")
    @PostMapping(value = ADD_UPDATE_COMPANY_DETAILS)
    public GenericResponse addUpdateCompany(@Valid @RequestBody AddUpdateCompanyDetailsRequest request) {
        return companyService.addUpdateCompanyDetails(request);
    }

    @GetMapping(value = COMPANY_LIST)
    public CompanyDetailsListResponse companyList() {
        return companyService.companyList();
    }

    @GetMapping(value = COMPANY_SEARCH_BY_LOCATION)
    public ResponseEntity<List<CompanyDetail>> searchByLocation(@RequestParam("location") String location) {
        List<CompanyDetail> results = companyService.searchByLocation(location);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
