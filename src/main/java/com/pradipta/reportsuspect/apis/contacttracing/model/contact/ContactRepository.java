package com.pradipta.reportsuspect.apis.contacttracing.model.contact;

import com.pradipta.reportsuspect.apis.contacttracing.model.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
