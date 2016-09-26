package fr.cla.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cla.jdbc.TestJDBC;

public class GestionJDBC extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2224209899480899863L;
	
	private final String ATT_MESSAGES = "messages";
	private final String VUE = "/WEB-INF/testJdbc.jsp";
	

	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		TestJDBC testJDBC = new TestJDBC();
		List<String> messages = testJDBC.executerTests(request);
		
		request.setAttribute(ATT_MESSAGES, messages);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
