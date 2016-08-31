package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 3973673557908905379L;

    private final String      VAR_FICHIER      = "fichier";
    private final String      VUE_VALID        = "/connection";
    private final String      VUE_ERROR        = "/Inscription/inscription.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );

    }
}
