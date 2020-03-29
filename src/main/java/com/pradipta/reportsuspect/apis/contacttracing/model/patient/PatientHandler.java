package com.pradipta.reportsuspect.apis.contacttracing.model.patient;

import com.pradipta.reportsuspect.apis.contacttracing.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientHandler {
    @Autowired
    private PatientService patientService;
    public Patient savePatientFromPatientDto(PatientDto patientDto) {
        Patient patient = findPatientFromPatientDto(patientDto);
        return patientService.addPatient(patient);
    }

    private Patient findPatientFromPatientDto(PatientDto patientDto) {
        //TODO pradipta
        return new Patient();
    }
}
