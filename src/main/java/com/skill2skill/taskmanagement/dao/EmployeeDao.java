package com.skill2skill.taskmanagement.dao;

import com.skill2skill.taskmanagement.model.Employee;
import com.skill2skill.taskmanagement.repository.CompanyRepository;
import com.skill2skill.taskmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Primary
@Component
public  class EmployeeDao implements EmployeeRepository {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDao(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void flush() {
        employeeRepository.flush();
    }

    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return employeeRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
        return employeeRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Employee> entities) {
        employeeRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        employeeRepository.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        employeeRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Employee getOne(Integer integer) {
        return employeeRepository.getOne(integer);
    }

    @Override
    @Deprecated
    public Employee getById(Integer integer) {
        return employeeRepository.getById(integer);
    }

    @Override
    public Employee getReferenceById(Integer integer) {
        return employeeRepository.getReferenceById(integer);
    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return employeeRepository.findOne(example);
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return employeeRepository.findAll(example);
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return employeeRepository.findAll(example, sort);
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return employeeRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return employeeRepository.count();
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return employeeRepository.exists(example);
    }

    @Override
    public <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return employeeRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends Employee> S save(S entity) {
        return employeeRepository.save(entity);
    }


    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return employeeRepository.saveAll(entities);
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return employeeRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return employeeRepository.existsById(integer);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllById(Iterable<Integer> integers) {
        return employeeRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        employeeRepository.deleteById(integer);
    }

    @Override
    public void delete(Employee entity) {
        employeeRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        employeeRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {
        employeeRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return employeeRepository.findAll(sort);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }


    @Override
    public Employee findByPassword(String password) {
        return employeeRepository.findByPassword(password);
    }
}
