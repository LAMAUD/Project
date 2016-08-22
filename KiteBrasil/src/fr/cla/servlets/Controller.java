package fr.cla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cla.pojo.Client;

public class Controller extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID = -1171987108159245510L;

    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        final String ATT_BEAN_CLIENT = "client";
        final String VUE = "/WEB-INF/index.jsp";

        // Declaration du bean
        Client client = new Client();
        client.setNom( "LAMAUD" );
        client.setPrenom( "Cédric" );

        // Envoie des attributs à la page JSP
        request.setAttribute( ATT_BEAN_CLIENT, client );

        // getServletContext ==> Fait référence au contexte commun à toute
        // l'application (Retourne Objet ServletContext)
        // getRequestDispatcher ==> retourne un objet RequestDispatcher qui agit
        // ici comme une enveloppe autour de notre JSP
        this.getServletContext().getRequestDispatcher( VUE )
                .forward( request, response );

    }

}
