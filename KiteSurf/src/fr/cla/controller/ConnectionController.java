package fr.cla.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cla.pojo.User;
import fr.cla.service.form.ConnectionForm;

public class ConnectionController extends HttpServlet {

    private final String       VUE                       = "/WEB-INF/inscription.jsp";
    private final String       VUE_ERROR                 = "/connection.jsp";
    private final String       ATT_FORMULAIRE_CONNECTION = "formConnection";
    private final String       ATT_USER                  = "user";
    private final String       ATT_USER_SESSION          = "userSession";
    public static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
    public static final String FORMAT_DATE               = "dd/MM/yyyy HH:mm:ss";
    public static final String ATT_INTERVALLE_CONNEXIONS = "intervalleConnexions";
    public static final String CHAMP_MEMOIRE             = "memoire";
    public static final int    COOKIE_MAX_AGE            = 60 * 60 * 24 * 365;

    /**
     * 
     */
    private static final long  serialVersionUID          = -351964327224457939L;

    public void doGet( HttpServletRequest request, HttpServletResponse
            response ) throws ServletException, IOException {

        String derniereConnexion = getCookieValue( request, COOKIE_DERNIERE_CONNEXION );

        if ( derniereConnexion != null ) {

            Date dateCourante = new Date();
            SimpleDateFormat dateFormater = new SimpleDateFormat( FORMAT_DATE );
            Date derniereConnexionDate = null;
            try {
                derniereConnexionDate = dateFormater.parse( derniereConnexion );
            } catch ( ParseException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            String IntervalleConnexion = null;
            IntervalleConnexion = DiffDate( dateCourante, derniereConnexionDate );
            request.setAttribute( ATT_INTERVALLE_CONNEXIONS, IntervalleConnexion );

        }

        HttpSession session = request.getSession();
        ConnectionForm formConnection = new ConnectionForm();
        User user = new User();
        user = formConnection.connectionService( request );

        request.setAttribute( ATT_FORMULAIRE_CONNECTION, formConnection );
        request.setAttribute( ATT_USER, user );

        if ( formConnection.getErrors().isEmpty() ) {
            session.setAttribute( ATT_USER_SESSION, user );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
        else {
            session.setAttribute( ATT_USER_SESSION, null );
            this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
        }

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ConnectionForm formConnection = new ConnectionForm();

        User user = new User();

        user = formConnection.connectionService( request );

        request.setAttribute( ATT_FORMULAIRE_CONNECTION, formConnection );
        request.setAttribute( ATT_USER, user );

        if ( request.getParameter( CHAMP_MEMOIRE ) != null ) {

            Date dt = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat( FORMAT_DATE );
            String dateDerniereConnexion = formatter.format( dt );
            setCookie( response, COOKIE_DERNIERE_CONNEXION, dateDerniereConnexion, COOKIE_MAX_AGE );

        } else {
            setCookie( response, COOKIE_DERNIERE_CONNEXION, "", 0 );
        }

        if ( formConnection.getErrors().isEmpty() ) {
            session.setAttribute( ATT_USER_SESSION, user );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
        else {
            session.setAttribute( ATT_USER_SESSION, null );
            this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
        }

    }

    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {
        Cookie cookie = new Cookie( nom, valeur );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

    private static String getCookieValue( HttpServletRequest request, String nom ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private String DiffDate( Date dateCourante, Date derniereConnexionDate ) {
        long dateCouranteMS = dateCourante.getTime();
        long dateDerniereConnexionMS = derniereConnexionDate.getTime();
        long periodeMS = dateCouranteMS - dateDerniereConnexionMS;
        double periodeS = Math.floor( periodeMS / 1000 );
        int periodeMN = (int) Math.floor( periodeS / 60 );
        int periodeSec = (int) ( periodeS % 60 );
        int periodeH = (int) Math.floor( periodeMN / 60 );
        int periodeMin = (int) ( periodeMN % 60 );
        int periodeJ = (int) Math.floor( periodeH / 24 );
        int periodeHeu = (int) ( periodeH % 24 );

        String intervalConnexion = periodeJ + "j" + " " + periodeHeu + "h" + periodeMin + "mn" + periodeSec + "s";

        return intervalConnexion;
    }
}
