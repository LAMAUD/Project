package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerDisconnection extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5210125283219460008L;
	private final String RED_DISCONNECTION = "/KiteBrasil/connection.jsp";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		response.sendRedirect(RED_DISCONNECTION);
	}

}
