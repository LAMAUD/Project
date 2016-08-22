
<fieldset>
	<legend>Informations commande</legend>

	<label for="dateCommande">Date <span class="requis">*</span></label> 
	<input	type="text" id="dateCommande" name="dateCommande" value="<c:out value="${order.commandDate}"/>" size="20" maxlength="20" disabled />
	<span class="error">${formOrder.errors.dateCommande}</span>
	<br /> 
		 
	<label for="montantCommande">Montant <span class="requis">*</span></label> 
	<input type="text" id="montantCommande" name="montantCommande" value="<c:out value="${order.montant}"/>" size="20" maxlength="20" />
	<span class="error">${formOrder.errors.montant}</span>
	<br />
	
	<label	for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label> 
	<input type="text" id="modePaiementCommande" name="modePaiementCommande" value="<c:out value="${order.modePaiement}"/>" size="20" maxlength="20" />
	<span class="error">${formOrder.errors.modePaiement}</span> 
	<br />

	<label for="statutPaiementCommande">Statut du paiement</label> 
	<input	type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="<c:out value="${order.statutPaiement}"/>" size="20" maxlength="20" /> 
	<br /> 
	
	<label	for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label> 
	<input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="<c:out value="${order.modeLivraison}"/>" size="20" maxlength="20" /> 
	<span class="error">${formOrder.errors.modeLivraison}</span>
	<br />

	<label for="statutLivraisonCommande">Statut de la livraison</label> 
	<input	type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="<c:out value="${order.statutLivraison}"/>" size="20" maxlength="20" />
	<br />
</fieldset>