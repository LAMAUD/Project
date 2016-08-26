<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Création d'une commande</title>
<!--         <link type="text/css" rel="stylesheet" href="inc/style.css" /> -->
	  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
    </head>
    <body>
    
    <c:import url="/inc/template/templateMenu.jsp"/>
        <div>
            <form method="post" action="creationCommande">
            
            <div class="container">
            	<div class="row">
            		<div class="col l5">
                		<c:import url="/inc/template/templateCreateClient.jsp"/>
               		</div>
               		<div class="col l5 offset-l2">
               			<c:import url="/inc/template/templateInitOrder.jsp"/>
                	</div>
                </div>
            </div>
              
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>