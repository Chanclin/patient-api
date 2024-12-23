package com.gestion.patient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gestion.patient.dto.PatientDto;
import com.gestion.patient.models.Patient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity(PatientDto dto);

    PatientDto toDto(Patient entity);

    List<PatientDto> toDtoList(List<Patient> entities);

    List<Patient> toEntityList(List<PatientDto> dtos);
}

