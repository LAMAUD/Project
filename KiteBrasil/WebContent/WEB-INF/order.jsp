<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Création d'une commande</title>

<link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css" media="screen,projection" />
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="inc/JS/materialize.js"></script>
<script type="text/javascript" src="inc/JS/script.js"></script>

</head>
<body>

	<c:import url="/inc/template/templateMenu.jsp" />
	<div>
		<form method="post" action="creationCommande">


			<div class="container">
				<div class="col l12">
					<select id="clientiz" name="clientiz" onclick="removeField()">
						<c:forEach var="client" items="${sessionScope.clients}">
							<option value="${client.nom}">${client.nom}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="container">
				<div class="col l12">
<%-- 					<%@include file="/inc/template/templateCreateClient.jsp" %> --%>
				</div>
				<div class="col l12 ">
					<%@include file="/inc/template/templateInitOrder.jsp" %>
				</div>
			</div>
	

	<input type="submit" value="Valider" />
	<input type="reset" value="Remettre à zéro" />
	<br />
	</form>
	</div>
	

</body>
</html>