package com.skill2skill.taskmanagement.repository;

import com.skill2skill.taskmanagement.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByEmail(String email);
    Admin findByToken(String token);
}
