package fr.cla.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cla.pojo.Client;
import fr.cla.validation.ClientValidation;

public class ClientForm {

    final String                ATT_BEAN_CLIENT = "client";
    final String                ATT_ERROR       = "errors";
    final String                ATT_RESULT      = "resultat";

    private Map<String, String> errors          = new HashMap<String, String>();
    private String              resultat;

    @SuppressWarnings( "unused" )
    public Client clientSaving( HttpServletRequest request ) {
        Client client = new Client();

        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String tel = request.getParameter( "telephoneClient" );
        String adresse = request.getParameter( "adresseClient" );
        String mail = request.getParameter( "emailClient" );

        try {
            ClientValidation.nom( nom );
        } catch ( Exception e ) {

            errors.put( "nom", e.getMessage() );
        }
        client.setNom( nom );
        client.setPrenom( prenom );

        try {
            ClientValidation.telephone( tel );
        } catch ( Exception e ) {

            errors.put( "tel", e.getMessage() );
        }
        client.setTelNumber( tel );

        try {
            ClientValidation.adresseLivraison( adresse );
        } catch ( Exception e ) {

            errors.put( "adr", e.getMessage() );
        }
        client.setAdresse( adresse );

        client.setMail( mail );

        if ( errors.isEmpty() ) {

            resultat = "Informations client valides";
        }
        else {
            resultat = "Informations client non valides";
        }

        return client;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors( Map<String, String> errors ) {
        this.errors = errors;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String resultat ) {
        this.resultat = resultat;
    }

}
