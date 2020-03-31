package com.pradipta.reportsuspect.apis.stock.controller;

import com.pradipta.reportsuspect.apis.stock.dto.HospitalDto;
import com.pradipta.reportsuspect.apis.stock.model.hospital.Hospital;
import com.pradipta.reportsuspect.apis.stock.model.hospital.HospitalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalHandler hospitalHandler;
    @GetMapping("/add")
    public ModelAndView showForm(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hospital");
        return modelAndView;
    }

    @PostMapping("/addHospital")
    public Hospital addHospital(@RequestBody HospitalDto hospitalDto) {
        return hospitalHandler.saveHospitalByDto(hospitalDto);
    }

    @GetMapping("/getHospital")
    public Hospital getHospital(@PathVariable("id") Integer id) {
        return hospitalHandler.getHospitalById(id);
    }
}
