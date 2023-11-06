package com.skill2skill.taskmanagement.repository;

import com.skill2skill.taskmanagement.dto.response.DepartmentDetail;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.model.Department;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

    Department findByDepartmentIdAndDepartmentStatus(Integer departmentID, Integer status);

    List<Department> findAllByDepartmentStatus(Integer status);

   List<DepartmentDetail>findByDepartmentNameAndDepartmentStatus(String departmentName, Integer status);


}
