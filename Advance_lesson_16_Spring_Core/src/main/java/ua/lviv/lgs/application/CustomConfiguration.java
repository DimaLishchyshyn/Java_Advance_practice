package ua.lviv.lgs.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.dao.impl.StudentDaoImpl;
import ua.lviv.lgs.domion.Student;

@Configuration
public class CustomConfiguration {
	@Bean(name = "studentDao")
	public StudentDao getStudentDao() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao;
	}
	
	@Bean(name = "student")
	public Student getStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Dima");
		student.setAge(30);

		return student;
	}
}