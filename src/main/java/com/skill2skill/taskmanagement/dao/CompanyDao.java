package com.skill2skill.taskmanagement.dao;

import com.skill2skill.taskmanagement.model.Company;
import com.skill2skill.taskmanagement.repository.CompanyRepository;
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
public class CompanyDao implements CompanyRepository {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyDao(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void flush() {
        companyRepository.flush();
    }

    @Override
    public <S extends Company> S saveAndFlush(S entity) {
        return companyRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Company> List<S> saveAllAndFlush(Iterable<S> entities) {
        return companyRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Company> entities) {
        companyRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        companyRepository.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        companyRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Company getOne(Integer integer) {
        return companyRepository.getOne(integer);
    }

    @Override
    @Deprecated
    public Company getById(Integer integer) {
        return companyRepository.getById(integer);
    }

    @Override
    public Company getReferenceById(Integer integer) {
        return companyRepository.getReferenceById(integer);
    }

    @Override
    public <S extends Company> Optional<S> findOne(Example<S> example) {
        return companyRepository.findOne(example);
    }

    @Override
    public <S extends Company> List<S> findAll(Example<S> example) {
        return companyRepository.findAll(example);
    }

    @Override
    public <S extends Company> List<S> findAll(Example<S> example, Sort sort) {
        return companyRepository.findAll(example, sort);
    }

    @Override
    public <S extends Company> Page<S> findAll(Example<S> example, Pageable pageable) {
        return companyRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Company> long count(Example<S> example) {
        return companyRepository.count(example);
    }

    @Override
    public <S extends Company> boolean exists(Example<S> example) {
        return companyRepository.exists(example);
    }

    @Override
    public <S extends Company, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return companyRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends Company> S save(S entity) {
        return companyRepository.save(entity);
    }

    @Override
    public <S extends Company> List<S> saveAll(Iterable<S> entities) {
        return companyRepository.saveAll(entities);
    }

    @Override
    public Optional<Company> findById(Integer integer) {
        return companyRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return companyRepository.existsById(integer);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findAllById(Iterable<Integer> integers) {
        return companyRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return companyRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        companyRepository.deleteById(integer);
    }

    @Override
    public void delete(Company entity) {
        companyRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        companyRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Company> entities) {
        companyRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        companyRepository.deleteAll();
    }

    @Override
    public List<Company> findAll(Sort sort) {
        return companyRepository.findAll(sort);
    }

    @Override
    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company findByCompanyIdAndCompanyStatus(Integer companyId, Integer status) {
        return companyRepository.findByCompanyIdAndCompanyStatus(companyId, status);
    }

    @Override
    public List<Company> findAllByCompanyStatus(Integer status) {
        return companyRepository.findAllByCompanyStatus(status);
    }

    @Override
    public List<Company> findByCompanyName(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }

    @Override
    public List<Company> findByLocationAndCompanyStatus(String location, Integer status) {
        return companyRepository.findByLocationAndCompanyStatus(location,status);
    }


}
