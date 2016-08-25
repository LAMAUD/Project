package fr.cla.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Restriction extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 370419757968862418L;

    private final String      ATT_USER_SESSION = "sessionUtilisateur";
    private final String      PRIVATE_ACCESS   = "/KiteBrasil/connection";
    private final String      PUBLIC_ACCESS    = "/connection.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        HttpSession session = request.getSession();

        if ( session.getAttribute( ATT_USER_SESSION ) == null ) {
            request.getServletContext().getRequestDispatcher( PUBLIC_ACCESS ).forward( request, response );
        }
        else {
            response.sendRedirect( PRIVATE_ACCESS );

        }
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        HttpSession session = request.getSession();

        if ( session.getAttribute( ATT_USER_SESSION ) == null ) {
            request.getServletContext().getRequestDispatcher( PUBLIC_ACCESS ).forward( request, response );
        }
        else {
            response.sendRedirect( PRIVATE_ACCESS );

        }
    }
}
