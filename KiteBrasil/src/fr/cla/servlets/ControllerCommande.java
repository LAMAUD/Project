package fr.cla.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import fr.cla.pojo.Client;
import fr.cla.pojo.Commande;
import fr.cla.service.ClientForm;
import fr.cla.service.CommandForm;

public class ControllerCommande extends HttpServlet {

    /**
	 * 
	 */
	final String VUE_ERROR = "/WEB-INF/commande.jsp";
	final String VUE = "/WEB-INF/recapCommande.jsp";
	final String ATT_BEAN_COMMANDE = "order";
	final String ATT_BEAN_CLIENT = "client";
	final String ATT_BEAN_FORM_ORDER = "formOrder";
	final String ATT_BEAN_FORM_CLIENT = "formClient";
	
    private static final long serialVersionUID = 3185938916594774921L;

    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        

        this.getServletContext().getRequestDispatcher( VUE )
                .forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    	
    	Client client = new Client();
    	Commande commande = new Commande();
    	ClientForm clientForm = new ClientForm();
    	CommandForm commandForm = new CommandForm();
    	
    	commande = commandForm.commandeSaving(request);
    	client = clientForm.clientSaving(request);
        
    	commande.setClient(client);
    	
    	request.setAttribute(ATT_BEAN_COMMANDE, commande);
    	request.setAttribute(ATT_BEAN_CLIENT, client);
    	request.setAttribute(ATT_BEAN_FORM_CLIENT, clientForm);
    	request.setAttribute(ATT_BEAN_FORM_ORDER, commandForm);
    	
    	if (commandForm.getErrors().isEmpty() && clientForm.getErrors().isEmpty() ) {
    		this.getServletContext().getRequestDispatcher( VUE )
			.forward( request, response );
		}else {
			this.getServletContext().getRequestDispatcher( VUE_ERROR )
			.forward( request, response );
			
		}
    }
}
