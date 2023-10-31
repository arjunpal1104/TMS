//package com.skill2skill.taskmanagement.dao;
//
//
//import com.skill2skill.taskmanagement.model.User;
//import com.skill2skill.taskmanagement.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//@Primary
//@Component
//public class UserDao implements UserRepository {
//
//     @Autowired
//     private  final UserRepository userRepository;
//
//    public UserDao(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void flush() {
//        userRepository.flush();
//    }
//
//    @Override
//    public <S extends User> S saveAndFlush(S entity) {
//        return userRepository.saveAndFlush(entity);
//    }
//
//    @Override
//    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return userRepository.saveAllAndFlush(entities);
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<User> entities) {
//        userRepository.deleteAllInBatch(entities);
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
//        userRepository.deleteAllByIdInBatch(integers);
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//        userRepository.deleteAllInBatch();
//    }
//
//    @Override
//    @Deprecated
//    public User getOne(Integer integer) {
//        return userRepository.getOne(integer);
//    }
//
//    @Override
//    @Deprecated
//    public User getById(Integer integer) {
//        return userRepository.getById(integer);
//    }
//
//    @Override
//    public User getReferenceById(Integer integer) {
//        return userRepository.getReferenceById(integer);
//    }
//
//    @Override
//    public <S extends User> Optional<S> findOne(Example<S> example) {
//        return userRepository.findOne(example);
//    }
//
//    @Override
//    public <S extends User> List<S> findAll(Example<S> example) {
//        return userRepository.findAll(example);
//    }
//
//    @Override
//    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
//        return userRepository.findAll(example, sort);
//    }
//
//    @Override
//    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return userRepository.findAll(example,pageable);
//    }
//
////    @Override
////    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
////        return UserRepository.findAll(example, pageable);
////    }
//
//    @Override
//    public <S extends User> long count(Example<S> example) {
//        return userRepository.count();
//    }
//
//    @Override
//    public <S extends User> boolean exists(Example<S> example) {
//        return userRepository.exists(example);
//    }
//
//    @Override
//    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return userRepository.findBy(example, queryFunction);
//    }
//
//    @Override
//    public <S extends User> S save(S entity) {
//        return userRepository.save(entity);
//    }
//
//
//    @Override
//    public <S extends User> List<S> saveAll(Iterable<S> entities) {
//        return userRepository.saveAll(entities);
//    }
//
//    @Override
//    public Optional<User> findById(Integer integer) {
//        return userRepository.findById(integer);
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return userRepository.existsById(integer);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public List<User> findAllById(Iterable<Integer> integers) {
//        return userRepository.findAllById(integers);
//    }
//
//    @Override
//    public long count() {
//        return userRepository.count();
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//        userRepository.deleteById(integer);
//    }
//
//    @Override
//    public void delete(User entity) {
//        userRepository.delete(entity);
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> integers) {
//        userRepository.deleteAllById(integers);
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends User> entities) {
//        userRepository.deleteAll(entities);
//    }
//
//    @Override
//    public void deleteAll() {
//        userRepository.deleteAll();
//    }
//
//    @Override
//    public List<User> findAll(Sort sort) {
//        return userRepository.findAll(sort);
//    }
//
//    @Override
//    public Page<User> findAll(Pageable pageable) {
//        return userRepository.findAll(pageable);
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
////    @Override
////    public User findByPassword(String password) {
////        return userRepository.findByPassword(password);
////    }
//}
