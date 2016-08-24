package fr.cla.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cla.pojo.User;
import fr.cla.service.form.InscriptionForm;

public class InscriptionController extends HttpServlet {

    final String              VUE              = "/index.jsp";
    final String              ATT_USER         = "user";
    final String              ATT_FORM         = "form";

    /**
     * 
     */
    private static final long serialVersionUID = -4816886930028213513L;

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        InscriptionForm form = new InscriptionForm();

        User user = form.subscribeUser( request );

        request.setAttribute( ATT_USER, user );
        request.setAttribute( ATT_FORM, form );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
