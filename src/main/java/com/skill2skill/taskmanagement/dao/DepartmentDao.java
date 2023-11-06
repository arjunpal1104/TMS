package com.skill2skill.taskmanagement.dao;

import com.skill2skill.taskmanagement.dto.response.DepartmentDetail;
import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.model.Department;
import com.skill2skill.taskmanagement.repository.CompanyRepository;
import com.skill2skill.taskmanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Primary
public class DepartmentDao implements DepartmentRepository {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentDao(DepartmentRepository departmentRepository) {
        this.departmentRepository=departmentRepository;
    }

    @Override
    public void flush() {
        departmentRepository.flush();
    }

    @Override
    public <S extends Department> S saveAndFlush(S entity) {
        return departmentRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Department> List<S> saveAllAndFlush(Iterable<S> entities) {
        return departmentRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Department> entities) {
        departmentRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        departmentRepository.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        departmentRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Department getOne(Integer integer) {
        return departmentRepository.getOne(integer);
    }

    @Override
    @Deprecated
    public Department getById(Integer integer) {
        return departmentRepository.getById(integer);
    }

    @Override
    public Department getReferenceById(Integer integer) {
        return departmentRepository.getReferenceById(integer);
    }

    @Override
    public <S extends Department> Optional<S> findOne(Example<S> example) {
        return departmentRepository.findOne(example);
    }

    @Override
    public <S extends Department> List<S> findAll(Example<S> example) {
        return departmentRepository.findAll(example);
    }

    @Override
    public <S extends Department> List<S> findAll(Example<S> example, Sort sort) {
        return departmentRepository.findAll(example, sort);
    }

    @Override
    public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
        return departmentRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Department> long count(Example<S> example) {
        return departmentRepository.count(example);
    }

    @Override
    public <S extends Department> boolean exists(Example<S> example) {
        return departmentRepository.exists(example);
    }

    @Override
    public <S extends Department, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return departmentRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends Department> S save(S entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public <S extends Department> List<S> saveAll(Iterable<S> entities) {
        return departmentRepository.saveAll(entities);
    }

    @Override
    public Optional<Department> findById(Integer integer) {
        return departmentRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return departmentRepository.existsById(integer);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findAllById(Iterable<Integer> integers) {
        return departmentRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return departmentRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        departmentRepository.deleteById(integer);
    }

    @Override
    public void delete(Department entity) {
        departmentRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        departmentRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Department> entities) {
        departmentRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }

    @Override
    public List<Department> findAll(Sort sort) {
        return departmentRepository.findAll(sort);
    }

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department findByDepartmentIdAndDepartmentStatus(Integer departmentId, Integer status) {
        return departmentRepository.findByDepartmentIdAndDepartmentStatus(departmentId, status);
    }

    @Override
    public List<Department> findAllByDepartmentStatus(Integer status) {
        return departmentRepository.findAllByDepartmentStatus(status);
    }

    @Override
    public List<DepartmentDetail> findByDepartmentNameAndDepartmentStatus(String departmentName, Integer status) {
        return departmentRepository.findByDepartmentNameAndDepartmentStatus(departmentName,status);
    }


}
