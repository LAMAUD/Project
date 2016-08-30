package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListerCommandeController extends HttpServlet {

    private final String LIST_COMMANDE_FILE = "/WEB-INF/ListerCommande.jsp";
    final String         ATT_LIST_COMMANDES = "commandes";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        request.getRequestDispatcher( LIST_COMMANDE_FILE ).forward( request, response );

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        request.getRequestDispatcher( LIST_COMMANDE_FILE ).forward( request, response );

    }

}
