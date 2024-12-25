package com.gestion.patient.service;

import com.gestion.patient.dto.ContactDto;
import com.gestion.patient.dto.PatientDto;

public interface ContactService {
    PatientDto addContact(String patientId, ContactDto contactDto);
    PatientDto updateContact(String patientId, int contactIndex, ContactDto updatedContactDto);
    PatientDto deleteContact(String patientId, int contactIndex);
}
