<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client ajax</title>
</head>
<body>
	<div id="response"></div>
	<form:form id="myform" action="${pageContext.request.contextPath}/rest/add.do" commandName="client" cssClass="form-horizontal">
		<form:label path="nom" cssClass="col-lg-3 control-label">Nom</form:label>
		<form:input name="nom" path="nom" cssClass="col-lg-8 bg-focus" />
		<form:errors path="nom" />
		<br />
		<form:label path="email">Email</form:label>
		<form:input name="email" path="email" />
		<form:errors path="email" />
		<br />
		<form:label path="age">Age</form:label>
		<form:input name="age" path="age" />
		<form:errors path="age" />
		<br />
		<input type="submit" value="Valider" />
	</form:form>

	<table border="1">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Age</th>
				<th>Date inscription</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody id="msg">
		
		</tbody>
	</table>


	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script>
		var request = function() {
			$.ajax({
				datatype : "json",
				type : "GET",
				url : "../findAll.do"
			}).done(function(response) {
				var current = "";
				for (var i = 0; i < response.length; i++) {
					current += '<tr><td>' + response[i]["nom"]
					+ '</td><td>' + response[i]["age"]
					+ '</td><td> ('
					+ response[i]['dateInscription'] + ')</td>'
					+ '<td>' + response[i]["email"] + '</td>';
				}
				$('#msg').html(current);
			}).fail(function(response) {
				console.log(response.status);
				clearInterval(interval);
			});
		};
		var interval = setInterval(function() {
			request();
		}, 1000);
	</script>
	
	<script>
		$(document).ready(function() {
			$('#myform').submit(function(event) {
				var nom = $('#nom').val();
				var age = $('#age').val();
				var email = $('#email').val();
				var json = {
					"nom" : nom,
					"age" : age,
					"email" : email
				};
				$.ajax({
					url : $("#myform").attr("action"),
					data : JSON.stringify(json),
					type : "POST", 
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Content-Type", "application/json");
					},
					success : function(client) {
						var respContent = "";
						respContent += "<span class='success'>new client was created: ";
						respContent += client.id + " : " + client.nom;
						$("#response").html(respContent);
					}
				});
				event.preventDefault();
			});
		});
	</script>

</body>
</html>