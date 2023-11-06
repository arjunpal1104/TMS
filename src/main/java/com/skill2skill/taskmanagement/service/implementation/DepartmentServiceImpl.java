package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.CompanyDao;
import com.skill2skill.taskmanagement.dao.DepartmentDao;

import com.skill2skill.taskmanagement.dto.request.AddUpdateDepartmentDetailsRequest;

import com.skill2skill.taskmanagement.dto.response.DepartmentDetail;
import com.skill2skill.taskmanagement.dto.response.DepartmentDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.model.Department;
import com.skill2skill.taskmanagement.service.abstraction.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentDao departmentdao;
    private  final CompanyDao companyDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentdao, CompanyDao companyDao) {
        this.departmentdao = departmentdao;
        this.companyDao = companyDao;
    }


    @Override
    public GenericResponse addUpdateDepartmentDetails(AddUpdateDepartmentDetailsRequest request) {
        if (Objects.isNull(request.getId()))
            return createDepartmentDetails(request);
        return updateDepartmentDetails(request);
    }

    @Override
    public List<DepartmentDetail> searchByDepartmentName(String departmentName) {
        List<DepartmentDetail> departmentList = departmentdao.findByDepartmentNameAndDepartmentStatus(departmentName,1);
        List<DepartmentDetail> departmentDetails = departmentList.stream()
                .map(department -> DepartmentDetail.builder()
                        .departmentStatus(department.getDepartmentStatus())
                        .departmentName(department.getDepartmentName())
                        .department_id(department.getDepartment_id())
                        .build())
                .collect(Collectors.toList());
        log.info("DepartmentService -> Departments with name '{}': {}", departmentName, departmentDetails);
        return departmentDetails;
    }
    public GenericResponse createDepartmentDetails(AddUpdateDepartmentDetailsRequest request) {
        log.info("create department->");
        List<Company> company =companyDao.findByCompanyName(request.getCompanyName());
        List<String> companyNames = company.stream()
                .map(Company::getCompanyName)
                .collect(Collectors.toList());



        if(!companyNames.isEmpty()) {

            Department department = Department.builder().createdAt(LocalDateTime.now()).createdBy(1).build();
            updateDepartmentDetails(department, request);
            department = departmentdao.save(department);
            log.info("DepartmentService -> Added new department : {}", department);
            return GenericResponse.builder()
                    .status(String.valueOf(1))
                    .message("Created new Company with id : " + department.getDepartmentId()).messageCode("D1")
                    .build();
        }
        else{
            log.info("DepartmentService -> Company with name '{}' not found.", request.getCompanyName());
            return GenericResponse.builder()
                    .status(String.valueOf(0))
                    .message("company not found please before create company")
                    .build();
        }
    }

    private void updateDepartmentDetails(Department department, AddUpdateDepartmentDetailsRequest request) {

        department.setCompanyName(request.getCompanyName()).setDepartmentName(request.getDepartment()).setDepartmentStatus(request.getDepartmentStatus());
        log.info("add process complete->");
    }

    private GenericResponse updateDepartmentDetails(AddUpdateDepartmentDetailsRequest request) {


        Department department = departmentdao.findByDepartmentIdAndDepartmentStatus(request.getId(), 1);
        if (Objects.isNull(department))
            throw new RuntimeException("department details not found");
        department.setUpdatedAt(LocalDateTime.now());
        department.setUpdatedBy(2);
        updateDepartmentDetails(department, request);
        department = departmentdao.save(department);
        log.info("DepartmentService -> Updated department details : {}", department);
        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("Updated successfully").messageCode("D2")
                .build();
    }


    @Override
    public DepartmentDetailsListResponse DepartmentList() {
        List<Department> departmentList = departmentdao.findAllByDepartmentStatus(1);
        List<DepartmentDetail> departmentDetails = departmentList.stream().map(department -> DepartmentDetail.builder().departmentStatus(department.getDepartmentStatus())
                        .departmentName(department.getDepartmentName())
                        .department_id(department.getDepartmentId()).build())
                .collect(Collectors.toList());
        log.info("department service->active department details :{}", departmentDetails);
        return DepartmentDetailsListResponse.builder().departmentStatus(1)
                .message("sucess").departmentList(departmentDetails).build();

    }



    @Override
    public GenericResponse deleteDepartmentById(Integer departmentId) {
        Department department = departmentdao.findByDepartmentIdAndDepartmentStatus(departmentId, 1);
        if (department == null) {
            log.info("DepartmentService -> Department with ID {} not found or already deleted.", departmentId);
            return GenericResponse.builder()
                    .status(String.valueOf(0))
                    .message("Department not found or already deleted.")
                    .build();
        }

        department.setDepartmentStatus(0);
        department.setUpdatedAt(LocalDateTime.now());
        department.setUpdatedBy(2);
        department = departmentdao.save(department);

        log.info("DepartmentService -> Deleted department with ID: {}", departmentId);

        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("Department deleted successfully.")
                .messageCode("D3")
                .build();
    }

}
