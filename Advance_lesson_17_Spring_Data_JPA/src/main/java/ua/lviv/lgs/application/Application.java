package ua.lviv.lgs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService service = ctx.getBean(UniversityService.class);
		
		University university = new University();
		university.setLevelOfAccredetation(5);
		university.setQuantityOfInstitute(11);
		university.setQuantityOfStudent(10589);
		university.setAddressOfUniversity("Kiev");
		
		University university2 = new University();
		university2.setLevelOfAccredetation(3);
		university2.setQuantityOfInstitute(8);
		university2.setQuantityOfStudent(5896);
		university2.setAddressOfUniversity("Odessa");
		
		University university3 = new University();
		university3.setLevelOfAccredetation(4);
		university3.setQuantityOfInstitute(10);
		university3.setQuantityOfStudent(9999);
		university3.setAddressOfUniversity("Poltava");
		
		//save university to DB
		service.save(university);
		service.save(university2);
		service.save(university3);
		
		//read from DB
		System.out.println("--> Find by Id <--");
		System.out.println(service.findById((long)2));
		
		System.out.println("--> Find by level of Accredetation <--");
		System.out.println(service.findByLevelOfAccredetation(4));
		
		System.out.println("--> Find by Address <--");
		System.out.println(service.findByAddressOfUniversity("Kiev"));
		
		//update from DB
		University universityForUpdate = service.findById((long)1);
		universityForUpdate.setAddressOfUniversity("Lviv");
		service.update(universityForUpdate);
		
		//read all
		System.out.println("--> Print all after update <--");
		service.findAll().stream().forEach(System.out::println);
		
		//delete from DB
		service.deleteById((long)(1));
		
		System.out.println("--> Print all after delete <--");
		service.findAll().stream().forEach(System.out::println);
		
	}

}
