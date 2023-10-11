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
@WebServlet("/delete")
public class Delete extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("hii");
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao del = new EmployeeDao();
		Employee emp = del.deleteEmp(id);
		if(emp!=null) {
			List<Employee> list = del.fetchAll();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("data.jsp");
			dispatcher.forward(req, res);
		}
		
	}

}
