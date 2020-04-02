package com.pradipta.reportsuspect.apis.report.dto;

import com.pradipta.reportsuspect.core.constants.Gender;
import com.pradipta.reportsuspect.apis.report.model.location.Location;
import lombok.Data;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    //TODO
    private String reasons;
    private String visitedLocation;
}
