<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var="urlResources" value="/resources" />
<!-- core styles -->

<script src="${urlResources}/plugins/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="${urlResources}/bootstrap/css/bootstrap.min.css">
<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${urlResources}/css/animate.min.css">
<sec:authentication var="principal" property="principal" />
<c:url var="urlGetPrincipalId" value="/client/principal/id" />

<title>Lister client</title>
</head>

<div class="row">
	<div class="col-lg-4"></div>
	<a class="btn btn-primary">Botton</a>
</div>


<body class="bg-default">
	<div class="row-fluid" style="min-height: 220px; overflow: hidden;">
		<header class="header navbar shadow">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="brand">
					<!-- toggle offscreen menu -->
					<a class="ti-menu navbar-toggle off-left visible-xs"
						data-toggle="collapse" data-target="#menu-collapse"></a>
					<!-- /toggle offscreen menu -->

					<!-- logo -->
					<a href="<c:url  value="/client/list.do" />" class="navbar-brand">
						<img height="auto" src="${urlResources}/img/cat.jpg" alt="">
					</a>
					<!-- /logo -->
				</div>

				<div class="collapse navbar-collapse pull-left" id="menu-collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url  value="/client/list.do" />"><spring:message
									code="list.client" text="default text" /></a></li>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<li><a href="<c:url  value="/client/client.do" />"><spring:message
										code="create.client" text="default text" /></a></li>
						</sec:authorize>
					</ul>
				</div>

				<ul class="nav navbar-nav navbar-right">

					<li class="off-right"><a href="#" data-toggle="dropdown">
							<span class="ml10">${principal.username}</span> <i
							class="ti-angle-down ti-caret"></i>
					</a>
						<ul class="dropdown-menu animated fadeInRight">
							<c:url var="urlClientUpdate"
								value="/client/update.do?id=${userSessionId}" />
							<li><a href="${urlClientUpdate}"><spring:message
										code="my.account" text="default text" /></a></li>
							<li><a href="<c:url value="/logout" />">Déconnexion</a></li>
						</ul></li>
				</ul>
			</div>
		</header>
	</div>

	Language :
	<a href="?lang=en">English</a>|
	<a href="?lang=fr">Francais</a>