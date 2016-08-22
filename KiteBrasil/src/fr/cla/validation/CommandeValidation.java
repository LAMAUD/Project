package fr.cla.validation;

public class CommandeValidation {

	public static void date(String date) throws Exception {
		ConstraintOnEmptyField( date );
	}

	public static void montant(String montant) throws Exception {
		ConstraintOnEmptyField( montant );
	}

	public static void modePaiement(String modePaiement) throws Exception {
		ConstraintOnEmptyField( modePaiement );
	}

	public static void statutPaiement(String statutPaiement) throws Exception {

	}

	public static void modeLivraison(String modeLivraison) throws Exception {
		ConstraintOnEmptyField( modeLivraison );
	}

	public static void statutLivraison(String statutLivraison) throws Exception {

	}

	private static void ConstraintOnEmptyField( String valeur ) throws Exception {

        if ( valeur.isEmpty() || valeur.length() == 0 || valeur == null ) {
            throw new Exception( "Le champ est obligatoire" );
        }
    }

}
