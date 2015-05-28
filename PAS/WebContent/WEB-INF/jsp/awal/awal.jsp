<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>PAS ONLINE</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="css/jquery.min.js"></script>
<script type="text/javascript" src="js/functions.js"></script>

</head>
<body>

	<section class="container">
	<div class="login">
		<h1>
			<img src="image/logotrans.png" align="left" height="35px"	style="margin-top: 2px" />
			<div align="right">Pegadaian Audit System&nbsp&nbsp</div>
		</h1>
		<form method="post" action="awal.htm" id="formLogin">
			<p>
				<input type="text" name="username" id="username" value="P81035" placeholder="Username" style="text-transform: uppercase">
			</p>
			<p>
				<input type="password" name="password" id="password" value="123" placeholder="PASSWORD">
			</p>
			<p class="submit">
			<input type="button" value="Submit" class="button blue" onclick="myFunction()">
			
				<!-- input type="submit" name="commit" id="submit_login" value="Login" 	class="button blue">  -->
			</p>
			<img src="image/ajax_loader.gif" width="16" id="imgLoad"style="display: none;" /> <span class="login_loading"></span> 
			<span class="errormess"></span>
		</form>
	</div>

	<div class="login-help">
		<p>
			Lupa password? <a href="lupapassword.php">Click Disini </a>.
		</p>
	</div>
	</section>

	<p class="about-author">&copy; 2015 Divisi Teknologi Informasi PT
		Pegadaian (Persero)</p>
</body>
</html>


<script>

function myFunction(){
	if($('#username').val()==""){
		alert("UserName Tidak Boleh Kosong");
		return false;
	}else if($('#password').val()==""){
		alert("Password Tidak Boleh Kosong");
		return false;
	}else{
		$('#formLogin').submit();
	}
	//
}


</script>