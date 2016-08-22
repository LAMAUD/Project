<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<title>Recapitulation Commande</title>
</head>
<body>

	<c:import url="/inc/template/templateMenu.jsp" />

	<c:choose>
		<c:when test="${!error}">
			
				Mr
				<c:out value="${commande.getClient().getNom()}" />
				a commandé :
			<ul>
				<li>Date de Commande <c:out
						value=" ${commande.getCommandDate()}" /></li>
				<li>Montant de la commande : <c:out
						value="${commande.getMontant()}" /></li>
				<li>Mode de paiement : <c:out
						value="${commande.getModePaiement()}" /></li>
				<li>Statut Paiement : <c:out
						value="${commande.getStatutPaiement()}" /></li>
				<li>Mode de livraison : <c:out
						value="${commande.getModeLivraison()}" /></li>
				<li>Statut de livraison : <c:out
						value="${commande.getStatutLivraison()}" /></li>
			</ul>


		</c:when>
		<c:otherwise>
			<div class="error">Erreur dans la saisie des données</div>
		</c:otherwise>
	</c:choose>

</body>
</html>