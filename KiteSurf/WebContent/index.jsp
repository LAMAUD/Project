<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inc/style.css">
<link>
<title>Kite Surf</title>
</head>
<body>

	<form method="post" action="inscription">
		<fieldset>
			<legend>Inscription</legend>
			<p>Vous pouvez vous inscrire via ce formulaire.</p>

			<label for="email">Adresse email <span class="requis">*</span></label>
			<input type="text" id="email" name="email"
				value="<c:out value=" ${user.email}"/>" size="20" maxlength="60" />
			<div>
				<span class="error">${form.errors['email']}</span>
			</div>
			<br /> <label for="motdepasse">Mot de passe <span
				class="requis">*</span></label> <input type="password" id="motdepasse"
				name="motdepasse" value="" size="20" maxlength="20" /> <br /> <label
				for="confirmation">Confirmation du mot de passe <span
				class="requis">*</span></label> <input type="password" id="confirmation"
				name="confirmation" value="" size="20" maxlength="20" />
			<div>
				<span class="error">${form.errors['confirmation']}</span>
			</div>
			<br /> <label for="nom">Nom d'utilisateur</label> <input type="text"
				id="nom" name="nom" value="<c:out value="${user.nom}"/>" size="20"
				maxlength="20" />
			<div>
				<span class="error">${form.errors['nom']}</span>
			</div>
			<br /> <input type="submit" value="Inscription" class="sansLabel" />
			<br />
			
			<p class="${empty form.errors ? 'succes' : 'error'}">${form.resultat}</p>
		</fieldset>
	</form>
</body>
</html>