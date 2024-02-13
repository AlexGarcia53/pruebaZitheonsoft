package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.*;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.CivilStatus;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.CourseStatus;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.Gender;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.Level;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ServicioUsuariosApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServicioUsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loadSoplaGaitas();
	}

	private void loadSoplaGaitas() {
		User user = new User();
		LocalDate birthDate = LocalDate.now();
		user.setName("Soplador");
		user.setLastname("De Gaitas");
		user.setBirthDate(birthDate);
		user.setGender(Gender.MALE);
		user.setCivilStatus(CivilStatus.SINGLE);
		user.setNacionality("Venezolano");

		// Address
		Address address = new Address();
		address.setStreet("Calle 13");
		address.setCountry("Venezuela");
		address.setState("Zulia");
		address.setDistrict("Maracaibo");
		address.setMunicipality("Maracaibo");

		// Labor data
		LaborData laborData = new LaborData();
		laborData.setNSS("123456789");
		laborData.setActivities("Soplar gaitas");
		laborData.setCurrency("Bitcoin");
		laborData.setBankAccount("1234567890");
		laborData.setJobProfile("Soplador de gaitas");
		laborData.setSalaryRange("1000-2000");

		// Contact data
		ContactData contactData = new ContactData();
		contactData.setCompanyEmail("zitheonsoft@quierocarro.com");
		contactData.setPersonalEmail("soplagaitas13@quierocarro.com");
		contactData.setPersonalPhone("04121234567");
		contactData.setCompanyPhone("02611234567");

		// Emergency contacts
		EmergencyContact mother = new EmergencyContact();
		mother.setName("Sopla gaita's mother");
		EmergencyContact father = new EmergencyContact();
		father.setName("Sopla gaita's father");
		EmergencyContact brother = new EmergencyContact();
		brother.setName("Sopla gaita's brother");
		List<EmergencyContact> emergencyContacts = List.of(mother, father, brother);

		// Academic degrees
		AcademicDegree academicDegree = new AcademicDegree();
		academicDegree.setInstitution("Universidad de la gaita");
		academicDegree.setName("Licenciatura en gaitas");
		academicDegree.setStartDate(LocalDate.of(2010, 1, 1));
		academicDegree.setEndDate(LocalDate.of(2014, 1, 1));
		List<AcademicDegree> academicDegrees = List.of(academicDegree);

		// Languages
		Language chino = new Language();
		chino.setName("Chino mandarín");
		chino.setLevel(Level.ADVANCED);
		Language ingles = new Language();
		ingles.setName("Inglés");
		ingles.setLevel(Level.BEGINNER);
		List<Language> languages = List.of(chino, ingles);

		// Courses
		Course course = new Course();
		course.setName("Soplar  Gaitas de 0 a experto");
		course.setLength("1 año");
		course.setPlatform("Youtube");
		course.setStatus(CourseStatus.FINISHED);
		Course course2 = new Course();
		course2.setName("SpringBoot");
		course2.setStatus(CourseStatus.IN_PROGRESS);
		course2.setLength("3 meses");
		course2.setPlatform("Udemy");
		List<Course> courses = List.of(course, course2);

		// Persisting user
		user.setAddress(address);
		user.setContactData(contactData);
		user.setLaborData(laborData);
		user.setEmergencyContacts(emergencyContacts);
		user.setAcademicDegrees(academicDegrees);
		user.setLanguages(languages);
		user.setCourses(courses);
		userRepository.save(user);
	}

}
