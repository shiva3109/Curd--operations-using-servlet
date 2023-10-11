package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDao;
import com.dto.Employee;
@WebServlet("/save")
public class EmpController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		Long mb = Long.parseLong(req.getParameter("mobile"));
		String pass = req.getParameter("password");
		
//		PrintWriter out = res.getWriter();
//		out.print(id+" "+name+" "+email+" "+mb+" "+pass);
		
		Employee e1 = new Employee();
		e1.setName(name);
		e1.setEmail(email);
		e1.setMobileNo(mb);
		e1.setPassword(pass);
		
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			Employee em = employeeDao.empSave(e1);
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("register.html");
			dispatcher.include(req, res);
		}
	}

}
