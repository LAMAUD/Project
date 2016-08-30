<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Recapitulation Client</title>
<!-- 	  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
</head>
<body>

	<c:import url="/inc/template/templateMenu.jsp" />

	<c:choose>
		<c:when test="${!error}">
			Nom : <c:out value="${client.getNom()}" /> <br/>
			Prenom : <c:out value="${client.getPrenom()}" /> <br/> 
			Adresse : <c:out value="${client.getAdresse()}" /> <br/>
			Tel : <c:out value="${client.getTelNumber()}" /> <br/>
			Mail : <c:out value="${client.getMail()}" /> <br/>
		</c:when>
		<c:otherwise> <div class="error">Erreur dans la saisie des données </div> </c:otherwise>
	</c:choose>
</body>
</html>