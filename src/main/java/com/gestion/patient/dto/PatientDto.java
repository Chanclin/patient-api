package com.gestion.patient.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sexe;
    private double taille;
    private double poids;
    private List<ContactDto> contacts;
}
