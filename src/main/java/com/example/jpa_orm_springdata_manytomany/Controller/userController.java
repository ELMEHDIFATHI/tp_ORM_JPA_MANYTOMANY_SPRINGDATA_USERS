package com.example.jpa_orm_springdata_manytomany.Controller;

import com.example.jpa_orm_springdata_manytomany.Models.User;
import com.example.jpa_orm_springdata_manytomany.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private UserServiceImpl  userServiceI;

    @GetMapping("/users/{username}")
    public User user(@PathVariable  String username){
        User user=userServiceI.findUserByUserName(username);
        return user;


    }



}
