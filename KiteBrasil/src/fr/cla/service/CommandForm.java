package fr.cla.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cla.pojo.Commande;
import fr.cla.validation.CommandeValidation;

public class CommandForm {
	
	
	
	public Map<String, String> errors = new HashMap<String, String>();
	public String resultat;
	

	public Commande commandeSaving (HttpServletRequest request){
		
		Commande commande = new Commande();
//		String dateCommande = request.getParameter("dateCommande");
//		
//		try {
//			CommandeValidation.date(dateCommande);
//		} catch (Exception e) {
//			
//			errors.put("date", e.getMessage());
//		}
		
		String montantCommande = request.getParameter("montantCommande");
		String modePaiementCommande = request.getParameter("modePaiementCommande");
		String statutPaiementCommande = request.getParameter("statutPaiementCommande");
		String modeLivraisonCommande = request.getParameter("modeLivraisonCommande");
		String statutLivraisonCommande = request.getParameter("statutLivraisonCommande");
		
		try {
			CommandeValidation.montant(montantCommande);
		} catch (Exception e) {
			errors.put("montant", e.getMessage());
		}
		
		
		try {
			CommandeValidation.modePaiement(modePaiementCommande);
		} catch (Exception e) {
			errors.put("modePaiement", e.getMessage());
		}
		
		
		try {
			CommandeValidation.modeLivraison(modeLivraisonCommande);
		} catch (Exception e) {
			errors.put("modeLivraison",e.getMessage());
		}
		
//		commande.setCommandDate(dateCommande);
		commande.setModeLivraison(modeLivraisonCommande);
		commande.setModePaiement(modePaiementCommande);
		commande.setMontant(montantCommande);
		commande.setStatutLivraison(statutLivraisonCommande);
		commande.setStatutPaiement(statutPaiementCommande);
		
		return commande;
	}

	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public String getResultat() {
		return resultat;
	}
	
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
}
