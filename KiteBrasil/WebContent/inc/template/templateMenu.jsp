<ul class ="navbar">
  <li><a href="home">Home</a></li>
  <li><a href="#">News</a></li>
  <li><form name="monForm" method="post" action="creationClient">
  <a href="#" onclick="Go()">Save Client</a>
  </form></li>
  <li><form name="monForm2" method="post" action="creationCommande">
  <a href="#" onclick="GoGo()">Save Order</a>
  </form></li>
</ul>


<script language="javascript">
function Go()
{
document.monForm.submit();
}

function GoGo()
{
document.monForm2.submit();
}
</script>