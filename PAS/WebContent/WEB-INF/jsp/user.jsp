<%-- 
Create by CodeGenerator
jspTemplate
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/util/include.jsp" %>  
<title>User</title>
</head>
<body>

<!-- ******************************FORM PENCARIAN******************************* -->   
        <div id="div2">
            <form name="FREG" id="formCari" method="post" action="#"  >   
            <table align="center">  	                       
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("user.Name")%></label> : <input name="Name" type="text" id="Name" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("user.UserId")%></label> : <input name="UserId" type="text" id="UserId" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("user.BranchCode")%></label> : <input name="BranchCode" type="text" id="BranchCode" size="30" maxlength="30"></td>
</tr>

				 <tr>
	            	<td colspan="1">
	                <div id="btn">     
	                    <%@ include file="/util/searchButton.jsp" %>
	                </div>
            	</td>
	            	
	            </tr>  
            </table>  
            </form> 
            <div id="result"></div>
        </div>
        <hr>
<!-- ******************************END  FORM PENCARIAN******************************* -->  


<!-- **********************TABLE RESULT************************************** -->
        <table id="dg" title="USER" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="name" width="100"sortable="true"><%=properties.getProperty("user.Name")%></th> 
                    <th field="endTime" width="100"sortable="true"><%=properties.getProperty("user.EndTime")%></th> 
                    <th field="startTime" width="100"sortable="true"><%=properties.getProperty("user.StartTime")%></th> 
                    <th field="enabled" width="100"sortable="true"><%=properties.getProperty("user.Enabled")%></th> 
                    <th field="password" width="100"sortable="true"><%=properties.getProperty("user.Password")%></th> 
                    <th field="lastChangePwd" width="100"sortable="true"><%=properties.getProperty("user.LastChangePwd")%></th> 
                    <th field="limitApproval" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.limitApproval,0,'.',','); }"align="right"><%=properties.getProperty("user.LimitApproval")%></th> 
                    <th field="loginFailCount" width="100"sortable="true"><%=properties.getProperty("user.LoginFailCount")%></th> 
                    <th field="branchMobileId" width="100"sortable="true"><%=properties.getProperty("user.BranchMobileId")%></th> 
                    <th field="userId" width="100"sortable="true"><%=properties.getProperty("user.UserId")%></th> 
                    <th field="branchCode" width="100"sortable="true"><%=properties.getProperty("user.BranchCode")%></th> 
                    <th field="lastLogIn" width="100"sortable="true"><%=properties.getProperty("user.LastLogIn")%></th> 
                    <th field="email" width="100"sortable="true"><%=properties.getProperty("user.Email")%></th> 
                     
                </tr>
            </thead>
        </table>  
        <div id="toolbar">
        	<%@ include file="/util/toolbar.jsp" %>
        	<td align="right">
        	<!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-authorize" plain="true" onclick="" id="btnAdd" ><%=properties.getProperty("button.otorize") %></a>
        	 -->
        	</td>
        	</tr>
        </table>
        </div>

 <!-- ************************** END LIST/TABLE ******************************************** -->       
    
          
<!-- ************************** FORM ******************************************** -->
	<div id="dlg" class="easyui-dialog"	style="width: 750px;  padding: 10px 20px" closed="true"	buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">USER</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.Name")%></label> :<input name="name"	class="easyui-textbox" id="name"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.EndTime")%></label> :<input name="endTime"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="endTime"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.StartTime")%></label> :<input name="startTime"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="startTime"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.Enabled")%></label> :<input name="enabled"	class="easyui-textbox" id="enabled"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.Password")%></label> :<input name="password"	class="easyui-textbox" id="password"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.LastChangePwd")%></label> :<input name="lastChangePwd"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="lastChangePwd"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.LimitApproval")%></label> :<input name="limitApproval"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="limitApproval"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.BranchMobileId")%></label> :<input name="branchMobileId"	class="easyui-textbox" id="branchMobileId"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.UserId")%></label> :<input name="userId"	class="easyui-textbox" id="userId"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.BranchCode")%></label> :<input name="branchCode"	class="easyui-textbox" id="branchCode"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.LastLogIn")%></label> :<input name="lastLogIn"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="lastLogIn"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("user.Email")%></label> :<input name="email"	class="easyui-textbox" id="email"></div></td></tr>	
			
		</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="doSave()" style="width: 90px" id="btnSave">Save</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" 	iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"style="width: 90px" id="btnCancel">Cancel</a>
	</div>
	<!-- ************************************************END FORM******************* -->

</body>
</html>



