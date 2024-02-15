package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.*;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.CivilStatus;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.Gender;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.Role;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.WorkStatus;

import java.time.LocalDate;
import java.util.Set;

public record UserDataDTO(
        Long id,
        String name,
        String lastname,
        String nacionality,
        WorkStatus workStatus,
        Role role,
        Gender gender,
        CivilStatus civilStatus,
        LocalDate birthDate,
        String email,
        Address address,
        ContactData contactData,
        LaborData laborData,
        Set<Language> languages,
        Set<Course> courses,
        Set<AcademicDegree> academicDegrees,
        Set<EmergencyContact> emergencyContacts
) {

}
