package fr.cla.service.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cla.pojo.User;
import fr.cla.validation.EmailValidation;
import fr.cla.validation.NomValidation;
import fr.cla.validation.PassValidation;

public class InscriptionForm {

    final String                VUE             = "/index.jsp";
    final String                CHAMP_EMAIL     = "email";
    final String                CHAMP_PASS      = "motdepasse";
    final String                CHAMP_PASS_CONF = "confirmation";
    final String                CHAMP_NOM       = "nom";
    final String                ERROR           = "error";
    final String                RESULTAT        = "resultat";

    private String              resultat;
    private Map<String, String> errors          = new HashMap<String, String>();

    public User subscribeUser( HttpServletRequest request ) {

        String mail = request.getParameter( CHAMP_EMAIL );
        String pass = request.getParameter( CHAMP_PASS );
        String conf_pass = request.getParameter( CHAMP_PASS_CONF );
        String nom = request.getParameter( CHAMP_NOM );

        User user = new User();

        try {
            NomValidation.inscription( nom );
        } catch ( Exception e ) {

            setError( CHAMP_NOM, e );
        }
        user.setNom( nom );

        try {
            EmailValidation.inscription( mail );
        } catch ( Exception e ) {

            setError( CHAMP_EMAIL, e );
        }
        user.setEmail( mail );

        try {
            PassValidation.inscription( pass, conf_pass );
        } catch ( Exception e ) {

            setError( CHAMP_PASS_CONF, e );
        }
        user.setPass( conf_pass );

        if ( errors.isEmpty() ) {
            resultat = "Succès de l'inscription";
        }
        else {
            resultat = "Inscription Faileeeddddddd";
        }

        return user;

    }

    private void setError( String champ, Exception e ) {
        errors.put( champ, e.getMessage() );
    }

    // ------------------ Setter / Getter ---------------------
    public String getResultat() {
        return resultat;
    }

    public void setResultat( String resultat ) {
        this.resultat = resultat;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors( Map<String, String> errors ) {
        this.errors = errors;
    }
}
