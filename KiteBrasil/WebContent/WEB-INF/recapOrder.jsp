<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Recapitulation Commande</title>
	 
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
</head>
<body>

	<c:import url="/inc/template/templateMenu.jsp" />

<div class = "recapOrder">
			
			<p>	Mr
				<c:out value="${order.getClient().getNom()}" />
				a commandé : </p>
			<ul>
				<li><label>Date de Commande </label> :  <span><c:out
						value=" ${order.getCommandDate()}" /></span></li>
				<li><label>Montant de la commande</label> : <span><c:out
						value="${order.getMontant()}" /></span></li>
				<li><label>Mode de paiement</label> : <span><c:out
						value="${order.getModePaiement()}" /></span></li>
				<li><label>Statut Paiement</label> : <span><c:out
						value="${order.getStatutPaiement()}" /></span></li>
				<li><label>Mode de livraison</label> : <span><c:out
						value="${order.getModeLivraison()}" /></span></li>
				<li><label>Statut de livraison</label> : <span><c:out
						value="${order.getStatutLivraison()}" /></span></li>
			</ul>
</div>

</body>
</html>