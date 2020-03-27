package com.pradipta.reportsuspect.dto;

import com.pradipta.reportsuspect.constants.Gender;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReportDto {
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
