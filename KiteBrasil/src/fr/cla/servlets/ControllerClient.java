package fr.cla.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cla.pojo.Client;
import fr.cla.service.ClientForm;

public class ControllerClient extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID     = -3041583061110221802L;

    final String              VUE_ERROR            = "/WEB-INF/client.jsp";
    final String              VUE                  = "/WEB-INF/recapClient.jsp";
    final String              ATT_BEAN_CLIENT      = "client";
    final String              ATT_LIST_CLIENTS     = "clients";
    final String              ATT_BEAN_FORM_CLIENT = "formClient";

    Map<String, String>       errors               = new HashMap<String, String>();
    String                    resultat;

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        ClientForm form = new ClientForm();

        Client client = form.clientSaving( request );

        HttpSession session = request.getSession();

        List<Client> clients = (List<Client>) session.getAttribute( ATT_LIST_CLIENTS );

        if ( form.getErrors().isEmpty() ) {
            clients.add( client );
            this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
        } else {
            session.setAttribute( ATT_LIST_CLIENTS, clients );
            request.setAttribute( ATT_BEAN_CLIENT, client );
            request.setAttribute( ATT_BEAN_FORM_CLIENT, form );
            this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
        }

    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );

    }
}
