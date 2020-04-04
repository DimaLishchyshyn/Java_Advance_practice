import ua.lviv.lgs.domain.Employee;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.EmployeeService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.EmployeeServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class MainTest {

	public static void main(String[] args) {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.create(new Employee("test", "test", "test", 50.000));
		
		UserService userService = new UserServiceImpl();
		userService.create(new User("test@test", "test", "test", "test"));

	}

}
