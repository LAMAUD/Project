package fr.cla.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cla.pojo.User;
import fr.cla.service.form.ConnectionForm;

public class ConnectionController extends HttpServlet {

    private final String      VUE                       = "/WEB-INF/inscription.jsp";
    private final String      VUE_ERROR                 = "/index2.jsp";
    private final String      ATT_FORMULAIRE_CONNECTION = "formConnection";
    private final String      ATT_USER                  = "user";
    /**
     * 
     */
    private static final long serialVersionUID          = -351964327224457939L;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        ConnectionForm formConnection = new ConnectionForm();

        User user = new User();

        user = formConnection.connectionService( request );

        request.setAttribute( ATT_FORMULAIRE_CONNECTION, formConnection );
        request.setAttribute( ATT_USER, user );

        if ( formConnection.getErrors().isEmpty() ) {

            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
        else {
            this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
        }
    }

}
