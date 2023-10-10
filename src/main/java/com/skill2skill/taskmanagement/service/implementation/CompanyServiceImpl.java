package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.CompanyDao;
import com.skill2skill.taskmanagement.dto.request.CompanyRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.service.abstraction.CompanyCodeService;
import com.skill2skill.taskmanagement.service.abstraction.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private final CompanyDao companyDao;


    private final CompanyCodeService companyCodeService;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao, CompanyCodeService companyCodeService) {
        this.companyDao = companyDao;
        this.companyCodeService = companyCodeService;
    }

    @Override
    public GenericResponse CompanyRegistration(CompanyRegistrationRequest request) {

        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setCompanyEmail(request.getCompanyEmail());
        company.setCompanyContact(request.getCompanyContact());
        company.setCompanyAddress(request.getCompanyAddress());
        Company save = companyDao.save(company);

        String companyCode = String.valueOf(companyCodeService.CompanyCode(request));
        save.setCompanyCode(companyCode);

        log.info("companyService->Request:{}", request);
        return GenericResponse.builder()
                .message("CompanyId" + save.getId())
                .messageCode("200")
                .status("Sucess")
                .build();
    }


}
