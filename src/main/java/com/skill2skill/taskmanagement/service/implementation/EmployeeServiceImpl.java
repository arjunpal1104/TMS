package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.DesignationDao;
import com.skill2skill.taskmanagement.dao.EmployeeDao;
import com.skill2skill.taskmanagement.model.Designation;
import com.skill2skill.taskmanagement.service.abstraction.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;
    private  final DesignationDao designationDao;


//    @Override
//    public List<String> fetchCompanyName() {
//
//        List<Department>departmentList=departmentDao.findAllByDepartmentStatus(1);
//        List<String>companyName=departmentList.stream().map(Department::getCompanyName)
//                .distinct()
//                .collect(Collectors.toList());
//        return  companyName;
//    }
    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, DesignationDao designationDao) {
        this.employeeDao = employeeDao;
        this.designationDao = designationDao;
    }
    @Override
    public List<String>fetchComapnyName(){
        List<Designation>designationList=designationDao.findAllByDesignationStatus(1);
         List<String >companyName=designationList.stream().map(Designation::getCompanyName).distinct()
                 .collect(Collectors.toList());
         return  companyName;
    }
    @Override
    public List<String>fetchDepartmentName(){
        List<Designation>designationList=designationDao.findAllByDesignationStatus(1);
        List<String>departmentName=designationList.stream().map(Designation::getDepartmentName)
                .distinct().collect(Collectors.toList());
        return departmentName;
    }
//    public List<String>fetchDesignationName(){
//        return  "";
//    }
}
