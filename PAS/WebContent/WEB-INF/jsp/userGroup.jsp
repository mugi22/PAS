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
		<form name="FREG" id="formCari" method="post" action="#">
			<table align="center">
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("userGroup.UserId")%></label>
						: <input name="UserId" type="text" id="UserId" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("userGroup.GroupId")%></label>
						: <input name="GroupId" type="text" id="GroupId" size="30"
						maxlength="30"></td>
				</tr>

				<tr>
					<td colspan="1">
						<div id="btn">
							<%@ include file="/util/searchButton.jsp"%>
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
        <table id="dg" title="USERGROUP" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="userId" width="100"sortable="true"><%=properties.getProperty("userGroup.UserId")%></th> 
                      <th field="userName" width="100"sortable="true"><%=properties.getProperty("user.Name")%></th>
                    <th field="groupId" width="100"sortable="true"><%=properties.getProperty("userGroup.GroupId")%></th> 
                      <th field="groupName" width="100"sortable="true"><%=properties.getProperty("group.GroupName")%></th> userName
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
	<div id="dlg" class="easyui-dialog"	style="width: 90%;  padding: 10px 20px" closed="true"	buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">USERGROUP</div>
		<form id="fm" method="post" novalidate>
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("userGroup.UserId")%></label> :<input
								name="userId" class="easyui-textbox" id="userId">
						</div></td>
						<td><input type="button" value="User Cari" style="width: 80px;" onclick="cariuser();"></td>
						<td><input type="text" style="width: 300px;" nama="namaUser" id="namaUser" class="easyui-textbox" ></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("userGroup.GroupId")%></label> :<input
								name="groupId" class="easyui-numberbox"
								data-options="min:0,precision:0,groupSeparator:','" id="groupId">
						</div></td>
						<td></td>
						<td></td>
				</tr>

			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="doSave()" style="width: 90px" id="btnSave">Save</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" 	iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"style="width: 90px" id="btnCancel">Cancel</a>
	</div>
	<!-- ************************************************END FORM******************* -->
<div id="win"></div>
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
		$('#namaUser').textbox('readonly', true);
		comboGroup($('#groupId'));
		comboGroup($('#GroupId'));
	});

	

	function cariuser() {
		$('#win').window(
				{
					width : 800,
					height : 400,
					href : 'userCari.htm?'	+ window.location.search.replace("?", ""),
					modal : true,					minimizable : false,					maximizable : false,					collapsible : false
				});
	}

	
	function ambilUser(s) {
		alert("xxx");
		var row = $('#dg2').datagrid('getSelected');
		$("#namaUser").textbox('setValue', row.name);
		$("#userId").textbox('setValue', row.userId);
		$('#win').window('close');
	}
	
	
	
	
	
	
	
	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'userGroupListAll.htm?'+
		'GroupId='+$('#GroupId').combobox('getValue')+"&"+'UserId='+$('#UserId').val()+"&"+"UID="+"${userId}";;
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
	
	/* ============FORM FUNCTION ========== userGrouptambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'userGroupAdd.htm?'+"UID="+"${userId}";
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
			url = 'userGroupEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			$.ajax({
				url:'getUserByUserId.htm?param='+row.userId,
			 	success	: function(result){
			 		var x = JSON.parse(result);
			 		$("#namaUser").textbox('setValue', x.name);
				 //alert("result "+result);
				 
			 }
			});
			onEdit();
		}
	}
	function doShow() {
		idRequired(false);
		doEdit();
		onShow();
		$('#dlg').dialog('open').dialog('setTitle', 'Tampil');
	}
	
	function doDelete() {
		idRequired(false);
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('userGroupDelete.htm', {
								UserId : row.userId,
                    			GroupId : row.groupId,
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
					$('#dg').datagrid({
						url : jsonurl
					});
				}
			}
		});
	}
	
	
function idRequired(t){
                    $('#userId').textbox({   required: t});
                    //$('#groupId').textbox({   required: t});


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
		$('#userId').textbox('readonly', true);
		$('#groupId').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#userId').textbox('readonly', true);
		$('#groupId').textbox('readonly', false);

		$('#btnSave').linkbutton('enable');
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#userId').textbox('readonly', true);
		$('#groupId').textbox('readonly', true);

		$('#btnSave').linkbutton('enable');
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'userGroupReport.htm?' + 'UserId=' + $('#UserId').val()
				+ "&" + 'GroupId=' + $('#GroupId').val() + "&" + "userId="
				+ "${userId}";
		;
		var s = window.location.search.replace("?", "");
		window
				.open(
						repUrl + "&" + s,
						"_blank",
						"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}
</script>
