package com.pradipta.reportsuspect.entity;

import com.pradipta.reportsuspect.constants.Gender;
import com.pradipta.reportsuspect.constants.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Report implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String reporterFirstname;
    private String reporterLastname;
    private String reporterEmail;
    @NotNull
    private String reporterPhonenumber;
    private String reporterCity;
    private String reporterZipcode;
    private String suspectAddess;
    @NotNull
    private String suspectCity;
    @NotNull
    private String suspectZipcode;
    private String suspectName;
    private String suspectPhoneNumber;
    private Gender suspectGender;
    @NotNull
    private String remarks;
    private Status status;
    private Date createdOn;
    private Date modifiedOn;
}
