<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste d'un client</title>
		<link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
      
    </head>
    <body>
    
	<c:import url="/inc/template/templateMenu.jsp" />

	<table>
        <thead>
          <tr>
          	  <th data-field="client">Nom Client</th>
              <th data-field="date">Date</th>
              <th data-field="montant">Montant</th>
              <th data-field="modePaiement">Mode de Paiement</th>
              <th data-field="statutPaiement">Statut de Paiement</th>
              <th data-field="modeLivraison">Mode de livraison</th>
              <th data-field="statutLivraison">Statut de livraison</th>
          </tr>
        </thead>
		<tbody>
			<c:forEach var="order" items="${sessionScope.commandes}" >
				<tr>
					<td><c:out value="${order.client.nom}" /></td>
					<td><c:out value="${order.getCommandDate()}" /></td>
					<td><c:out value="${order.getMontant()}" /></td>
					<td><c:out value="${order.getModePaiement()}" /></td>
					<td><c:out value="${order.getStatutPaiement()}" /></td>
					<td><c:out value="${order.getModeLivraison()}" /></td>
					<td><c:out value="${order.getStatutLivraison()}" /></td>
				</tr>
			
			</c:forEach>
		</tbody>
		
		
		
		
    </body>
</html>