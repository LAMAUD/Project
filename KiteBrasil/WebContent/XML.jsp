<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Xpath</title>
</head>
<body>
<!-- Contenu Brut -->
	<c:import url="monDocument.xml" varReader="monReader">

		<x:parse var="doc" doc="${monReader}" scope="request"/>
		<x:forEach var="livre" select="$doc/inventaire/livre">
			Auteur : <x:out select="$livre/auteur"/> ,
			Titre : <x:out select="$livre/titre"/> ,
			Date : <x:out select="$livre/date"/> ,
			Prix : <x:out select="$livre/prix"/> ,
			Stock : <x:out select="$livre/stock"/> ,
			Minimum : <x:out select="$livre/minimum"/>
			<br/>
			<x:if select="$livre/stock < $livre/minimum">
			Attention !! Stock en dessous du seuil minimum spécifié !
			<br/>
			</x:if>
			<br/>
		</x:forEach>
		</c:import>
		
		
------------------------------Correction------------------------------------------

<%-- Récupération du document XML. --%>
<c:import url="monDocument.xml" var="documentXML" />
<%-- Analyse du document XML récupéré. --%>
<x:parse var="doc" doc="${documentXML}" />

<p><b>Liste de tous les livres :</b></p>
<div>
<ul>
<%-- Parcours du document parsé pour y récupérer chaque nœud "livre". --%>
<x:forEach var="livre" select="$doc/inventaire/livre">
	<%-- Affichage du titre du livre récupéré. --%>
    <li><x:out select="$livre/titre" /></li>
</x:forEach>
</ul>
</div>

<p><b>Liste des livres qu'il faut réapprovisionner :</b></p>
<div>
<ul>
<%-- Parcours du document parsé pour y récupérer chaque nœud "livre" 
	dont le contenu du nœud "stock" est inférieur au contenu du nœud
	"minimum". --%>
<x:forEach var="livre" select="$doc/inventaire/livre[stock < minimum]">
	<%-- Affichage des titres, stocks et minimaux du livre récupéré. --%>
    <li><x:out select="$livre/titre" /> : <x:out select="$livre/stock" /> livres en stock (limite avant alerte : <x:out select="$livre/minimum" />)</li>
</x:forEach>
</ul>
</div>

<p><b>Liste des livres classés par stock :</b></p>
<%-- Il faut réfléchir... un peu ! --%>
<pre>
Le tri d'une liste, d'un tableau, d'une collection... bref de manière générale le tri de données,
ne doit pas se faire depuis votre page JSP ! Que ce soit en utilisant les API relatives aux collections, 
ou via un bean de votre couche métier, ou que sais-je encore, il est toujours préférable que votre tri 
soit effectué avant d'arriver à votre JSP. La JSP ne doit en principe que récupérer cette collection déjà triée, 
formater les données pour une mise en page particulière si nécessaire, et seulement les afficher.

C'était un simple piège ici, j'espère que vous avez réfléchi avant de tenter d'implémenter un tri avec
la JSTL, et que vous comprenez pourquoi cela ne doit pas intervenir à ce niveau ;)
</pre>

</body>
</html>