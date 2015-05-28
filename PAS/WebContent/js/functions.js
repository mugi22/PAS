$(function() {
  $("#submit_login").click(function() {	  
	//$("img#imgLoad").show();
	var username = $("input#username").val();
	if (username == "") {
	   $('.errormess').html('Please Insert Your Username');	
       return false;
    }
	var password = $("input#password").val();
	if (password == "") {
	   $('.errormess').html('Please Insert Your Password');	
       return false;
    }
	var dataString = 'username='+ username + '&password=' + password;
	$.ajax({
      type: "POST",
      url: 'login.php',
      data: dataString,
	  dataType: "html",
      success: function(data) {
	  if (data == 0) {
	  $('.errormess').html('Wrong Username / Password Login');
		} else {
			//$("img#imgLoad").hide();
			$('.errormess').html('<b style="color:green;">you are logged. wait for redirection</b>');	
			document.location.href = 'utama.php';	
		}
      }
     });
    return false;
	});
});