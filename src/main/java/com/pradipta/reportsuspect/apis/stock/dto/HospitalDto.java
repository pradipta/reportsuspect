package com.pradipta.reportsuspect.apis.stock.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HospitalDto {
    @NotNull
    private String name;
    @NotNull
    private String city;
    @NotNull
    private String state;
}
