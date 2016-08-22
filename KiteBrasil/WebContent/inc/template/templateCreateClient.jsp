<fieldset>
	<legend>Informations client</legend>

	<label for="nomClient">Nom <span class="requis">*</span></label>
	 <input	type="text" id="nomClient" name="nomClient" value="<c:out value="${client.nom}" />" size="20" maxlength="20" />
	 <span class = "error" > <c:out value="${form.errors.nom}"></c:out></span>
	  <br />
	
	<label for="prenomClient">Pr�nom </label> 
	<input	type="text" id="prenomClient" name="prenomClient" value="<c:out value="${client.prenom}" />" size="20" maxlength="20" />
	 <br />
	 
	 <label for="adresseClient">Adresse	de livraison <span class="requis">*</span> </label> 
	 <input type="text" id="adresseClient" name="adresseClient" value="<c:out value="${client.adresse}" />"	size="20" maxlength="20" />
	 <span class = "error" > <c:out value="${form.errors.adr}"></c:out></span>
	 <br />
	 
	 <label for="telephoneClient">Num�ro de t�l�phone <span class="requis">*</span> </label> 
	 <input type="text" id="telephoneClient" name="telephoneClient" value="<c:out value="${client.telNumber}" />" size="20" maxlength="20" /> 
	 <span class = "error" > <c:out value="${form.errors.tel}"></c:out></span>
	 <br /> 
	 
	 <label for="emailClient">Adresse email</label> 
	 <input type="email" id="emailClient" name="emailClient" value="<c:out value="${client.mail}" />" size="20" maxlength="60" /> 
	 
	 <br />
	 
</fieldset>