package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListerClientController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -2558539663332598020L;

    private final String      LIST_CLIENT_FILE = "/WEB-INF/listerClient.jsp";
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        request.getRequestDispatcher( LIST_CLIENT_FILE ).forward( request, response );

    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        request.getRequestDispatcher( LIST_CLIENT_FILE ).forward( request, response );

    }

}
