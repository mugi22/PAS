<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('css/bg_top.jpg')">
<h1>Main Page</h1>
<a href="userList.htm">User </a>
</body>
</html-->
<html>
<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<!-- meta charset="UTF-8"-->

<title>PAS G2</title>
<!--  -->
<link rel="stylesheet" type="text/css"	href="css/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">

<script type="text/javascript" src="css/jquery.min.js"></script>
<script type="text/javascript" src="css/jquery.easyui.min.js"></script>

              
</head>
<body id="cc" class="easyui-layout">
	
	<!-- div style="margin:  0px; padding: 0px"></div--> 
		<div data-options="region:'north',border:false"" style="height: 85px; background-color: #0081C2; padding: 1px; height:auto">
		<table width="100%" border="0" style="color: #ffffff">
				<tr>
					<td width="60%" >&nbsp&nbsp&nbsp&nbsp PEGADAIAN AUDIT SYSTEM
						<br>
						&nbsp&nbsp&nbsp&nbsp VER.1
					</td>
					<td>&nbsp</td>
					<td width="30%" align="right">
					<br>${kantorAuditor.nama}
 						<a href="#" class="easyui-menubutton" style="color: #ffffff" data-options="menu:'#mm1',iconCls:'icon-login'">${user.name} : ${user.branchCode}</a>
 						<div id="mm1" >
						<div data-options="plain:false,iconCls:'icon-logout'"><a style="color: #000000" href="logout.htm">Logout</a></div>
						<div data-options="plain:false,iconCls:'icon-lock'">  <a style="color: #000000"  onclick="changePasswod()" href="javascript:void(0)">Change Password</a></div>
   				 		</div>
					</td>
					<td width="1%">&nbsp</td>
				</tr>
			</table>
			
		</div>
			<!-- div data-options="region:'south',split:true" style="height: 50px;"></div-->
		<div data-options="region:'west',split:true" title="Menu" style="width: 200px;">		
	        ${menu} 
			
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">		
			<iframe src="utamaMain.htm?${paramx}" style="width: 100%; height: 99%;padding-top: 2px" id="iframe" frameborder="0"></iframe>			
		</div>
	</div>
<!-- a href="cariPegawai.htm">Test</a-->
</body>
</html>

<script type="text/javascript">


function changePasswod(){
	
	var url = 'changePassword.htm?'+"userId=${user.userId}";
	//$("#changePasswod").attr("href", url);
	$('#iframe').attr('src',url);
}




$("document").ready(function(){
	$('#tt').tree('collapseAll');
});
$('#tt').tree({
	onClick: function(node){
		//$.messager.progress();
		//alert(node.id);  // alert node text property when clicked
		//$.messager.progress({  title:'Your Title',  msg:'Processing, Please Wait'});
		//$.when(callMenu(node)).done(function(){call2();});
		callMenu(node);//.done(call2());
	}
	
});


function callMenu(node){
	var r = $.Deferred();
	$('#iframe').attr('src',node.id);
	$('#cc').layout('panel', 'center').panel('setTitle', node.text);	
	r.resolve();
	return r;
}

function call2(){
	$.messager.progress("close");
}
function test(){
	alert("test");
	$.messager.progress('close');
	//$('#cc').layout('panel', 'center').panel('setTitle', 'abc');
}

</script>
