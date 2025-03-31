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
		};
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
