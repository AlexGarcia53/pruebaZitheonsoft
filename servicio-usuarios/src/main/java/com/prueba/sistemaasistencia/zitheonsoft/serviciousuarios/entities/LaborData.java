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
@Table(name = "labor_data")
public class LaborData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "job_profile")
    private String jobProfile;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "salary_range")
    private String salaryRange;
    private String activities;
    private String NSS;
    private String currency;
}
