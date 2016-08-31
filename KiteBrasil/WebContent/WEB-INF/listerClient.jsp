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
              <th data-field="name">Name</th>
              <th data-field="firstname">Firstname</th>
              <th data-field="adresse">Adresse</th>
              <th data-field="Telephone">Telephone</th>
              <th data-field="mail">Mail</th>
              <th data-field="delete">Delete</th>
          </tr>
        </thead>
		<tbody>
			<c:forEach var="client" items="${sessionScope.clients}" >
				<tr>
					<td><c:out value="${client.getNom()}" /></td>
					<td><c:out value="${client.getPrenom()}" /></td>
					<td><c:out value="${client.getAdresse()}" /></td>
					<td><c:out value="${client.getTelNumber()}" /></td>
					<td><c:out value="${client.getMail()}" /></td>
					<td class="action">
                        <a href="<c:url value="/suppressionClient"><c:param name="nomClient" value="${ client.nom }" /></c:url>">
                            <img src="<c:url value="/inc/supprimer.png"/>" alt="Supprimer" />
                        </a>
                    </td>
				</tr>
			
			</c:forEach>
		</tbody>
		
		
		
		
		
    </body>
</html>