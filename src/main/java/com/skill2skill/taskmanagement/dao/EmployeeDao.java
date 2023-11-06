package com.skill2skill.taskmanagement.dao;


import com.skill2skill.taskmanagement.model.Employee;
import com.skill2skill.taskmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

@Primary
@Repository
public class EmployeeDao implements EmployeeRepository{
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeDao(@Lazy EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
        return employeeDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteInBatch(Iterable<Employee> entities) {
        EmployeeRepository.super.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Employee> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employee getOne(Integer integer) {
        return employeeDao.getOne(integer);
    }

    @Override
    public Employee getById(Integer integer) {
        return employeeDao.getById(integer);
    }

    @Override
    public Employee getReferenceById(Integer integer) {
        return employeeDao.getReferenceById(integer);
    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return employeeDao.findAll(example);
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return employeeDao.findAll(example,sort);
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return employeeDao.findAll(example,pageable);
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return employeeDao.count(example);
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return employeeDao.exists(example);
    }

    @Override
    public <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return employeeDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Employee> S save(S entity) {
        return employeeDao.save(entity);
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return employeeDao.saveAll(entities);
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return employeeDao.existsById(integer);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public List<Employee> findAllById(Iterable<Integer> integers) {
        return employeeDao.findAllById(integers);
    }

    @Override
    public long count() {
        return employeeDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return employeeDao.findAll(sort);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeDao.findAll(pageable);
    }
}
