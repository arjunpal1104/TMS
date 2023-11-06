package com.skill2skill.taskmanagement.repository;

import com.skill2skill.taskmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByCompanyIdAndCompanyStatus(Integer companyId, Integer status);


    List<Company> findAllByCompanyStatus(Integer status);

    List<Company>findByCompanyName(String companyName);
    List<Company>findByLocationAndCompanyStatus(String location,Integer status);


}
