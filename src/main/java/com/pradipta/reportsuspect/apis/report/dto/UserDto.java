package com.pradipta.reportsuspect.apis.report.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstname;
    @NotNull
    @NotEmpty
    private String lastname;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    private String phonenumber;
    @NotNull
    @NotEmpty
    private String password;
}
