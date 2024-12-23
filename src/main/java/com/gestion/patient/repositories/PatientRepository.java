package com.gestion.patient.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gestion.patient.models.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {
}

