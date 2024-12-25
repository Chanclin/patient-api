package com.gestion.patient.service.impl;

import com.gestion.patient.dto.ContactDto;
import com.gestion.patient.dto.PatientDto;
import com.gestion.patient.mapper.ContactMapper;
import com.gestion.patient.mapper.PatientMapper;
import com.gestion.patient.models.Patient;
import com.gestion.patient.repositories.PatientRepository;
import com.gestion.patient.service.ContactService;
import com.gestion.patient.exception.PatientNotFoundException;  // Importation de l'exception personnalisée
import com.gestion.patient.exception.InvalidContactIndexException;  // Importation de l'exception personnalisée
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final PatientRepository patientRepository;
    private final ContactMapper contactMapper;
    private final PatientMapper patientMapper;

    public ContactServiceImpl(PatientRepository patientRepository, ContactMapper contactMapper, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.contactMapper = contactMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDto addContact(String patientId, ContactDto contactDto) {
        if (contactDto.getType() == null || contactDto.getValeur() == null) {
            throw new IllegalArgumentException("Le type et la valeur du contact ne peuvent pas être nuls.");
        }

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        // Ajout du contact au patient
        patient.getContacts().add(contactMapper.toEntity(contactDto));

        // Sauvegarde du patient et conversion en PatientDto
        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toDto(updatedPatient);
    }

    @Override
    public PatientDto updateContact(String patientId, int contactIndex, ContactDto updatedContactDto) {
        if (updatedContactDto.getType() == null || updatedContactDto.getValeur() == null) {
            throw new IllegalArgumentException("Le type et la valeur du contact ne peuvent pas être nuls.");
        }

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        if (contactIndex < 0 || contactIndex >= patient.getContacts().size()) {
            throw new InvalidContactIndexException("Invalid contact index");
        }

        // Mise à jour du contact
        patient.getContacts().set(contactIndex, contactMapper.toEntity(updatedContactDto));

        // Sauvegarde du patient et conversion en PatientDto
        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toDto(updatedPatient);
    }


    @Override
    public PatientDto deleteContact(String patientId, int contactIndex) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        if (contactIndex < 0 || contactIndex >= patient.getContacts().size()) {
            throw new InvalidContactIndexException("Invalid contact index");
        }

        // Suppression du contact
        patient.getContacts().remove(contactIndex);

        // Sauvegarde du patient et conversion en PatientDto
        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toDto(updatedPatient);
    }
}
