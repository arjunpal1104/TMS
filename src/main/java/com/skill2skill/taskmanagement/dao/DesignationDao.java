package com.skill2skill.taskmanagement.dao;

import com.skill2skill.taskmanagement.model.Designation;
import com.skill2skill.taskmanagement.repository.DesignationRepository;
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


@Repository
@Primary
public class DesignationDao implements DesignationRepository {

    private final DesignationDao designationDao;

    @Autowired

    public DesignationDao(@Lazy DesignationDao designationDao) {
        this.designationDao = designationDao;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Designation> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Designation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return designationDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Designation> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Designation getOne(Integer integer) {
        return designationDao.getOne(integer);
    }

    @Override
    public Designation getById(Integer integer) {
        return designationDao.getById(integer);
    }

    @Override
    public Designation getReferenceById(Integer integer) {
        return designationDao.getReferenceById(integer);
    }

    @Override
    public <S extends Designation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Designation> List<S> findAll(Example<S> example) {
        return designationDao.findAll(example);
    }

    @Override
    public <S extends Designation> List<S> findAll(Example<S> example, Sort sort) {
        return designationDao.findAll(example,sort);
    }

    @Override
    public <S extends Designation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return designationDao.findAll(example,pageable);
    }

    @Override
    public <S extends Designation> long count(Example<S> example) {
        return designationDao.count(example);
    }

    @Override
    public <S extends Designation> boolean exists(Example<S> example) {
        return designationDao.exists(example);
    }

    @Override
    public <S extends Designation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return designationDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Designation> S save(S entity) {
        return designationDao.save(entity);
    }

    @Override
    public <S extends Designation> List<S> saveAll(Iterable<S> entities) {
        return designationDao.saveAll(entities);
    }

    @Override
    public Optional<Designation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return designationDao.existsById(integer);
    }

    @Override
    public List<Designation> findAll() {
        return designationDao.findAll();
    }

    @Override
    public List<Designation> findAllById(Iterable<Integer> integers) {
        return designationDao.findAllById(integers);
    }

    @Override
    public long count() {
        return designationDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Designation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Designation> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Designation> findAll(Sort sort) {
        return designationDao.findAll(sort);
    }

    @Override
    public Page<Designation> findAll(Pageable pageable) {
        return designationDao.findAll(pageable);
    }



    @Override
    public Designation findByDesignationIdAndDesignationStatus(Integer designationId, Integer status) {
        return designationDao.findByDesignationIdAndDesignationStatus(designationId,status);
    }

    @Override
    public List<Designation> findAllByDesignationStatus(Integer status) {
        return designationDao.findAllByDesignationStatus(status);
    }
}
