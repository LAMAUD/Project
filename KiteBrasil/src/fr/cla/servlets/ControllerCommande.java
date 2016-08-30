package fr.cla.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cla.pojo.Client;
import fr.cla.pojo.Commande;
import fr.cla.service.ClientForm;
import fr.cla.service.CommandForm;

public class ControllerCommande extends HttpServlet {

    /**
	 * 
	 */
    final String              VUE_ERROR            = "/WEB-INF/order.jsp";
    final String              VUE                  = "/WEB-INF/recapOrder.jsp";
    final String              ATT_BEAN_ORDER       = "order";
    final String              ATT_BEAN_CLIENT      = "client";
    final String              ATT_BEAN_FORM_ORDER  = "formOrder";
    final String              ATT_BEAN_FORM_CLIENT = "formClient";
    final String              ATT_LIST_COMMANDES   = "commandes";
    final String              ATT_LIST_CLIENTS     = "clients";
    final String              EMPTY_CLIENT         = "emptyClient";

    private static final long serialVersionUID     = 3185938916594774921L;

    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_ERROR )
                .forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Client client = new Client();
        Commande order = new Commande();
        ClientForm clientForm = new ClientForm();
        CommandForm commandForm = new CommandForm();

        HttpSession session = request.getSession();
        List<Commande> commandes = (List<Commande>) session.getAttribute( ATT_LIST_COMMANDES );
        List<Client> clients = (List<Client>) session.getAttribute( ATT_LIST_CLIENTS );

        order = commandForm.commandeSaving( request );
        // client = clientForm.clientSaving( request );
        String nom = request.getParameter( "clientiz" );

        if ( !clients.isEmpty() && nom != null ) {
            for ( Client client2 : clients ) {
                if ( client2.getNom().equals( nom ) ) {
                    client = client2;
                }

            }
        }

        order.setClient( client );

        if ( commandForm.getErrors().isEmpty() && !clients.isEmpty() && nom != null ) {
            commandes.add( order );
            request.setAttribute( ATT_LIST_COMMANDES, commandes );
            this.getServletContext().getRequestDispatcher( VUE_ERROR )
                    .forward( request, response );
        } else {
            request.setAttribute( ATT_BEAN_ORDER, order );
            request.setAttribute( ATT_BEAN_CLIENT, client );
            request.setAttribute( ATT_BEAN_FORM_CLIENT, clientForm );
            request.setAttribute( ATT_BEAN_FORM_ORDER, commandForm );
            this.getServletContext().getRequestDispatcher( VUE_ERROR )
                    .forward( request, response );

        }
    }
}
