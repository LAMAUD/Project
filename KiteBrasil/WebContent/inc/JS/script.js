$(document).ready(function(){
    $('.materialboxed').materialbox();
  });

$(document).ready(function(){
    $('.parallax').parallax();
  });

$(document).ready(function() {
    $('select').material_select();
});


function removeField()
{
	obj=document.getElementById('montantCommande');
	obj.value="";
}