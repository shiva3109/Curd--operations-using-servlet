package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDao;
import com.dto.Employee;

@WebServlet("/log")
public class LoginController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		EmployeeDao employeeDao = new EmployeeDao();
//		PrintWriter out = res.getWriter();
		try {
			Employee employee = employeeDao.fetch(email);
			if (employee.getPassword().equals(pass)) {
				List<Employee> list = employeeDao.fetchAll();
				req.setAttribute("list", list);
//				req.setAttribute("employee", employee);
//				out.print("Name :" + em.getName() + "\nEmail :" + em.getEmail() + "\nMobileNo :" + em.getMobileNo()
//						+ "\nPassword :" + em.getPassword());
				RequestDispatcher dispatcher = req.getRequestDispatcher("data.jsp");
				dispatcher.forward(req, res);
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
				dispatcher.include(req, res);
			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, res);
		}

	}

}
