<%@page import="fr.cla.pojo.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kite Surf</title>
</head>
<body>
	
	



	<p>
		<c:out value="${client.nom}" default="Aucune Valeur n'a été rentrée"/>
		<br/>
		<c:out value="${client.mail}" default="Aucune Valeur n'a été rentrée"/>
	</p>


</body>
</html>