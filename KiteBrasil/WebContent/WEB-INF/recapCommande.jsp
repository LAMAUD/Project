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

	
			
				Mr
				<c:out value="${order.getClient().getNom()}" />
				a commandé :
			<ul>
				<li>Date de Commande <c:out
						value=" ${order.getCommandDate()}" /></li>
				<li>Montant de la commande : <c:out
						value="${order.getMontant()}" /></li>
				<li>Mode de paiement : <c:out
						value="${order.getModePaiement()}" /></li>
				<li>Statut Paiement : <c:out
						value="${order.getStatutPaiement()}" /></li>
				<li>Mode de livraison : <c:out
						value="${order.getModeLivraison()}" /></li>
				<li>Statut de livraison : <c:out
						value="${order.getStatutLivraison()}" /></li>
			</ul>


</body>
</html>