package com.skill2skill.taskmanagement.controller;

import com.skill2skill.taskmanagement.dto.request.CompanyRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.service.abstraction.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.GeneralPath;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private  final CompanyService companyService;


    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(value = "/register")
    public GenericResponse register(@RequestBody CompanyRegistrationRequest request){

        return companyService.CompanyRegistration(request);

    }   
}
