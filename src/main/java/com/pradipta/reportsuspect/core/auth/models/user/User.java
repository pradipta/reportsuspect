package com.pradipta.reportsuspect.core.auth.models.user;

import com.pradipta.reportsuspect.core.auth.models.role.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    @Transient
    private String password;
    @ManyToOne
    private Role role;
}
