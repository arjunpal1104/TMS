//package com.skill2skill.taskmanagement.controller;
//
//import com.skill2skill.taskmanagement.dto.request.UserRegistrationRequest;
//import com.skill2skill.taskmanagement.dto.response.GenericResponse;
//import com.skill2skill.taskmanagement.service.abstraction.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value ="/user/api")
//public class UserController {
//
//    @Autowired
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @PostMapping(value ="/reg")
//    public GenericResponse Register(@RequestBody  UserRegistrationRequest userRegistrationRequest){
//        return  userService.Register(userRegistrationRequest);
//    }
//}
