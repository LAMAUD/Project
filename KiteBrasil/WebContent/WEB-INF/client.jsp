<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
<!--         <link type="text/css" rel="stylesheet" href="inc/style.css" /> -->
        	  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
    </head>
    <body>
    
    <c:import url="/inc/template/templateMenu.jsp"/>
    
        <div>
            <form method="post" action="creationClient">
                
                <c:import url="/inc/template/templateCreateClient.jsp"/>
                
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>