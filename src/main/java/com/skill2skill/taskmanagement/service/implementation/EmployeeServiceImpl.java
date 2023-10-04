package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.EmployeeDao;
import com.skill2skill.taskmanagement.dto.request.EmployeeRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Employee;
import com.skill2skill.taskmanagement.service.abstraction.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public GenericResponse register(EmployeeRegistrationRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setAddress(request.getAddress());
        Employee save = employeeDao.save(employee);
        log.info("EmployeeService -> Request : {}", request);
        return GenericResponse.builder()
                .message("Employee id : " + save.getId())
                .messageCode("200")
                .status("Success").build();
    }
}
