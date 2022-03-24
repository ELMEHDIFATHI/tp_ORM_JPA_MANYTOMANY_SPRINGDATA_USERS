package com.example.jpa_orm_springdata_manytomany.Service;

import com.example.jpa_orm_springdata_manytomany.Models.Role;
import com.example.jpa_orm_springdata_manytomany.Models.User;

public interface UserService {


    User addNewUser(User user);
    Role addNewRole(Role role);

    User findUserByUserName(String userName);
    Role  findRoleByRoleName(String roleName);

    void addRoleToUser(String userName,String roleName);
    User authenticate(String userName,String password);
}
