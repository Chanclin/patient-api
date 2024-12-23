package com.gestion.patient.mapper;



import org.mapstruct.Mapper;

import com.gestion.patient.dto.ContactDto;
import com.gestion.patient.models.Contact;

@Mapper(componentModel = "spring") 
public interface ContactMapper {
	
    ContactDto toDto(Contact contact);
    Contact toEntity(ContactDto contactDto);
}
