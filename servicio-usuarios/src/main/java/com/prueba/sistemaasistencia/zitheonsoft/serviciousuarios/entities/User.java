package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;
import java.time.LocalDate;
import java.util.List;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String nacionality;
    @Enumerated(value = EnumType.STRING)
    @Column(name="work_status")
    private WorkStatus workStatus;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Enumerated(value = EnumType.STRING)
    @Column(name="civil_status")
    private CivilStatus civilStatus;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private ContactData contactData;
    @OneToOne(cascade = CascadeType.ALL)
    private LaborData laborData;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "languages_users", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="language_id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"language_id"}))
    private List<Language> languages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "courses_users", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="course_id"))
    private  List<Course> courses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "degrees_users", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="academic_degree_id"))
    private List<AcademicDegree> academicDegrees;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emergency_contacts_users", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="emergency_contact_id"))
    private List<EmergencyContact> emergencyContacts;
}
