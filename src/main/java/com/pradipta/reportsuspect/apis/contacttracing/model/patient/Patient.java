package com.pradipta.reportsuspect.apis.contacttracing.model.patient;

import com.pradipta.reportsuspect.apis.contacttracing.model.contact.Contact;
import com.pradipta.reportsuspect.core.constants.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private Gender gender;
    private int age;
    @OneToMany
    private List<Contact> contactedPeople;
}
