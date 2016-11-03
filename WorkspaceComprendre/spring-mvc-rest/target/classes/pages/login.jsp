<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
</head>
<body>
	<h1 id="banner">Login to Security Demo</h1>
	<sec:authorize access="isAnonymous()">
		<form action="j_spring_security_check" method="POST">
			<div>
				<span>coucou : ${principal.username}</span> <label>Nom</label> <input
					type="text" placeholder="test@example.com" class="form-control"
					name="j_username">
			</div>
			<div>
				<label>Mot de passe</label> <input type="password"
					id="inputPassword" placeholder="Password" name="j_password"
					class="form-control">
			</div>
			<button type="submit" class="btn btn-info">Connexion</button>
		</form>
	</sec:authorize>
</body>