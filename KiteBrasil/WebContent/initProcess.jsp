<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Init Process</title>
</head>
<body>

    <c:forEach var="parametre" items="${ paramValues }"> 
         <ul>
            <li><b><c:out value="${ parametre.key }"/></b> :</li>

            <c:forEach var="value" items="${ parametre.value }">
               <c:out value="${ value }"/>   
            </c:forEach>
         </ul>
      </c:forEach>

<p>---------------------------------------------------------------------------------------</p>
	<c:out value="${param.nom}" />
	<c:out value="${param.prenom}" />

	<table>
		<tr>
			<th>n°</th>
			<th>Pays</th>
		</tr>
		<c:forEach items="${paramValues.pays}" var="pays" varStatus="status">
			<tr>
				<td><c:out value="${status.count}" /></td>
				<td><c:out value="${pays}" /></td>
			</tr>
		</c:forEach>
	</table>

	<c:forTokens var="paysAutre" items="${param.autre}"
		delims=";,+">
  ${paysAutre}<br />
	</c:forTokens>



</body>
</html>