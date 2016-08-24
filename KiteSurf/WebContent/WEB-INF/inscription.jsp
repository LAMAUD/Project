<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<span class="success"><c:out value="${formConnection.result }"></c:out></span>
	
	<div class = content>
		
		<p>Vous êtes connecté avec l'utilisateur <c:out value="${sessionScope.userSession.email}"></c:out></p>
		
		<form method="post" action="disconnection">
		
			<input type="submit" value="Deconnexion" class="sansLabel" />
			
		</form>
	
	</div>
	
</body>
</html>