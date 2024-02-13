package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="contact_data")
public class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="company_email")
    private String companyEmail;
    @Column(name="personal_email")
    private String personalEmail;
    @Column(name="company_phone")
    private String companyPhone;
    @Column(name="personal_phone")
    private String personalPhone;
}
