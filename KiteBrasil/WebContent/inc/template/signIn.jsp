<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fieldset>
	<legend>Connexion</legend>
	<p>Vous pouvez vous connecter via ce formulaire.</p>

	<label for="nom">Adresse email <span class="requis">*</span></label>
	<input	type="email" id="email" name="email" value="<c:out value="${user.email }"/>" size="20" maxlength="60" />
	<span class="erreur">${formConnection.errors['email']}</span> 
	<br /> 
	
	<label	for="motdepasse">Mot de passe <span class="requis">*</span></label> 
	<input	type="password" id="motdepasse" name="motdepasse" value="${user.pass }" size="20"maxlength="20" /> 
	<span class="erreur">${formConnection.errors['password']}</span>
	<br /> 
	
	<input type="submit" value="Connexion" class="sansLabel" /> 
	<br />

	<p class="error">${formConnection.result}</p>
	<br/>
	<c:out value="${sessionScope.userSession.email}"></c:out>
</fieldset>