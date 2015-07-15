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
                    <label><%=properties.getProperty("priviledge.GroupId")%></label> : <input name="GroupId" type="text" id="GroupId" size="30" maxlength="30"><br>
                    <label><%=properties.getProperty("priviledge.MenuId")%></label> : <input name="MenuId" type="text" id="MenuId" size="30" maxlength="30"><br>

                <div id="btn">     
                    <%@ include file="/util/searchButton.jsp" %>
                </div>
            </form> 
            <div id="result"></div>
        </div>
        <hr>
<!-- ******************************END  FORM PENCARIAN******************************* -->  

<!-- **********************TABLE RESULT************************************** -->
        <table id="dg" title="PRIVILEDGE" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"
               data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="groupId" width="100"sortable="true"><%=properties.getProperty("priviledge.GroupId")%></th> 
                    <th field="groupName" width="100"sortable="true"><%=properties.getProperty("group.GroupName")%></th> 
                    <th field="menuId" width="100"sortable="true"><%=properties.getProperty("priviledge.MenuId")%></th> 
                     <th field="menuName" width="100"sortable="true"><%=properties.getProperty("menu.MenuName")%></th> 
                    <th field="isAdd" width="100"sortable="true"><%=properties.getProperty("priviledge.IsAdd")%></th> 
                    <th field="isDelete" width="100"sortable="true"><%=properties.getProperty("priviledge.IsDelete")%></th> 
                    <th field="isUpdate" width="100"sortable="true"><%=properties.getProperty("priviledge.IsUpdate")%></th> 
                    <th field="isView" width="100"sortable="true"><%=properties.getProperty("priviledge.IsView")%></th> 
                    <!-- menuName -->
                </tr>
            </thead>
        </table>        
                  
        <div id="toolbar">
        <%@ include file="/util/toolbar.jsp" %>          
        	<td align="right">
        	<!-- 
        		 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-authorize" plain="true" onclick="" id="btnAdd" ><%=properties.getProperty("button.otorize")  %></a>
        	-->
        	</td>
        	</tr>
        </table>
        </div>
 <!-- ************************** END LIST/TABLE ******************************************** -->       
    
          
<!-- ************************** FORM ******************************************** -->
	<div id="dlg" class="easyui-dialog"	style="width: 750px;  padding: 10px 20px" closed="true"	buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">PRIVILEDGE</div>
		<form id="fm" method="post" novalidate> 
                    <div class="fitem">	<label><%=properties.getProperty("priviledge.GroupId")%></label> :<input name="groupId"	class="easyui-numberbox" required="false" id="groupId">	</div>
                    <div class="fitem">	<label><%=properties.getProperty("priviledge.MenuId")%></label> :<input name="menuId"	class="easyui-textbox" required="false" id="menuId">	</div>
                    <div class="fitem">	<label><%=properties.getProperty("priviledge.IsAdd")%></label> :<input name="isAdd"	class="easyui-textbox" required="false" id="isAdd">	</div>
                    <div class="fitem">	<label><%=properties.getProperty("priviledge.IsDelete")%></label> :<input name="isDelete"	class="easyui-textbox" required="false" id="isDelete">	</div>
                    <div class="fitem">	<label><%=properties.getProperty("priviledge.IsUpdate")%></label> :<input name="isUpdate"	class="easyui-textbox" required="false" id="isUpdate">	</div>
                    <div class="fitem">	<label><%=properties.getProperty("priviledge.IsView")%></label> :<input name="isView"	class="easyui-textbox" required="false" id="isView">	</div>
			
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
var groupId;
	$("document").ready(function() {
		$("#btnAdd").linkbutton('${btnAdd}');
		$("#btnEdit").linkbutton('${btnEdit}');
		$("#btnDelete").linkbutton('${btnDelete}');
		$("#btnShow").linkbutton('${btnShow}');		
		comboGroup($('#groupId'));
		comboYesNo($('#isAdd'));
		comboYesNo($('#isDelete'));
		comboYesNo($('#isView'));
		comboYesNo($('#isUpdate'));
		comboGroup($('#GroupId'));
		comboMenu($('#MenuId'));
		comboMenu($('#menuId'));
		
	});

	function test() {
		alert("testtttt..... click");
	}

/* function untuk list data      param=' + $('#idSearch').val();//+'&param2='++ $('#idSearch2').val();*/
	function retrieve() {		
		var jsonurl = 'priviledgeListAll.htm?'+
'GroupId='+$('#GroupId').combobox('getValue')+"&"+'MenuId='+$('#MenuId').combobox('getValue')+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ==========*/

	function doAdd() { 
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah ');
		$('#fm').form('clear');
		url = 'priviledgeAdd.htm?'+"userId="+"${userId}";
		onAdd();
	}

	function doEdit() {
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit ');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'priviledgeEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
		}
	}

	function doShow() {
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');		
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Tampil ');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'priviledgeEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
			onShow();
		}
	}
	
	function doDelete() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('priviledgeDelete.htm', {
								groupId : row.groupId,
								menuId : row.menuId,
								userId:"${userId}"
								//SESUAIKAN Id=>huruf depan BEsar row.Id==>huruf depan kecil
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
	
	
	/* ================TAMBAHAN=================*/
	//untuk mengisi combobox kode cabang keseluruhan dengan default value sesuai parameter
	function addComboBranch() {
		$('#branchCode').combobox({
			url : 'comboAllBranch.htm?param=' + branchcode,
			valueField : 'id',
			textField : 'text'
		});
		branchcode = '';
	}
	
	/*Untuk membuat menjadi huruf besar semua */
	function upperCase(t) {
		t.textbox('textbox').bind('keyup', function(e) {
			$(this).val($(this).val().toUpperCase());
		});
	}
	
	/*inputan readonly atau tidak saat onShow */
	function onShow() {
		$('#groupId').textbox('readonly', true);
		$('#menuId').textbox('readonly', true);
		$('#isAdd').textbox('readonly', true);
		$('#isDelete').textbox('readonly', true);
		$('#isUpdate').textbox('readonly', true);
		$('#isView').textbox('readonly', true);
		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#groupId').textbox('readonly', false);
		$('#menuId').textbox('readonly', false);
		$('#isAdd').textbox('readonly', false);
		$('#isDelete').textbox('readonly', false);
		$('#isUpdate').textbox('readonly', false);
		$('#isView').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#groupId').textbox('readonly', true);
		$('#menuId').textbox('readonly', true);
		$('#isAdd').textbox('readonly', false);
		$('#isDelete').textbox('readonly', false);
		$('#isUpdate').textbox('readonly', false);
		$('#isView').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
	}
//	comboGroup
//satatus pegawai
	
	
</script>
