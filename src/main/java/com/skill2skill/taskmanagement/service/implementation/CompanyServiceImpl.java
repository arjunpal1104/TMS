package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.CompanyDao;
import com.skill2skill.taskmanagement.dto.request.AddUpdateCompanyDetailsRequest;
import com.skill2skill.taskmanagement.dto.response.CompanyDetail;
import com.skill2skill.taskmanagement.dto.response.CompanyDetailsListResponse;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.service.abstraction.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public GenericResponse addUpdateCompanyDetails(AddUpdateCompanyDetailsRequest request) {
        if (Objects.isNull(request.getCompanyId()))
            return createCompanyDetails(request);
        return updateCompanyDetails(request);
    }

 @Override
    public List<CompanyDetail> searchByLocation(String location) {
        List<Company> companyList = companyDao.findByLocationAndCompanyStatus(location, 1);
        List<CompanyDetail> companyDetails = companyList.stream()
                .map(company -> CompanyDetail.builder()
                        .companyStatus(company.getCompanyStatus())
                        .companyName(company.getCompanyName())
                        .companyId(company.getCompanyId())
                        .location(company.getLocation())
                        .pan(company.getPan())
                        .build())
                .collect(Collectors.toList());
        log.info("CompanyService -> Companies with location '{}': {}", location, companyDetails);
        return companyDetails;
    }
    @Override
    public CompanyDetailsListResponse companyList() {
        List<Company> companyList = companyDao.findAllByCompanyStatus(1);
        List<CompanyDetail> companyDetails = companyList.stream()
                .map(company -> CompanyDetail.builder()
                        .companyStatus(company.getCompanyStatus())
                        .companyName(company.getCompanyName())
                        .companyId(company.getCompanyId())
                        .location(company.getLocation())
                        .pan(company.getPan())
                        .build())
                .collect(Collectors.toList());
        log.info("CompanyService ->Active Company details : {}", companyDetails);
        return CompanyDetailsListResponse.builder()
                .status(1).message("success")
                .companyDetails(companyDetails).build();
    }

    private GenericResponse updateCompanyDetails(AddUpdateCompanyDetailsRequest request) {
        Company company = companyDao.findByCompanyIdAndCompanyStatus(request.getCompanyId(), 1);
        if (Objects.isNull(company))
            throw new RuntimeException("Company details not found");
        company.setUpdatedAt(LocalDateTime.now()).setUpdatedBy(2);
        updateCompanyDetails(company, request);
        company = companyDao.save(company);
        log.info("CompanyService -> Updated company details : {}", company);
        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("Updated successfully").messageCode("C2")
                .build();
    }

    private GenericResponse createCompanyDetails(AddUpdateCompanyDetailsRequest request) {
        System.out.println("hello");
        log.info("CompanyService -> Add new company request : {}", request);
        Company company = Company.builder().createdAt(LocalDateTime.now()).createdBy(1).build();
        updateCompanyDetails(company, request);
        company = companyDao.save(company);
        log.info("CompanyService -> Added new company : {}", company);
        return GenericResponse.builder()
                .status(String.valueOf(1))
                .message("Created new Company with id : " + company.getCompanyId()).messageCode("C1")
                .build();
    }

    private void updateCompanyDetails(Company company, AddUpdateCompanyDetailsRequest request) {
        company.setCompanyName(request.getCompanyName()).setPan(request.getPan())
                .setCompanyStatus(request.getCompanyStatus()).setLocation(request.getLocation());
    }
}
