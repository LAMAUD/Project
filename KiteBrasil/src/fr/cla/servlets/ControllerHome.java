package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerHome extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -5080418749201123720L;

    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        final String VUE = "/WEB-INF/home.jsp";

        this.getServletContext().getRequestDispatcher( VUE )
                .forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        final String VUE = "/WEB-INF/home.jsp";

        this.getServletContext().getRequestDispatcher( VUE )
                .forward( request, response );
    }

}
