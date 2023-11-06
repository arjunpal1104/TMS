package com.skill2skill.taskmanagement.dao;

import com.skill2skill.taskmanagement.model.Admin;
import com.skill2skill.taskmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdminDao implements AdminRepository {

    @Autowired
    private final AdminRepository adminRepository;

    public AdminDao(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void flush() {
        adminRepository.flush();
    }

    @Override
    public <S extends Admin> S saveAndFlush(S entity) {
        return adminRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Admin> List<S> saveAllAndFlush(Iterable<S> entities) {
        return adminRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteInBatch(Iterable<Admin> entities) {
        AdminRepository.super.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Admin> entities) {
        adminRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        adminRepository.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        adminRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Admin getOne(Integer integer) {
        return adminRepository.getOne(integer);
    }

    @Override
    @Deprecated
    public Admin getById(Integer integer) {
        return adminRepository.getById(integer);
    }

    @Override
    public Admin getReferenceById(Integer integer) {
        return adminRepository.getReferenceById(integer);
    }

    @Override
    public <S extends Admin> Optional<S> findOne(Example<S> example) {
        return adminRepository.findOne(example);
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example) {
        return adminRepository.findAll(example);
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
        return adminRepository.findAll(example, sort);
    }

    @Override
    public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
        return adminRepository.findAll(example, pageable);
    }

//    @Override
//    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return UserRepository.findAll(example, pageable);
//    }

    @Override
    public <S extends Admin> long count(Example<S> example) {
        return adminRepository.count();
    }

    @Override
    public <S extends Admin> boolean exists(Example<S> example) {
        return adminRepository.exists(example);
    }

    @Override
    public <S extends Admin, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return adminRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends Admin> S save(S entity) {
        return adminRepository.save(entity);
    }


    @Override
    public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
        return adminRepository.saveAll(entities);
    }

    @Override
    public Optional<Admin> findById(Integer integer) {
        return adminRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return adminRepository.existsById(integer);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> findAllById(Iterable<Integer> integers) {
        return adminRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return adminRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        adminRepository.deleteById(integer);
    }

    @Override
    public void delete(Admin entity) {
        adminRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        adminRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {
        adminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }

    @Override
    public List<Admin> findAll(Sort sort) {
        return adminRepository.findAll(sort);
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin findByToken(String token) {
        return adminRepository.findByToken(token);
    }




}
