package fr.cla.validation;

public class EmailValidation {

    public static void inscription( String mail ) throws Exception {

        if ( mail != null && mail.length() != 0 ) {
            if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "L'adresse mail n'est pas valide" );
            }

        } else {
            throw new Exception( "Veuillez saisir une adresse mail" );
        }
    }

}
