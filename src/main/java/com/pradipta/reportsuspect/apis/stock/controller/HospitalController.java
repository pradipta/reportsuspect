package com.pradipta.reportsuspect.apis.stock.controller;

import com.pradipta.reportsuspect.apis.stock.dto.HospitalDto;
import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import com.pradipta.reportsuspect.apis.stock.model.hospital.HospitalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalHandler hospitalHandler;
    @PostMapping("/addHospital")
    public Hospital addHospital(@RequestBody HospitalDto hospitalDto) {
        return hospitalHandler.saveHospitalByDto(hospitalDto);
    }

    @GetMapping("/getHospital")
    public Hospital getHospital(@PathVariable("id") Integer id) {
        return hospitalHandler.getHospitalById(id);
    }
}
