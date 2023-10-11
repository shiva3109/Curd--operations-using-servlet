package com.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/cycle")
public class LifeCycleServlet extends GenericServlet{
	
	public LifeCycleServlet() {
		System.out.println("Constructor");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("initialization phase");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("cycle in servlet phase");
		
	}
	@Override
	public void destroy() {
		System.out.println("destroy phase");
	}

}
