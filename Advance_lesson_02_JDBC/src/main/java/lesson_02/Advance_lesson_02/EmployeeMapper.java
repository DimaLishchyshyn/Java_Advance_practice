package lesson_02.Advance_lesson_02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {
	
	public static Employee map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstname = result.getString("firstname");
		String lastname = result.getString("lastname");
		
		return new Employee(id, firstname, lastname);
	}

}
