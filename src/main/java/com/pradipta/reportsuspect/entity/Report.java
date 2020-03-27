package com.pradipta.reportsuspect.entity;

import com.pradipta.reportsuspect.auth.models.user.User;
import com.pradipta.reportsuspect.constants.Gender;
import com.pradipta.reportsuspect.constants.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    @ManyToOne
    private User reporter;
    private String suspectName;
    private String suspectPhoneNumber;
    private Gender suspectGender;
    @NotNull
    private String remarks;
    @OneToOne
    private Location suspectCurrentLocation;
    private Status status;
    private Date createdOn;
    private Date modifiedOn;
}
