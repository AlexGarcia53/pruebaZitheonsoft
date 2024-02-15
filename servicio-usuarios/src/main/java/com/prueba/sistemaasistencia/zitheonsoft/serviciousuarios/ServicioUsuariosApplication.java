package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.*;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.*;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class ServicioUsuariosApplication implements CommandLineRunner{

	@Autowired
	private IUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServicioUsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//deleteTestUser();
		//loadTestUser();
	}

	public void deleteTestUser(){
		Optional<User> user = userRepository.findById(1L);
		userRepository.delete(user.get());
	}

	private void loadTestUser() {
		User user = new User();
		LocalDate birthDate = LocalDate.now();
		user.setName("Pablo");
		user.setLastname("Pacheco");
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
		laborData.setActivities("Desarrollar software");
		laborData.setCurrency("Bitcoin");
		laborData.setBankAccount("1234567890");
		laborData.setJobProfile("Ingeniero en software");
		laborData.setSalaryRange("1000-2000");

		// Contact data
		ContactData contactData = new ContactData();
		contactData.setCompanyEmail("zitheonsoft@gmail.com");
		contactData.setPersonalEmail("pablopacheco13@gmail.com");
		contactData.setPersonalPhone("04121234567");
		contactData.setCompanyPhone("02611234567");

		// Emergency contacts
		EmergencyContact mother = new EmergencyContact();
		mother.setName("Pablo pacheco's mother");
		EmergencyContact father = new EmergencyContact();
		father.setName("Pablo pacheco's father");
		EmergencyContact brother = new EmergencyContact();
		brother.setName("Pablo pacheco's brother");
		Set<EmergencyContact> emergencyContacts = new HashSet<>();
		emergencyContacts.add(mother);
		emergencyContacts.add(father);
		emergencyContacts.add(brother);

		// Academic degrees
		AcademicDegree academicDegree = new AcademicDegree();
		academicDegree.setInstitution("Universidad de la gaita");
		academicDegree.setName("Ingenieria en software");
		academicDegree.setStartDate(LocalDate.of(2010, 1, 1));
		academicDegree.setEndDate(LocalDate.of(2014, 1, 1));
		Set<AcademicDegree> academicDegrees = new HashSet<>();
		academicDegrees.add(academicDegree);

		// Languages
		Language chino = new Language();
		chino.setName("Chino mandarín");
		chino.setLevel(Level.ADVANCED);
		Language ingles = new Language();
		ingles.setName("Inglés");
		ingles.setLevel(Level.BEGINNER);
		Set<Language> languages = new HashSet<>();
		languages.add(chino);
		languages.add(ingles);

		// Courses
		Course course = new Course();
		course.setName("React de 0 a experto");
		course.setLength("1 año");
		course.setPlatform("Youtube");
		course.setStatus(CourseStatus.FINISHED);
		Course course2 = new Course();
		course2.setName("SpringBoot");
		course2.setStatus(CourseStatus.IN_PROGRESS);
		course2.setLength("3 meses");
		course2.setPlatform("Udemy");
		Set<Course> courses = new HashSet<>();
		courses.add(course);
		courses.add(course2);

		// Persisting user
		user.setAddress(address);
		user.setContactData(contactData);
		user.setLaborData(laborData);
		user.setEmergencyContacts(emergencyContacts);
		user.setAcademicDegrees(academicDegrees);
		user.setLanguages(languages);
		user.setCourses(courses);
		user.setRole(Role.EMPLOYEE);
		user.setWorkStatus(WorkStatus.IN_PERSON);
		userRepository.save(user);
	}

}
