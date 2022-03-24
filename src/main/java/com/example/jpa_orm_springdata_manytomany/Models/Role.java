package com.example.jpa_orm_springdata_manytomany.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 20)
    private String roleName;
    // il va nous dit qui il est null parce que il reflait a une term
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name="Users_Roles",)
    private List<User> users;
}
