package fr.cla.validation;

public class ClientValidation {

    public static void nom( String nom ) throws Exception {

        ConstraintOnEmptyField( nom );
    }

    public static void adresseLivraison( String adrLivraison ) throws Exception {

        ConstraintOnEmptyField( adrLivraison );
    }

    public static void telephone( String tel ) throws Exception {

        ConstraintOnEmptyField( tel );
    }

    public static void date( String date ) throws Exception {
    	
        ConstraintOnEmptyField( date );
    }

    public static void montant( String montant ) throws Exception {

        ConstraintOnEmptyField( montant );
    }

    public static void modePaiement( String modePaiement ) throws Exception {

        ConstraintOnEmptyField( modePaiement );
    }

    public static void modeLivraison( String modeLivraison ) throws Exception {

        ConstraintOnEmptyField( modeLivraison );
    }

    private static void ConstraintOnEmptyField( String valeur ) throws Exception {

        if ( valeur.isEmpty() || valeur.length() == 0 || valeur == null ) {
            throw new Exception( "Le champ est obligatoire" );
        }
    }

}
