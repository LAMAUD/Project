package fr.cla.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisconnectionController extends HttpServlet {

    private static String URL_DISCONNECTION = "http://localhost:8080/KiteSurf/connection.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect( URL_DISCONNECTION );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect( URL_DISCONNECTION );
    }
}
