package com.pradipta.reportsuspect.apis.contacttracing.dto;

import com.pradipta.reportsuspect.apis.contacttracing.model.contact.Contact;
import com.pradipta.reportsuspect.core.constants.Gender;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatientDto {
    private String firstname;
    private String lastname;
    private String phonenumber;
    private Gender gender;
    private int age;
}
