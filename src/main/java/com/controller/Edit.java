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
@WebServlet("/edit")
public class Edit extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mb = req.getParameter("mobile");
		String pass = req.getParameter("password");
		
		Employee e1 = new Employee();
		e1.seteNo(Integer.parseInt(req.getParameter("id")));
		e1.setName(name);
		e1.setEmail(email);
		e1.setMobileNo(Long.parseLong(mb));
		e1.setPassword(pass);
		
	
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee emp = employeeDao.empUpdate(e1);
//		Employee employee = employeeDao.fetch(id);
		if (emp!=null) {
			List<Employee> list = employeeDao.fetchAll();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("data.jsp");
			dispatcher.forward(req, res);
		}
		else {
			req.setAttribute("employee", emp);
			RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
			dispatcher.include(req, res);
		}
//		try {
//			Employee emp = employeeDao.empUpdate(id,name,email,mb,pass);
//			List<Employee> list = employeeDao.fetchAll();
//			req.setAttribute("list", list);
//			RequestDispatcher dispatcher = req.getRequestDispatcher("data.jsp");
//			dispatcher.forward(req, res);
//		} catch (Exception e) {
//			req.setAttribute("employee", employee);
//			RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
//			dispatcher.forward(req, res);
//		} 
		
	}
	
}
