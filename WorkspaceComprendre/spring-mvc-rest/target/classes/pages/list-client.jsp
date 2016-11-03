<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@
taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<jsp:include page="/template/header.jsp">
	<jsp:param value="active" name="menuAdministrateurActive" />
	<jsp:param value="Solices - Détails Administrateur" name="titreOnglet" />
</jsp:include>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="app bg-default horizontal-layout">

				<table class="table table-striped list no-m">
					<!-- JSP -->

					<tbody>
						<tr>
							<th>Id</th>
							<th><spring:message code="label.name" text="default text" /></th>
							<th>Email</th>
							<sec:authorize ifAllGranted="ROLE_ADMIN">
								<th>Actions</th>
							</sec:authorize>
						</tr>
						<c:forEach items="${clients}" var="client">
							<c:url var="urlClientDelete" value="/rest/delete/${client.id}" />
							<c:url var="urlClientUpdate" value="/rest/update/${client.id}" />

							<tr>
								<td>${client.id }</td>

								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlClientUpdate}">${client.nom}</a>
									</sec:authorize> <sec:authorize ifAllGranted="ROLE_USER">
										${client.nom}
									</sec:authorize></td>
								<td>${client.email}</td>
								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlClientDelete}">delete</a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>