<script>
var url;
var branchcode;
	$("document").ready(function() {
		$("#btnAdd").linkbutton('${btnAdd}');
		$("#btnEdit").linkbutton('${btnEdit}');
		$("#btnDelete").linkbutton('${btnDelete}');
		$("#btnShow").linkbutton('${btnShow}');		
	});

	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'userListAll.htm?'+
'Name='+$('#Name').val()+"&"+'UserId='+$('#UserId').val()+"&"+'BranchCode='+$('#BranchCode').val()+"&"+"userId="+"${userId}";
		$('#dg').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total == 0) {
					alert("Data Tidak Ditemukan..................");
				}
			}
		});
	}

	function doClear() {
		$('#formCari').form('clear');
		var jsonurl = "listClear.htm";
		$('#dg').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total > 0) {
					alert("Clear Gagal..................");
				}
			}
		});
	}

	/* END function untuk list data*/
	
	/* ============FORM FUNCTION ========== usertambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'userAdd.htm?'+"userId="+"${userId}";
		onAdd();
	}
	function doEdit() {
		idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'userEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
		}
	}
	function doShow() {
		idRequired(false);
		doEdit();
		onShow();
		$('#dlg').dialog('open').dialog('setTitle', 'Tampil');
	/*
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');		
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Tampil');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'userEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
			onShow();
		}
		*/
	}
	
	function doDelete() {
		idRequired(false);
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('userDelete.htm', {
							                    userId : row.userId,
							userId:"${userId}"
							}, function(result) {
								if (result.success) {
									$('#dg').datagrid('reload'); // reload the user data
								} else {
									$.messager.show({ // show error message
										title : 'Error',
										msg : result.errorMsg + "Delete Gagal "
									});
								}
							}, 'json');
						}
					});
		}
	}

	function doSave() {
	idRequired(false);
		$('#fm').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var resultx = eval('(' + result + ')');
				if (resultx === 'fail' || result === null) {
					alertError("Simpan Gagal");					
				} else {
					alertAll('Simpan Sukses');
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
					//$('#dg').datagrid({	url : jsonurl});
				}
			}
		});
	}
	
	
function idRequired(t){
                    $('#userId').textbox({   required: t});


	/*$('#idJurnalTransaksi').textbox({   required: t			});
	$('#jurnalId').textbox({   required: t	});
	*/
}	
	
	
	/* ================TAMBAHAN=================*/

	
	/*Untuk membuat menjadi huruf besar semua */
	function upperCase(t) {
		t.textbox('textbox').bind('keyup', function(e) {
			$(this).val($(this).val().toUpperCase());
		});
	}
	
	/*inputan readonly atau tidak saat onShow  XXXenableField */
	function onShow() {
		                    $('#name').textbox('readonly', true);
                    $('#endTime').textbox('readonly', true);
                    $('#startTime').textbox('readonly', true);
                    $('#enabled').textbox('readonly', true);
                    $('#password').textbox('readonly', true);
                    $('#lastChangePwd').textbox('readonly', true);
                    $('#limitApproval').textbox('readonly', true);
                    $('#loginFailCount').textbox('readonly', true);
                    $('#branchMobileId').textbox('readonly', true);
                    $('#userId').textbox('readonly', true);
                    $('#branchCode').textbox('readonly', true);
                    $('#lastLogIn').textbox('readonly', true);
                    $('#email').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		                    $('#name').textbox('readonly', false);
                    $('#endTime').textbox('readonly', false);
                    $('#startTime').textbox('readonly', false);
                    $('#enabled').textbox('readonly', false);
                    $('#password').textbox('readonly', false);
                    $('#lastChangePwd').textbox('readonly', false);
                    $('#limitApproval').textbox('readonly', false);
                    $('#loginFailCount').textbox('readonly', false);
                    $('#branchMobileId').textbox('readonly', false);
                    $('#userId').textbox('readonly', false);
                    $('#branchCode').textbox('readonly', false);
                    $('#lastLogIn').textbox('readonly', false);
                    $('#email').textbox('readonly', false);
		
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#name').textbox('readonly', false);
                    $('#endTime').textbox('readonly', false);
                    $('#startTime').textbox('readonly', false);
                    $('#enabled').textbox('readonly', false);
                    $('#password').textbox('readonly', false);
                    $('#lastChangePwd').textbox('readonly', false);
                    $('#limitApproval').textbox('readonly', false);
                    $('#loginFailCount').textbox('readonly', false);
                    $('#branchMobileId').textbox('readonly', false);
                    $('#userId').textbox('readonly', true);
                    $('#branchCode').textbox('readonly', false);
                    $('#lastLogIn').textbox('readonly', false);
                    $('#email').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'userReport.htm?'+
					  'Name='+$('#Name').val()+"&"+'UserId='+$('#UserId').val()+"&"+'BranchCode='+$('#BranchCode').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>