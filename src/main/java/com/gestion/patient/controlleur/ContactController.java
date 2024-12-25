package com.gestion.patient.controlleur;

import com.gestion.patient.dto.ContactDto;
import com.gestion.patient.dto.PatientDto;
import com.gestion.patient.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Ajouter un contact pour un patient
    @PostMapping("/{patientId}")
    public ResponseEntity<PatientDto> addContact(@PathVariable String patientId, @RequestBody ContactDto contactDto) {
        PatientDto updatedPatient = contactService.addContact(patientId, contactDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedPatient);
    }

    // Mettre à jour un contact pour un patient
    @PutMapping("/{patientId}/{contactIndex}")
    public ResponseEntity<PatientDto> updateContact(
            @PathVariable String patientId,
            @PathVariable int contactIndex,
            @RequestBody ContactDto updatedContactDto) {
        PatientDto updatedPatient = contactService.updateContact(patientId, contactIndex, updatedContactDto);
        return ResponseEntity.ok(updatedPatient);
    }

    // Supprimer un contact d'un patient
    @DeleteMapping("/{patientId}/{contactIndex}")
    public ResponseEntity<PatientDto> deleteContact(
            @PathVariable String patientId,
            @PathVariable int contactIndex) {
        PatientDto updatedPatient = contactService.deleteContact(patientId, contactIndex);
        return ResponseEntity.ok(updatedPatient);
    }
}
