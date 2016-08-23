package fr.cla.pojo;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 555778262696715192L;

    private Date              commandDate;
    private String            montant;
    private String            modePaiement;
    private String            statutPaiement;
    private String            modeLivraison;
    private String            statutLivraison;

    private Client            client;

    public Date getCommandDate() {
        return commandDate;
    }

    public void setCommandDate( Date commandDate ) {
        this.commandDate = commandDate;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant( String montant ) {
        this.montant = montant;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement( String modePaiement ) {
        this.modePaiement = modePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement( String statutPaiement ) {
        this.statutPaiement = statutPaiement;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison( String modeLivraison ) {
        this.modeLivraison = modeLivraison;
    }

    public String getStatutLivraison() {
        return statutLivraison;
    }

    public void setStatutLivraison( String statutLivraison ) {
        this.statutLivraison = statutLivraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

}
