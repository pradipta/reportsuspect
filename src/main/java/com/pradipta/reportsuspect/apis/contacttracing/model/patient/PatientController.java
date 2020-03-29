package com.pradipta.reportsuspect.apis.contacttracing.model.patient;

import com.pradipta.reportsuspect.apis.contacttracing.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacttracing")
public class PatientController {
    @Autowired
    private PatientHandler patientHandler;

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody PatientDto patientDto) {
        return patientHandler.savePatientFromPatientDto(patientDto);
    }
}
