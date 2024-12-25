package com.gestion.patient.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
@CompoundIndex(name = "unique_patient_index", def = "{'nom': 1, 'prenom': 1}", unique = true)
public class Patient {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sexe; 
    private double taille; 
    private double poids; 
    private List<Contact> contacts = new ArrayList<>();
}
