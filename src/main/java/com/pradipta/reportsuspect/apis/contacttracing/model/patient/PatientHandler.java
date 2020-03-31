package com.pradipta.reportsuspect.apis.contacttracing.model.patient;

import com.pradipta.reportsuspect.apis.contacttracing.dto.PatientDto;
import com.pradipta.reportsuspect.apis.contacttracing.model.contact.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatientHandler {
    @Autowired
    private PatientService patientService;
    public Patient savePatientFromPatientDto(PatientDto patientDto) {
        Patient patient = findPatientFromPatientDto(patientDto);
        return patientService.addPatient(patient);
    }

    private Patient findPatientFromPatientDto(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setAge(patientDto.getAge());
        patient.setFirstname(patientDto.getFirstname());
        patient.setGender(patientDto.getGender());
        patient.setLastname(patientDto.getLastname());
        patient.setContactedPeople(patientDto.getContacts());
        return patient;
    }

    public Patient updatePatient(Long patientId, List<Contact> newContacts) {
        Optional<Patient> patientOp = patientService.findPatient(patientId);
        if (!patientOp.isPresent()) {
            return null;
        }
        Patient patient = patientOp.get();
        List<Contact> contacts = patientOp.get().getContactedPeople();
        contacts.addAll(newContacts);
        patientOp.get().setContactedPeople(contacts);
        return patientService.merge(patient);
    }
}
