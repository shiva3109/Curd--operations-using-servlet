package com.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddOperation extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("value1"));
		int b = Integer.parseInt(req.getParameter("value2"));
		
		System.out.println(a+"+"+b+"="+(a+b));
		
	}

}
