package fr.cla.validation;

public class NomValidation {

    public static void inscription( String nom ) throws Exception {

        if ( nom != null && nom.trim().length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }

    }
}
