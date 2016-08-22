package fr.cla.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cla.pojo.Commande;
import fr.cla.validation.CommandeValidation;

public class CommandForm {
	
	
	public Map<String, String> errors;
	public String resultat;
	
	public Commande commandeSaving (HttpServletRequest request){
		
		Commande commande = new Commande();
		String dateCommande = request.getParameter("dateCommande");
		
		try {
			CommandeValidation.date(dateCommande);
		} catch (Exception e) {
			
			errors.put("date", e.getMessage());
		}
		
		String montantCommande = request.getParameter("montantCommande");
		
		try {
			CommandeValidation.montant(montantCommande);
		} catch (Exception e) {
			errors.put("montant", e.getMessage());
		}
		
		String modePaiementCommande = request.getParameter("modePaiementCommande");
		
		try {
			CommandeValidation.modePaiement(modePaiementCommande);
		} catch (Exception e) {
			errors.put("modePaiement", e.getMessage());
		}
		
		String statutPaiementCommande = request.getParameter("statutPaiementCommande");
		String modeLivraisonCommande = request.getParameter("modeLivraisonCommande");
		
		try {
			CommandeValidation.modeLivraison(modeLivraisonCommande);
		} catch (Exception e) {
			errors.put("modeLivraison",e.getMessage());
		}
		String statutLivraisonCommande = request.getParameter("statutLivraisonCommande");
		
		commande.setCommandDate(dateCommande);
		commande.setModeLivraison(modeLivraisonCommande);
		commande.setModePaiement(modePaiementCommande);
		commande.setMontant(montantCommande);
		commande.setStatutLivraison(statutLivraisonCommande);
		commande.setStatutPaiement(statutPaiementCommande);
		
		return commande;
	}

	
	
}
