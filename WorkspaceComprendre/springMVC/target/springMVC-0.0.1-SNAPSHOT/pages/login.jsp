<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<body>
	<h1 id="banner">Login to Security Demo</h1>
	<form action="j_spring_security_check" method="POST">
		<div class="form-group">
			<label>Email</label>
			<input type="text" placeholder="test@example.com" class="form-control" name="j_username">
		</div>
		<div class="form-group">
			<label>Mot de passe</label>
			<input type="password" id="inputPassword" placeholder="Password" name="j_password" class="form-control">
		</div>
		<button type="submit" class="btn btn-info">Connexion</button>
	</form>