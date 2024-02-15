package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private ContactData contactData;
    @OneToOne(cascade = CascadeType.ALL)
    private LaborData laborData;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "languages_users", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="language_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"language_id"}))
    private Set<Language> languages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private  Set<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<AcademicDegree> academicDegrees;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "user")
    private Set<EmergencyContact> emergencyContacts;

    public void addCourse(Course course){
        course.setUser(this);
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        course.setUser(null);
        this.courses.remove(course);
    }

    public void addAcademicDegree(AcademicDegree academicDegree){
        academicDegree.setUser(this);
        this.academicDegrees.add(academicDegree);
    }

    public void removeAcademicDegree(AcademicDegree academicDegree){
        academicDegree.setUser(null);
        this.academicDegrees.remove(academicDegree);
    }

    public void addEmergencyContact(EmergencyContact emergencyContact){
        emergencyContact.setUser(this);
        this.emergencyContacts.add(emergencyContact);
    }

    public void removeEmergencyContact(EmergencyContact emergencyContact){
        emergencyContact.setUser(null);
        this.emergencyContacts.remove(emergencyContact);
    }

    public void addLanguage(Language language){
        this.languages.add(language);
    }

    public void removeLanguage(Language language){
        this.languages.remove(language);
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
        for (Course course : courses) {
            course.setUser(this);
        }
    }

    public void setAcademicDegrees(Set<AcademicDegree> academicDegrees) {
        this.academicDegrees = academicDegrees;
        for (AcademicDegree academicDegree : academicDegrees) {
            academicDegree.setUser(this);
        }
    }

    public void setEmergencyContacts(Set<EmergencyContact> newEmergencyContacts) {
        this.emergencyContacts = new HashSet<>();
        this.emergencyContacts.clear();
        // Nuevos contactos de emergencia
        System.out.println("Nuevos contactos de emergencia");
        for (EmergencyContact emergencyContact : newEmergencyContacts) {
            System.out.println(emergencyContact.getName());
        }

        // Antiguos contactos de emergencia
        System.out.println("Antiguos contactos de emergencia");
        for (EmergencyContact emergencyContact : this.emergencyContacts) {
            System.out.println(emergencyContact.getName());
        }

        for(EmergencyContact emergencyContact : newEmergencyContacts){
            emergencyContact.setUser(this);
            this.emergencyContacts.add(emergencyContact);
        }

        for (EmergencyContact emergencyContact : emergencyContacts) {
            emergencyContact.setUser(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
