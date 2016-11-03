<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>

</head>
<body>

	<table border="1">
		<tr>
			<th>Nom</th>
			<th>Email</th>
			<th>Age</th>
			<th>Date inscription</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="client" items="${ clients}">
			<tr>
				<td>${ client.nom}</td>
				<td>${ client.email}</td>
				<td>${ client.age}</td>
				<td>${ client.dateInscription}</td>
				<td colspan="2"><security:authorize ifAllGranted="ROLE_ADMIN">
						<a href="delete.do?id=${client.id }">Delete</a>
					</security:authorize> <a href="init.do?id=${client.id }">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="../j_spring_security_logout"/>">Deconnexion</a>
</body>




















</html>