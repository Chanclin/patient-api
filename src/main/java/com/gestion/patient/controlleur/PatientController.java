package com.gestion.patient.controlleur;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.gestion.patient.dto.PatientDto;
import com.gestion.patient.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @PostMapping
    public PatientDto createPatient(@RequestBody PatientDto patientDto) {
        return patientService.createPatient(patientDto);
    }

    @PutMapping("/{id}")
    public PatientDto updatePatient(@PathVariable String id, @RequestBody PatientDto patientDto) {
        return patientService.updatePatient(id, patientDto);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
    }
}
