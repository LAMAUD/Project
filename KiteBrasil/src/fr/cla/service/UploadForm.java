package fr.cla.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import fr.cla.pojo.Fichier;

public class UploadForm {

    private final String        VAR_FICHIER         = "fichier";
    private final String        VAR_DESCTIPTION     = "description";
    private final String        CONTENT_DISPOSITION = "content-disposition";
    private final String        ISFILE              = "filename";
    private final String        ERROR_FILE          = "errorFile";

    private Map<String, String> errors              = new HashMap<String, String>();
    private String              resultat;

    public Fichier fillFormFile( HttpServletRequest request ) throws IllegalStateException, IOException,
            ServletException {

        Fichier fichier = new Fichier();

        String description = request.getParameter( VAR_DESCTIPTION );

        Part part = request.getPart( VAR_FICHIER );
        String nomFichier = getNomFichier( part );

        fichier.setDescription( description );
        fichier.setNom( nomFichier );
        fichier.setPart( part );

        try {
            ValidationFile( fichier );
        } catch ( Exception e ) {
            errors.put( ERROR_FILE, e.getMessage() );
        }

        return fichier;
    }

    private String getNomFichier( Part part ) {
        String nomFichier;
        for ( String content : part.getHeader( CONTENT_DISPOSITION ).split( ";" ) ) {

            if ( content.trim().startsWith( ISFILE ) ) {
                nomFichier = content.substring( content.indexOf( "=" ) + 1 ).replace( "\"", "" );
                return nomFichier;
            }

        }
        return null;
    }

    public void ValidationFile( Fichier fichier ) throws Exception {

        if ( fichier.getDescription() != null && fichier.getNom() != null && !fichier.getNom().isEmpty() ) {

        }
        else {
            throw new Exception( "Les renseignements liés au fichier doivent être remplis !" );
        }

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
