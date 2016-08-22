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

public class ControllerCommande extends HttpServlet {

    /**
	 * 
	 */
	final String VUE_ERROR = "/WEB-INF/commande.jsp";
	final String VUE = "/WEB-INF/recapCommand.jsp";
	final String ATT_BEAN_CLIENT = "client";
	final String ATT_BEAN_COMMANDE = "commande";
	final String ATT_BEAN_FORM = "form";
	
    private static final long serialVersionUID = 3185938916594774921L;

    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        

        this.getServletContext().getRequestDispatcher( VUE )
                .forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    	
    	Client client = new Client();
    	ClientForm clientForm = new ClientForm();
    	
    	client = clientForm.clientSaving(request);
        

        this.getServletContext().getRequestDispatcher( VUE_ERROR )
                .forward( request, response );
    }
}
