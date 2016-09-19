package fr.cla.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cla.pojo.Fichier;
import fr.cla.service.UploadForm;

public class Inscription extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 3973673557908905379L;

    private final String      VAR_CHEMIN       = "chemin";
    private final String      VAR_FICHIER      = "fichier";
    private final String      VUE_VALID        = "/connection";
    private final String      VUE_ERROR        = "/Inscription/inscription.jsp";
    public static final int   TAILLE_TAMPON    = 10240;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String chemin = this.getServletConfig().getInitParameter( VAR_CHEMIN );

        UploadForm uploadForm = new UploadForm();
        Fichier fichier = uploadForm.fillFormFile( request );
        request.setAttribute( VAR_FICHIER, fichier );

        if ( uploadForm.getErrors().isEmpty() ) {
            ecrireFichier( chemin, fichier );
            this.getServletContext().getRequestDispatcher( VUE_VALID ).forward( request, response );
        }
        else {
            this.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request, response );

        }

    }

    public void ecrireFichier( String chemin, Fichier fichier ) {

        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;

        try {
            entree = new BufferedInputStream( fichier.getPart().getInputStream(), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( chemin + fichier.getNom() ), TAILLE_TAMPON );

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );

            }

        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
