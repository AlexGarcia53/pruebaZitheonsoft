package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "emergency_contacts")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String name;
    private String lastname;
    private String relationship;
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
