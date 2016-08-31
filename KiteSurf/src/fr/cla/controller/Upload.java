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

            /* Écriture du fichier sur le disque */
            ecrireFichier( part, nomFichier, chemin );

            request.setAttribute( nomChamp, nomFichier );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    // -----------------------------------------------------------------------------------------------//

    private static String getNomFichier( Part part ) {
        /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'éventuelle présence du paramètre "filename". */
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                /*
                 * Si "filename" est présent, alors renvoi de sa valeur,
                 * c'est-à-dire du nom de fichier.
                 */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        /* Et pour terminer, si rien n'a été trouvé... */
        return null;
    }

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        /* Prépare les flux. */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux. */
            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
                    TAILLE_TAMPON );

            /*
             * Lit le fichier reçu et écrit son contenu dans un fichier sur le
             * disque. Il écrit son contenu tampon apres tampon.
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
