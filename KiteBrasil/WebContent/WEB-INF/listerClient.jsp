<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste d'un client</title>

      
    </head>
    <body>
    
<c:import url="/inc/template/templateMenu.jsp" />

	<c:forEach var="client" items="${sessionScope.clients}" >
			Nom : <c:out value="${client.getNom()}" /> <br/>
			Prenom : <c:out value="${client.getPrenom()}" /> <br/> 
			Adresse : <c:out value="${client.getAdresse()}" /> <br/>
			Tel : <c:out value="${client.getTelNumber()}" /> <br/>
			Mail : <c:out value="${client.getMail()}" /> <br/>
			<br/>
		</c:forEach>
    </body>
</html>