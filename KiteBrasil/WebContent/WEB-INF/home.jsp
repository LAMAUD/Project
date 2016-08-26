<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="/KiteBrasil/inc/style.css"> -->
<title>Kite Surf</title>

	  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="inc/CSS/materialize.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="inc/CSS/ajout.css"/>
</head>

<body>

<%-- 	<c:import url="/inc/template/templateMenu.jsp"/> --%>
	
	  <div id="index-banner" class="parallax-container">
    	<div class="section no-pad-bot">
      		<div class="container">
        		<br><br>
        		<h1 class="header center teal-text text-lighten-2">Cours Kite</h1>
        		<div class="row center">
          			<h5 class="header col s12 light">Un nouveau site de Kite</h5>
        		</div>
        		<div class="row center">
          			<a href="#" id="download-button" class="btn-large waves-effect waves-light teal lighten-1">Get Started</a>
        		</div>
        		<br><br>
      		</div>
    	</div>
    	<div class="parallax"><img src="inc/images/Spot_Kite.jpg" alt="Unsplashed background img 1"></div>
  	</div>
	
	
	<div class="container">
    
    	<h2 class="header indigo-text lighten-1 section-title">
    		<span>
    			<i class="mdi-action-cached"></i>
    			Team
    		</span>
   		</h2>
   
       <div class="row">
        <div class="col s12 m4 l4">
          <div class="card">
            <div class="card-image">
              <img src="inc/images/PhotoKevin.jpg">
              <span class="card-title">Kevin</span>
            </div>
            <div class="card-content">
              <p>I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a href="#">This is a link</a>
            </div>
          </div>
        </div>
        <div class="col s12 m4 l4">
          <div class="card">
            <div class="card-image">
              <img src="inc/images/PhotoNico.jpg">
              <span class="card-title">Nicolas</span>
            </div>
            <div class="card-content">
              <p>I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a href="#">This is a link</a>
            </div>
          </div>
        </div>
        <div class="col s12 m4 l4">
          <div class="card">
            <div class="card-image">
              <img src="inc/images/PhotoClement.jpg">
              <span class="card-title">Clement</span>
            </div>
            <div class="card-content">
              <p>I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a href="#">This is a link</a>
            </div>
          </div>
        </div>
      </div>

    	
	</div>
	
	
	  <div id="index-banner" class="parallax-container">
    	<div class="section no-pad-bot">
      		<div class="container">
        		<div class="row bouls center">
					<div class="video-container">
        				<iframe class="" width="700" height="350" src="//www.youtube.com/embed/X2KH02zs4r4?rel=0" frameborder="0" allowfullscreen></iframe>
    				</div>
    		</div>
        		<br><br>
      		</div>
   		</div>
    	<div class="parallax"><img src="inc/images/Parallaxe_1.jpg" alt="Unsplashed background img 1"></div>
  	</div>
    
    
    
    
	
    <c:import url="/inc/template/templateFooter.jsp"/>
	
	
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="inc/JS/materialize.js"></script>
    <script type="text/javascript" src="inc/JS/script.js"></script>
    

</body>
</html>