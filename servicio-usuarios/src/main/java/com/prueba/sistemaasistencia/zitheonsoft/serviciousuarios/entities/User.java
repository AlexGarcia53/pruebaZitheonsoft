package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import java.time.LocalDate;
import java.util.List;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.CIVIL_STATUS;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.GENDER;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String nacionality;
    private GENDER gender;
    
    @Column(name="civil_status")
    private CIVIL_STATUS civilStatus;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "languages_users", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="language_id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"language_id"}))
    private List<Language> languages;
}
