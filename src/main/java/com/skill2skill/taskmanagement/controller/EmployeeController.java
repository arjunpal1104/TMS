package com.skill2skill.taskmanagement.controller;

//import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
//import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
import com.skill2skill.taskmanagement.dto.request.EmployeeRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.service.abstraction.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value = "/employee")

public class EmployeeController {

     @Autowired
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(value = "/register")
    public GenericResponse register(@RequestBody EmployeeRegistrationRequest request) {
        return employeeService.register(request);
    }
    @PostMapping(value = "/login")
    public GenericResponse login(@RequestBody EmployeeLoginRequest request){
        return employeeService.login(request);
    }
}
