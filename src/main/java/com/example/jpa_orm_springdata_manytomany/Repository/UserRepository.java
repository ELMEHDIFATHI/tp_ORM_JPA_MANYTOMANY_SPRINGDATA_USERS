package com.example.jpa_orm_springdata_manytomany.Repository;

import com.example.jpa_orm_springdata_manytomany.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByUserName(String userName);
}
