package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.EmployeeDao;
import ua.lviv.lgs.dao.impl.EmployeeDaoImpl;
import ua.lviv.lgs.domain.Employee;
import ua.lviv.lgs.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {

		try {
			employeeDao = new EmployeeDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Employee create(Employee t) {
		return employeeDao.create(t);
	}

	@Override
	public Employee read(Integer id) {
		return employeeDao.read(id);
	}

	@Override
	public Employee update(Employee t) {
		return employeeDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);

	}

	@Override
	public List<Employee> readAll() {
		return employeeDao.readAll();
	}
}
