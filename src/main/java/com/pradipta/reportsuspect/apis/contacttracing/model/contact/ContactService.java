package com.pradipta.reportsuspect.apis.contacttracing.model.contact;

import com.pradipta.reportsuspect.apis.contacttracing.model.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

}
