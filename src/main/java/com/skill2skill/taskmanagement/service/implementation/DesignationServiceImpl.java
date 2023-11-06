package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.DepartmentDao;
import com.skill2skill.taskmanagement.dao.DesignationDao;
import com.skill2skill.taskmanagement.dto.request.AddUpdateDesignationDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.DesignationDetails;
import com.skill2skill.taskmanagement.dto.response.DesignationDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;

import com.skill2skill.taskmanagement.model.Department;
import com.skill2skill.taskmanagement.model.Designation;
import com.skill2skill.taskmanagement.service.abstraction.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@Lazy
public class DesignationServiceImpl implements DesignationService {

    private  final DesignationDao designationDao;
    private  final DepartmentDao departmentDao;

    @Autowired
    public DesignationServiceImpl(DesignationDao designationDao, DepartmentDao departmentDao) {
        this.designationDao = designationDao;
        this.departmentDao = departmentDao;
    }

    @Override
    public GenericResponse addUpdateDesignationDetails(AddUpdateDesignationDetailsRequest request) {

     if(Objects.isNull(request))
         return createDesignationDetails(request);
     return updateDesignationDetails(request);

    }

    @Override
    public DesignationDetailsListResponse designationList(){

        List<Designation> designationList = designationDao.findAllByDesignationStatus(1);
        List<DesignationDetails> designationDetails = designationList.stream()
                .map(designation -> DesignationDetails.builder()
                        .designationStatus(designation.getDesignationStatus())
                        .department(designation.getDepartmentName())
                        .companyName(designation.getCompanyName())
                        .designation(designation.getDesignationName())
                        .build())
                .collect(Collectors.toList());
        log.info("designation service->active designation details :{}", designationDetails);
        return DesignationDetailsListResponse.builder().departmentStatus(1)
                .message("success").designationList(designationDetails).build();

    }

    @Override
    public GenericResponse deleteDesignationById(Integer designationId) {
        Designation designation = designationDao.findByDesignationIdAndDesignationStatus(designationId, 1);
        if (designation == null) {
            log.info("DesignationService -> Designation with ID {} not found or already deleted.", designationId);
            return GenericResponse.builder()
                    .status(String.valueOf(0))
                    .message("Designaiton not found or already deleted.")
                    .build();
        }

        designation.setDesignationStatus(0);
        designation.setUpdatedAt(LocalDateTime.now());
        designation.setUpdatedBy(2);
        designation= designationDao.save(designation);

        log.info("DesignationService -> Deleted designation with ID: {}", designationId);

        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("Designation deleted successfully.")
                .messageCode("Des1")
                .build();
    }

    @Override
    public List<String> fetchCompanyName() {

        List<Department>departmentList=departmentDao.findAllByDepartmentStatus(1);
        List<String>companyName=departmentList.stream().map(Department::getCompanyName)
                .distinct()
                .collect(Collectors.toList());
        return  companyName;
    }

    @Override
    public List<String> fetchDepartmentName() {
        List<Department>departmentList=departmentDao.findAllByDepartmentStatus(1);
        List<String>departmentName=departmentList.stream()
                .map(Department::getDepartmentName)
                .distinct().collect(Collectors.toList());
        return departmentName;
    }

    private GenericResponse updateDesignationDetails(AddUpdateDesignationDetailsRequest request) {

        Designation designation=designationDao.findByDesignationIdAndDesignationStatus(request.getDesignationId(),1);
        if (Objects.isNull(designation))
            throw new RuntimeException("designation details not found");
        designation.setUpdatedAt(LocalDateTime.now()).setUpdatedBy(2);
        updateDesignationDetails(designation,request);
        designation = designationDao.save(designation);
        log.info("DesignationService -> Updated designation details : {}",designation);
        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("Updated successfully").messageCode("Des2")
                .build();
    }

    private GenericResponse createDesignationDetails(AddUpdateDesignationDetailsRequest request) {
        log.info("DesignationService -> Add new add_new_designatoin request : {}", request);
        Designation designation = Designation.builder().createdAt(LocalDateTime.now()).createdBy(1).build();
       List<String>companyNames=fetchCompanyName();
       List<String>departmentNames=fetchDepartmentName();
       if(companyNames.equals(request.getCompanyName()) && departmentNames.equals(request.getDepartment())) {
           updateDesignationDetails(designation, request);
           designation = designationDao.save(designation);
           log.info("DesignationService -> Added new designation: {}",designation);
           return GenericResponse.builder()
                   .status(String.valueOf(1))
                   .message("Created new designation with id : " + designation.getDesignationId()).messageCode("Des1")
                   .build();
       }else{
           log.info("DesignationService -> Company with name '{}' not found.", request.getCompanyName());
           log.info("DesignationService -> Department with name '{}' not found.", request.getCompanyName());
           return GenericResponse.builder()
                   .status(String.valueOf(0))
                   .message("Company or Department not found. Please create the company first.")
                   .build();
       }
    }

    private void updateDesignationDetails(Designation designation, AddUpdateDesignationDetailsRequest request) {
        designation.setCompanyName(request.getCompanyName()).setDepartmentName(request.getDepartment())
                .setDesignationName(request.getDesignation())
                .setDesignationStatus(request.getDesignationStatus());

    }

}
