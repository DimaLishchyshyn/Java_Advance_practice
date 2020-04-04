package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.EmployeeDao;
import ua.lviv.lgs.domain.Employee;
import ua.lviv.lgs.utils.ConnectionUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	private static String READ_ALL = "select * from employee";
	private static String CREATE = "insert into employee(first_name, last_name, position, salary) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from employee where id=?";
	private static String UPDATE_BY_ID = "update employee set first_name=?, last_name=?, position=?, salary=? where id=?";
	private static String DELETE_BY_ID = "delete from employee where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public EmployeeDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Employee create(Employee employee) {

		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getPosition());
			preparedStatement.setDouble(4, employee.getSalary());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			employee.setId(rs.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;

	}

	@Override
	public Employee read(Integer id) {
		Employee employee = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer employeeId = result.getInt("id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String position = result.getString("position");
			Double salary = result.getDouble("salary");

			employee = new Employee(employeeId, firstName, lastName, position, salary);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getPosition());
			preparedStatement.setDouble(4, employee.getSalary());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> readAll() {

		List<Employee> employeeRecords = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer employeeId = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String position = result.getString("position");
				Double salary = result.getDouble("salary");
				employeeRecords.add(new Employee(employeeId, firstName, lastName, position, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeRecords;
	}

}
