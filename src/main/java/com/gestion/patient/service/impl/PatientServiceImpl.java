package com.gestion.patient.service.impl;

import org.springframework.stereotype.Service;

import com.gestion.patient.dto.PatientDto;
import com.gestion.patient.exception.PatientNotFoundException;
import com.gestion.patient.mapper.PatientMapper;
import com.gestion.patient.models.Patient;
import com.gestion.patient.repositories.PatientRepository;
import com.gestion.patient.service.PatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientMapper.toDtoList(patientRepository.findAll());
    }

    @Override
    public Optional<PatientDto> getPatientById(String id) {
        return patientRepository.findById(id)
                .map(patientMapper::toDto);
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        return patientMapper.toDto(patientRepository.save(patient));
    }

    @Override
    public PatientDto updatePatient(String id, PatientDto patientDto) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientMapper.toEntity(patientDto);
            patient.setId(id);
            return patientMapper.toDto(patientRepository.save(patient));
        }
        throw new PatientNotFoundException("Patient avec l'ID " + id + " n'existe pas.");
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
