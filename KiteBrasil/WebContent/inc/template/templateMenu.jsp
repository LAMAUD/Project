<!-- <ul class ="navbar"> -->
<!--   <li><a href="home">Home</a></li> -->
<!--   <li><a href="#">News</a></li> -->
<!--   <li><form name="monForm" method="post" action="creationClient"> -->
<!--   <a href="#" onclick="Go()">Save Client</a> -->
<!--   </form></li> -->
<!--   <li><form name="monForm2" method="post" action="creationCommande"> -->
<!--   <a href="#" onclick="GoGo()">Save Order</a> -->
<!--   </form></li> -->
<!--   <li><form name="boum" method="post" action="disconnection"> -->
<!--   <a href="#" onclick="disco()">Deconnexion</a> -->
<!--   </form></li> -->
<!-- </ul> -->

<header class="header">
  <nav>
    <div class="nav-wrapper blue lighten-1">
      <a href="home" class="brand-logo">Logo</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><form name="monForm" method="post" action="creationClient"><a href="#" onclick="Go()">Save Client</a></form></li>
        <li><form name="monForm2" method="post" action="creationCommande"><a href="#" onclick="GoGo()">Save Order</a></form></li>
        <li><form name="listClient" method="post" action="listclient"><a href="#" onclick="listClient()">Lister Clients </a></form></li>
        <li><form name="boum" method="post" action="disconnection"><a href="#" onclick="disco()">Deconnexion </a></form></li>
      </ul>
    </div>
  </nav>
</header>


<script language="javascript">
function Go()
{
document.monForm.submit();
}

function GoGo()
{
document.monForm2.submit();
}

function disco()
{
document.boum.submit();
}

function listClient()
{
document.listClient.submit();
}
</script>