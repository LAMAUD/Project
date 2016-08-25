package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -9138014784392905753L;

    private final String      VUE              = "/WEB-INF/connection.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse
            response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request,
                response );

    }
}
