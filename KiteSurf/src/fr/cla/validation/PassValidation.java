package fr.cla.validation;

public class PassValidation {

    public static void inscription( String pass, String pass_conf ) throws Exception {

        if ( pass != null && pass.length() != 0 ) {
            if ( pass.length() > 7 ) {

                if ( !pass.equals( pass_conf ) ) {
                    throw new Exception( "Les mots de passes sont différents" );
                }

            } else {
                throw new Exception( "Le mot de passe doit contenir au moins 8 caractères" );
            }
        } else {
            throw new Exception( "Veuillez saisir un mot de passe" );
        }
    }

}
