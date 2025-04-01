package com.amitkr25.cruddemo;

import com.amitkr25.cruddemo.dao.StudentDAO;
import com.amitkr25.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("studentDAOImpl") StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create 3 student object
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Sneha", "Sneha", "sneha.sneha@google.com");
		Student tempStudent2 = new Student("Priya", "Jha", "priya.jha@google.com");
		Student tempStudent3 = new Student("Baby", "Ayra", "baby.ayra@google.com");

		//save the student object
		System.out.println("Saving student objects to database...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating student object...");
		Student tempStudent = new Student("Amit", "Kumar", "amit.kumar@google.com");

		//save the student object
		System.out.println("Saving student object to database...");
		studentDAO.save(tempStudent);

		//display id of the saved object
		System.out.println("Displaying the ID of the saved student...\nGenerated ID: "+tempStudent.getId());

	}
}
