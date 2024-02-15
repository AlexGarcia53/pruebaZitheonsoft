package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.Level;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Level level;
}
