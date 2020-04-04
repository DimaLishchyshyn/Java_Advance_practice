package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Employee;
import ua.lviv.lgs.service.EmployeeService;
import ua.lviv.lgs.service.impl.EmployeeServiceImpl;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();

	// to create resource (employee)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String position = request.getParameter("position");
		String salary = request.getParameter("salary");
		
		if (!firstName.isEmpty() && !lastName.isEmpty() && !position.isEmpty() && !salary.isEmpty()) {
		employeeService.create(new Employee(firstName, lastName, position, salary));
		}
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
//	private double getValidatedSalary(String salary) {
//		if(salary == null || salary.isEmpty()) {
//			return 0;
//		}
//		return Double.parseDouble(salary);
//	}

	// to get resource (employee)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// to update resource (employee)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (employee)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}