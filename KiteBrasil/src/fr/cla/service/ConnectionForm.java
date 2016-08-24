package fr.cla.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cla.pojo.User;
import fr.cla.validation.ConnectionValidation;

public class ConnectionForm {

    private final String        ATT_EMAIL    = "email";
    private final String        ATT_PASSWORD = "password";

    private Map<String, String> errors       = new HashMap<String, String>();
    private String              result;

    public User connectionService( HttpServletRequest request ) {

        String email = request.getParameter( "email" );
        String password = request.getParameter( "motdepasse" );

        User user = new User();

        try {
            ConnectionValidation.email( email );
        } catch ( Exception e ) {

            errors.put( ATT_EMAIL, e.getMessage() );
        }

        try {
            ConnectionValidation.password( password );
        } catch ( Exception e ) {

            errors.put( ATT_PASSWORD, e.getMessage() );
        }

        if ( errors.isEmpty() ) {
            result = "Connexion OK";
        }
        else {
            result = "Connexion Failed";
        }

        user.setEmail( email );
        user.setPassword(password);

        return user;

    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors( Map<String, String> errors ) {
        this.errors = errors;
    }

    public String getResult() {
        return result;
    }

    public void setResult( String result ) {
        this.result = result;
    }

}
