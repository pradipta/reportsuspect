package com.pradipta.reportsuspect.apis.contacttracing.controller;

import com.pradipta.reportsuspect.apis.contacttracing.dto.PatientDto;
import com.pradipta.reportsuspect.apis.contacttracing.model.patient.Patient;
import com.pradipta.reportsuspect.apis.contacttracing.model.patient.PatientHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ContactTracingController {
    @Autowired
    private PatientHandler patientHandler;

    @CrossOrigin
    @GetMapping("/contacttracing/form")
    public ModelAndView showPatientForm(Authentication authentication) {
        PatientDto patientDto = new PatientDto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientDto", patientDto);
        modelAndView.setViewName("patient");
        return modelAndView;
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody PatientDto patientDto) {
        System.out.println("Pasgdjkasd");
        return patientHandler.savePatientFromPatientDto(patientDto);
    }
}