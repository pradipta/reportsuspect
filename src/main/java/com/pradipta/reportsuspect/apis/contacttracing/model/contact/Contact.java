package com.pradipta.reportsuspect.apis.contacttracing.model.contact;

import com.pradipta.reportsuspect.apis.contacttracing.model.patient.Patient;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String address;
}
