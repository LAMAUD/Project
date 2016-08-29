package fr.cla.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionFilter implements Filter {

    private final String ATT_USER_SESSION = "userSession";
    private final String ACCES_PUBLIC     = "/connection";

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException,
            ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
        if ( chemin.startsWith( "/inc" ) ) {
            chain.doFilter( request, response );
            return;
        }

        HttpSession session = request.getSession();

        if ( session.getAttribute( ATT_USER_SESSION ) == null ) {

            request.getRequestDispatcher( ACCES_PUBLIC ).forward( request, response );
            ;
        } else {

            chain.doFilter( request, response );
        }
    }

    @Override
    public void init( FilterConfig config ) throws ServletException {
        // TODO Auto-generated method stub

    }

}
