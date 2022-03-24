package com.example.jpa_orm_springdata_manytomany.Service;

import com.example.jpa_orm_springdata_manytomany.Models.Role;
import com.example.jpa_orm_springdata_manytomany.Models.User;
import com.example.jpa_orm_springdata_manytomany.Repository.RoleRepository;
import com.example.jpa_orm_springdata_manytomany.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements  UserService{


    private UserRepository userrepo;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userrepo, RoleRepository roleRepository) {
        this.userrepo = userrepo;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userrepo.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userrepo.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user= this.findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if (user.getRoles() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

    }

    @Override
    public User authenticate(String userName, String password) {
      User user = userrepo.findByUserName(userName);

      if(user.getPassword().equals(password)){
            return user;


      }

        throw  new RuntimeException("bad password ");
    }


}
