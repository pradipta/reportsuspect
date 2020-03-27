package com.pradipta.reportsuspect.auth.models.user;

import com.pradipta.reportsuspect.auth.models.role.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class User {
    @Id
    private int id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private String password;
    @ManyToOne
    private Role role;
}
