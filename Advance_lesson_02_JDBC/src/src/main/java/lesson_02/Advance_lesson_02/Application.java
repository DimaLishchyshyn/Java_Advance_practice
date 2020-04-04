package lesson_02.Advance_lesson_02;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		EmployeeDao employeeDao = new EmployeeDao(ConnectionUtils.openConnection());
		// READ_ALL виводить на консоль всю базу данних.
		employeeDao.readAll().forEach(System.out::println);
		System.out.println("--------------------------------------");

		List<Employee> listOfEmployee = new ArrayList<>();
		listOfEmployee.add(new Employee("Andey", "Duda"));
		listOfEmployee.add(new Employee("Teen", "Bell"));
		listOfEmployee.add(new Employee("Fauna", "Galii"));
		listOfEmployee.add(new Employee("Iryna", "Matvienko"));
		listOfEmployee.add(new Employee("Vitalii", "Kondrovsky"));
		listOfEmployee.add(new Employee("Roberto", "Macarello"));
		listOfEmployee.add(new Employee("Viktoria", "Brezhneva"));
		listOfEmployee.add(new Employee("Margarita", "Noyceva"));
		listOfEmployee.add(new Employee("Dasis", "Bad"));

		//INSERT обавляе об'єкти в базу. 
		listOfEmployee.forEach(employee -> {
			try {
				employeeDao.insert(employee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		employeeDao.readAll().forEach(System.out::println);
		System.out.println("--------------------------------------");
		
//		// READ_BY_ID виводить на консоль по id номеру.
//		Employee employeeFromBD = employeeDao.read(2);
//		System.out.println(employeeFromBD);
//		
//		//UPDATE_BY_ID запина назви по id.
//		employeeFromBD.setLastname(employeeFromBD.getLastname() + "- Deen");
//		employeeDao.update(employeeFromBD);
//		
//		//DELETE_BY_ID видалення по id.
//		employeeDao.delete(5);
//		
//		employeeDao.readAll().forEach(System.out::println);
//		System.out.println("--------------------------------------");
	}

}
