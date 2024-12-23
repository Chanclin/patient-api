package com.gestion.patient.service;

import java.util.List;
import java.util.Optional;

import com.gestion.patient.dto.PatientDto;

public interface PatientService {

	List<PatientDto> getAllPatients();
	Optional<PatientDto> getPatientById(String id);
	PatientDto createPatient(PatientDto patientDto);
	PatientDto updatePatient(String id, PatientDto patientDto);
	void deletePatient(String id);
}
