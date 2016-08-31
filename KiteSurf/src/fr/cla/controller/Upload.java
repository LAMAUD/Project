package fr.cla.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Upload extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID  = 5504250022752062327L;

    private final String      VUE               = "/WEB-INF/upload.jsp";
    private final String      CHAMP_FILE        = "fichier";
    private final String      CHAMP_DESCRIPTION = "description";
    private final String      CHEMIN            = "chemin";
    public static final int   TAILLE_TAMPON     = 10240;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        String description = request.getParameter( CHAMP_DESCRIPTION );
        request.setAttribute( CHAMP_DESCRIPTION, description );

        Part part = request.getPart( CHAMP_FILE );

        String nomFichier = getNomFichier( part );

        if ( nomFichier != null && !nomFichier.isEmpty() ) {
            String nomChamp = part.getName();

            /* �criture du fichier sur le disque */
            ecrireFichier( part, nomFichier, chemin );

            request.setAttribute( nomChamp, nomFichier );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    // -----------------------------------------------------------------------------------------------//

    private static String getNomFichier( Part part ) {
        /* Boucle sur chacun des param�tres de l'en-t�te "content-disposition". */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'�ventuelle pr�sence du param�tre "filename". */
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                /*
                 * Si "filename" est pr�sent, alors renvoi de sa valeur,
                 * c'est-�-dire du nom de fichier.
                 */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        /* Et pour terminer, si rien n'a �t� trouv�... */
        return null;
    }

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        /* Pr�pare les flux. */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux. */
            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
                    TAILLE_TAMPON );

            /*
             * Lit le fichier re�u et �crit son contenu dans un fichier sur le
             * disque. Il �crit son contenu tampon apres tampon.
             */
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }

}
