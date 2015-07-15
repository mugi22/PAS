<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/util/include.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<h2>Change Password</h2>
	
	<div style="margin: 20px 0;"></div>
	<div style="width: 100%">
		<div style="padding: 10px 60px 20px 60px">
			<form id="ff" method="post">
				<table cellpadding="5" align="center">

					<tr>
						<td style="width: 200px">UserId
						<td>
						<td><input class="easyui-textbox" type="text" name="UserId"
							id="UserId" data-options="required:false" value=""></td>
					</tr>
					<tr>
						<td style="width: 200px">Name
						<td>
						<td><input class="easyui-textbox" type="text" name="Name"
							id="Name" data-options="required:false" value="" style="width: 400px"></td>
					</tr>
					<tr>
						<td style="width: 200px">New Password
						<td>
						<td><input class="easyui-textbox" type="password" name="Password"
							id="Password" data-options="required:false" value=""></td>
					</tr>



				</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"	onclick="submitForm()">Submit</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
			</div>
		</div>
	</div>
	<div id="win"></div>
	
</body>
</html>
<script>
$("document").ready(function() {
		$("#UserId").textbox('setValue',"${tblUser.userId}");
		$("#UserId").textbox('readonly',true);
		$("#Name").textbox('setValue',"${tblUser.name}");
		$("#Name").textbox('readonly',true);
});
function clearForm() {
	$("#Password").textbox("setValue","");
}

function submitForm() {
	var url = 'changePasswordEdit.htm?' + "userId=" + "${tblUser.userId}";
	$('#ff').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var resultx = eval('(' + result + ')');
			if (resultx === 'fail' || result === null) {
				alert("Simpan Gagal");
				$.messager.show({
					title : 'Error',
					msg : "Simpan Gagal"
				});
			} else {
				alert("Simpan Sukses ");
				$("#Password").textbox("setValue","");
			}
		}
	});
}
</script>