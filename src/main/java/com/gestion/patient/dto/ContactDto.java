package com.gestion.patient.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestion.patient.models.ContactType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private ContactType type;
    private String valeur;
}
