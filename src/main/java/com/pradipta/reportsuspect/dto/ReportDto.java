package com.pradipta.reportsuspect.dto;

import com.pradipta.reportsuspect.constants.Gender;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReportDto {
    @NotNull
    private String reporterFirstname;
    private String reporterLastname;
    private String reporterEmail;
    @NotNull
    private String reporterPhonenumber;
    private String reporterCity;
    private String reporterZipcode;
    private String suspectAddress;
    @NotNull
    private String suspectCity;
    @NotNull
    private String suspectZipcode;
    private String suspectName;
    private String suspectPhoneNumber;
    private Gender suspectGender;
    @NotNull
    private String remarks;
    private Boolean isForSelf = false;
}
