package fr.cla.validation;

public class ConnectionValidation {

    public static void email( String email ) throws Exception {

        if ( email != null && email.length() != 0 ) {

            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Le format d'email n'est pas valide" );
            }
        }
        else {
            throw new Exception( "Le champ est obligatoire" );
        }

    }

    public static void password( String password ) throws Exception {
        if ( password == null || password.isEmpty() || password.length() == 0 ) {
            throw new Exception( "Le champ est obligatoire" );
        }
    }

}
