package com.skill2skill.taskmanagement.service.implementation;

import com.skill2skill.taskmanagement.dao.CompanyDao;
import com.skill2skill.taskmanagement.dto.request.CompanyRegistrationRequest;
import com.skill2skill.taskmanagement.dto.response.GenericResponse;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.service.abstraction.CompanyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyCodeImpl implements CompanyCodeService {

    @Autowired
    private final CompanyDao companyDao;

    @Autowired
    public CompanyCodeImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    int count = 1;

    @Override
    public GenericResponse CompanyCode(CompanyRegistrationRequest request) {
        String companyId = request.getCompanyName().substring(0, 3);

        String companyCode = count++ + companyId;
        Company company = new Company();
        company.setCompanyCode(companyCode);
        companyDao.save(company);

        return GenericResponse.builder()
                .messageCode(companyCode)
                .build();
    }
}
