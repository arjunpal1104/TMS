package com.skill2skill.taskmanagement.repository;

import com.skill2skill.taskmanagement.model.Department;
import com.skill2skill.taskmanagement.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepository extends JpaRepository<Designation,Integer>{

    Designation findByDesignationIdAndDesignationStatus(Integer designationId,Integer status);

    List<Designation> findAllByDesignationStatus(Integer status);



}
