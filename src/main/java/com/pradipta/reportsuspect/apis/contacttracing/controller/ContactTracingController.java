package com.pradipta.reportsuspect.apis.contacttracing.controller;

import com.pradipta.reportsuspect.apis.contacttracing.dto.PatientDto;
import com.pradipta.reportsuspect.apis.contacttracing.model.patient.Patient;
import com.pradipta.reportsuspect.apis.contacttracing.model.patient.PatientHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contacttracing")
public class ContactTracingController {
    @Autowired
    private PatientHandler patientHandler;

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody PatientDto patientDto) {
        return patientHandler.savePatientFromPatientDto(patientDto);
    }
}