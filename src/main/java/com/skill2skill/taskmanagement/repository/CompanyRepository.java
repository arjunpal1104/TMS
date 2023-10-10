package com.skill2skill.taskmanagement.repository;

import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{


}
