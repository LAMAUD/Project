package fr.cla.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cla.pojo.Client;

public class SuppressionClient extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID    = -5236754527970404491L;

    final String              ATT_LIST_CLIENTS    = "clients";
    final String              ATT_BEAN_CLIENT_NOM = "nomClient";

    final String              VUE                 = "/listerClientController";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        HttpSession session = request.getSession();
        List<Client> clients = (List<Client>) session.getAttribute( ATT_LIST_CLIENTS );

        String nomClient = request.getParameter( ATT_BEAN_CLIENT_NOM );

        if ( nomClient != null ) {

            for ( int i = 0; i < clients.size(); i++ ) {

                String nomClientList = clients.get( i ).getNom();

                if ( nomClient.equals( nomClientList ) ) {

                    clients.remove( i );
                    break;

                }
            }

        }

        response.sendRedirect( request.getContextPath() + VUE );

    }
}
