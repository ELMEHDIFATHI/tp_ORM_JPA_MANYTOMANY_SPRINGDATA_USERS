package com.example.jpa_orm_springdata_manytomany.Repository;

import com.example.jpa_orm_springdata_manytomany.Models.Role;
import com.example.jpa_orm_springdata_manytomany.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);
}
