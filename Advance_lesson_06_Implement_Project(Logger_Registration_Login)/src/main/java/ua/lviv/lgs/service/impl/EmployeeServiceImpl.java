package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.EmployeeDao;
import ua.lviv.lgs.dao.impl.EmployeeDaoImpl;
import ua.lviv.lgs.domain.Employee;
import ua.lviv.lgs.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private static Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	private static EmployeeService employeeServiceImpl;
	private EmployeeDao employeeDao;

	private EmployeeServiceImpl() {

		try {
			employeeDao = new EmployeeDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			LOGGER.error(e);
		}

	}

	public static EmployeeService getEmployeeService() {

		if (employeeServiceImpl == null) {
			employeeServiceImpl = new EmployeeServiceImpl();
		}
		return employeeServiceImpl;
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
