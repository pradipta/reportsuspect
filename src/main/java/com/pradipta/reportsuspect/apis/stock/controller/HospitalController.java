package com.pradipta.reportsuspect.apis.stock.controller;

import com.pradipta.reportsuspect.apis.stock.dto.HospitalDto;
import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import com.pradipta.reportsuspect.apis.stock.model.hospital.HospitalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalHandler hospitalHandler;
    @CrossOrigin
    @GetMapping("/add")
    public ModelAndView showForm(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hospital");
        return modelAndView;
    }

    @CrossOrigin
    @PostMapping("/addHospital")
    public Hospital addHospital(@RequestBody HospitalDto hospitalDto) {
        return hospitalHandler.saveHospitalByDto(hospitalDto);
    }

    @CrossOrigin
    @GetMapping("/getHospital/{id}")
    public Hospital getHospital(@PathVariable("id") Integer id) {
        return hospitalHandler.getHospitalById(id);
    }
}
