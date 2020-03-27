package com.pradipta.reportsuspect.dto;

import com.pradipta.reportsuspect.constants.Gender;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReportDto {
    private String suspectAddress;
    private String suspectName;
    private String suspectPhoneNumber;
    private Gender suspectGender;
    private String suspectLocationLongitude;
    private String suspectLocationLatitude;
    @NotNull
    private String remarks;
    private Boolean isForSelf = false;
}
