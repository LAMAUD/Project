<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
<!--         <link type="text/css" rel="stylesheet" href="inc/style.css" /> -->
       
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
    </head>
    <body>
    
    <c:import url="/inc/template/templateMenu.jsp"/>
    
        <div>
            <form method="post" action="creationClient">
			<div class="container">
				<div class="col l12">
					<c:import url="/inc/template/templateCreateClient.jsp" />
				</div>
			</div>
			<input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>