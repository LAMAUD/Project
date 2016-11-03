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
<link rel="stylesheet"
	href=<c:url value="/template/css/bootstrap.css" />>
<link rel="stylesheet" href=<c:url value="/template/css/style.css" />>

<!--[if lt IE 9]>
    <script src="resources/js/ie/respond.min.js" cache="false"></script>
    <script src="resources/js/ie/html5.js" cache="false"></script>
    <script src="resources/js/ie/excanvas.js" cache="false"></script>
  <![endif]-->
</head>
<body>
	<div class="panel-body">


		<c:choose>

			<c:when test="${isUpdate == false }">
				<spring:message code="titre.formulaire.creation"></spring:message>
			</c:when>
			<c:otherwise>
				<spring:message code="titre.formulaire.update"></spring:message>
		 ${client.nom }
		</c:otherwise>


		</c:choose>


		<form:form action="save.do" commandName="client" method="POST"
			cssClass="form-horizontal">

			<form:hidden name="id" path="id" />
			<div class="form-group">
				<form:label path="nom" cssClass="col-lg-3 control-label">Nom</form:label>
				<form:input name="nom" path="nom" cssClass="col-lg-8 bg-focus" />
				<form:errors path="nom" />
			</div>
			<br />
			<form:label path="email">Email</form:label>
			<form:input name="email" path="email" />
			<form:errors path="email" />

			<br />
			<form:label path="dateInscription">Date inscription</form:label>
			<form:input name="dateInscription" path="dateInscription"></form:input>
			<form:errors path="dateInscription" />
			<br />

			<form:label path="age">Age</form:label>
			<form:input name="age" path="age" />
			<form:errors path="age" />
			<br />

			<input type="submit" value="Valider" />

		</form:form>

	</div>
</body>
</html>