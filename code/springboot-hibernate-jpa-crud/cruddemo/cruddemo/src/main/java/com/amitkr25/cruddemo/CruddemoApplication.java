package com.amitkr25.cruddemo;

import ch.qos.logback.core.util.StringUtil;
import com.amitkr25.cruddemo.dao.StudentDAO;
import com.amitkr25.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("studentDAOImpl") StudentDAO studentDAO) {
		return runner -> {
			/*
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
			*/
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Rows Deleted: " + rowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Integer id = 1;
		System.out.println("Deleting student...");
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve the student using id
		Integer id = 1;
		System.out.println("Getting student with id " + id + "...");
		Student student = studentDAO.findById(id);
		System.out.println("Found student: " + student);

		//change first name to "Scooby"
		System.out.println("Updating student...");
		student.setFirstName("Scooby");

		//update
		studentDAO.update(student);

			//display updated student
		System.out.println("Updated Student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of student
		List<Student> allStudents = studentDAO.findByLastName("Ayra");

		//display the students
		for(Student student: allStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> allStudents = studentDAO.finaAll();

		// display the students
		for(Student student: allStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a new student object
		System.out.println("Creating student object...");
		Student student = new Student("John", "Doe", "john.doe@google.com");

		// add it to DB
		System.out.println("Saving student object to database...");
		studentDAO.save(student);
		System.out.println("Displaying the ID of the saved student...\nGenerated ID: "+student.getId());

		// retrieve the created student
		Integer id = student.getId();
		Student fromDb = studentDAO.findById(id);

		// display
		if (fromDb != null) {
			System.out.println("Student Information\nID: "+fromDb.getId()+"\nName: "+fromDb.getFirstName()+" "+fromDb.getLastName());
		}
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
