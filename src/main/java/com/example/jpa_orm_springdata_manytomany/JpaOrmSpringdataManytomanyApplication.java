package com.example.jpa_orm_springdata_manytomany;

import com.example.jpa_orm_springdata_manytomany.Models.Role;
import com.example.jpa_orm_springdata_manytomany.Models.User;
import com.example.jpa_orm_springdata_manytomany.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaOrmSpringdataManytomanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOrmSpringdataManytomanyApplication.class, args);
    }


    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {

            User u=new User();
            u.setUserName("user1");
            u.setPassword("123456");

            User u2=new User();
            u2.setUserName("user2");
            u2.setPassword("123456");

            userService.addNewUser(u);
            userService.addNewUser(u2);

            Stream.of("Student","User","Admin").forEach(t->{
                Role r=new Role();
                r.setRoleName(t);

                userService.addNewRole(r);
            });

            userService.addRoleToUser("user1","Student");
           userService.addRoleToUser("user2","User");
            userService.addRoleToUser("user1","Admin");

            try{
                User user=userService.authenticate("user1","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Role ==>");
                user.getRoles().forEach(r->{
                    System.out.println("Role =>"+r.toString());
                });

            }catch(Exception E){
                System.out.println("chack main authentification \n"+E.getMessage());
            }

        };
    }



}
