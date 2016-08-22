package fr.cla.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cla.pojo.Client;
import fr.cla.service.ClientForm;

public class ControllerClient extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3041583061110221802L;

	final String VUE_ERROR = "/WEB-INF/client.jsp";
	final String VUE = "/WEB-INF/recapClient.jsp";
	final String ATT_BEAN_CLIENT = "client";
	final String ATT_BEAN_FORM_CLIENT = "formClient";

	Map<String, String> errors = new HashMap<String, String>();
	String resultat;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClientForm form = new ClientForm();

		Client client = form.clientSaving(request);

		request.setAttribute(ATT_BEAN_CLIENT, client);
		request.setAttribute(ATT_BEAN_FORM_CLIENT, form);

		if (form.getErrors().isEmpty()) {
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_ERROR).forward(request, response);
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}
}
