package com.pradipta.reportsuspect.dto;

import com.pradipta.reportsuspect.constants.Gender;
import com.pradipta.reportsuspect.entity.Location;
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
    @ManyToMany
    private List<Location> visitedLocation;
}
