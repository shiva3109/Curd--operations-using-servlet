package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDao;
import com.dto.Employee;

@WebServlet("/update")
public class Update extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.fetch(id);
		if (employee != null) {
			req.setAttribute("employee", employee);
			RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
			dispatcher.forward(req, res);
		} else {
			List<Employee> list = employeeDao.fetchAll();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("data.jsp");
			dispatcher.include(req, res);
		}

	}

}
