package ua.lviv.lgs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.domion.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");

		Student student = (Student) ctx.getBean("student");
		studentDao.create(student);

		Student studentFromList = studentDao.readById(0);
		System.out.println(studentFromList);

		studentFromList.setName("Andry");
		studentDao.update(studentFromList);

		studentDao.delete(0);
		System.out.println(studentDao.readAll());
	}
}
