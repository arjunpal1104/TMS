package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.EmployeeDao;
//import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
//import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
import com.skill2skill.taskmanagement.dto.request.EmployeeLoginRequest;
import com.skill2skill.taskmanagement.dto.request.EmployeeRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Employee;
import com.skill2skill.taskmanagement.repository.EmployeeRepository;
import com.skill2skill.taskmanagement.service.abstraction.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Component

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeDao employeeDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public GenericResponse register(EmployeeRegistrationRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPassword(this.passwordEncoder.encode(request.getPassword()));
        employee.setRole(request.getRole());
        employee.setDepartment(request.getDepartment());
        Employee save = employeeDao.save(employee);
        log.info("EmployeeService -> Request : {}", request);
        return GenericResponse.builder()
                .message("Employee id : " + save.getId())
                .messageCode("200")
                .status("Success").build();
    }
    @Override
    public GenericResponse login(EmployeeLoginRequest request){
        Employee employee=employeeDao.findByPassword(request.getPassword());
        if(employee!=null && passwordEncoder.matches(request.getPassword(),employee.getPassword())){
            return GenericResponse.builder()
                    .messageCode("200")
                    .message("sucessfull login" +employee.getId())
                    .status("Success Login").build();
        }
        return null;
    }



//    @Override
//    public Employee findByEmail(String Email) {
//        return null;
//    }


//    @Override
//    public GenericResponse login(EmployeeLoginRequest request) {
//
////        Employee employee = employeeDao.findByUsername(request.getPassword());
//          Employee employee=employeeRepository.findByUsernEmail(request.getEmail());
//        if (employee == null) {
//            return GenericResponse.builder()
//                    .message("user not found")
//                    .message("404")
//                    .build();
//        } else {
//            if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
//                return GenericResponse.builder()
//                        .message("Invalid password")
//                        .message("401")
//                        .build();
//            }
////            String token = jwtTokenProvider.generateToken(employee);
//            log.info("Employee login sucessfully" + employee.getId());
//
//            return GenericResponse.builder()
//                    .message("login sucessfully")
//                    .messageCode("200")
//                    .status("sucess")
//                    .build();
//
//        }
//    }

}
