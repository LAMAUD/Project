<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Création d'une commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    
    <c:import url="/inc/template/templateMenu.jsp"/>
        <div>
            <form method="post" action="creationCommande">
            
                <c:import url="/inc/template/templateCreateClient.jsp"/>
                <c:import url="/inc/template/templateInitOrder.jsp"/>
              
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>