<%-- 
Create by CodeGenerator
jspTemplate
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-type" content="text/html;charset=UTF-8"-->
<%@ include file="/util/include.jsp" %>  
<title>User</title>
</head>
<body>

<!-- ******************************FORM PENCARIAN******************************* -->
	<div id="div2">
		<form name="FREG" id="formCari" method="post" action="#">
			<table align="center">
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaPPLUser.KodePPLUSer")%></label>
						: <input name="KodePPLUSer" type="text" id="KodePPLUSer" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaPPLUser.KodeUser")%></label>
						: <input name="KodeUser" type="text" id="KodeUser" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaPPLUser.PenyelenggaraPPL")%></label>
						: <input name="PenyelenggaraPPL" type="text" id="PenyelenggaraPPL"
						size="30" maxlength="30"></td>
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
        <table id="dg" title="PASEAPPLUSER" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodePPLUSer" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.KodePPLUSer")%></th> 
			        <th field="namaPPL" width="100"sortable="true"><%=properties.getProperty("pasEaPPL.NamaPPL")%></th> 
                    <th field="kodeUser" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.KodeUser")%></th> 
			        <th field="userName" width="100"sortable="true"><%=properties.getProperty("user.Name")%></th> 
                    <th field="penyelenggaraPPL" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.PenyelenggaraPPL")%></th> 
                    <th field="tglAwalPPL" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.TglAwalPPL")%></th> 
                    <th field="tglAkhirPPL" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.TglAkhirPPL")%></th> 
                    <th field="lamaPPL" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.lamaPPL,0,'.',','); }"align="right"><%=properties.getProperty("pasEaPPLUser.LamaPPL")%></th> 
                    <th field="nilai" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.nilai,2,'.',','); }"align="right"><%=properties.getProperty("pasEaPPLUser.Nilai")%></th> 
                    <th field="namaFileBuktiPPL" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.NamaFileBuktiPPL")%></th> 
                    <th field="fileBuktiPPL" width="100"sortable="true"><%=properties.getProperty("pasEaPPLUser.FileBuktiPPL")%></th> 
			                 
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
		<div class="ftitle">PASEAPPLUSER</div>
		<form id="fm" method="post" novalidate enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.KodeUser")%></label>
							:<input name="kodeUser" class="easyui-textbox" id="kodeUser"
								required="true">
						</div></td>
					<td><input name="cariUser" id="cariUserId" value="Cari" type="button" onclick="cariuser();" style="width: 35px;">
					</td>
					<td><input name="namaUser" class="easyui-textbox"
						id="namaUser" style="width: 200px;"></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.KodePPLUSer")%></label>
							:<input name="kodePPLUSer" class="easyui-textbox"
								id="kodePPLUSer">
						</div></td>
				</tr>
				<tr>
					<td colspan="3"><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.PenyelenggaraPPL")%></label>
							:<input name="penyelenggaraPPL" class="easyui-textbox"
								id="penyelenggaraPPL" style="width: 300px;">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.TglAwalPPL")%></label>
							:<input name="tglAwalPPL" class="easyui-datebox"
								data-options="formatter:myformatter,parser:myparser"
								id="tglAwalPPL">
						</div></td>
						<td></td>
						<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.TglAkhirPPL")%></label>
							:<input name="tglAkhirPPL" class="easyui-datebox"
								data-options="formatter:myformatter,parser:myparser"
								id="tglAkhirPPL">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.LamaPPL")%></label>
							:<input name="lamaPPL" class="easyui-numberbox" value="0"
								data-options="precision:0,groupSeparator:','" id="lamaPPL" >
						</div></td>
				<td></td>
				
				<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.Nilai")%></label>
							:<input name="nilai" class="easyui-numberbox" value="0.00"
								data-options="precision:2,groupSeparator:','" id="nilai" >
						</div></td>
					
				</tr>
				<!-- tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.FileBuktiPPL")%></label>
							:<input name="fileBuktiPPL" class="easyui-textbox"
								id="fileBuktiPPL">
						</div></td>
						<td></td>
						<td><div class="fitem">
							<label><%=properties.getProperty("pasEaPPLUser.NamaFileBuktiPPL")%></label>
							:<input name="namaFileBuktiPPL" class="easyui-textbox"
								id="namaFileBuktiPPL">
						</div></td>
				</tr-->
				<tr>
						<td>
						 	File to upload: <input type="file" name="file"><br /> 
						</td>
						<td>
							
						</td>
				</tr>
				<tr>
					<td colspan="2"><div id="linkFile"></div></td>
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


<script type="text/javascript">


</script>

</body>
</html>



<script>
var url;
var branchcode;
	$("document").ready(function() {
		$("#btnAdd").linkbutton('${btnAdd}');
		$("#btnEdit").linkbutton('${btnEdit}');
		$("#btnDelete").linkbutton('${btnDelete}');
		$("#btnShow").linkbutton('${btnShow}');		//comboEaPPL
		$("#kodeUser").textbox('readonly',true);
		$("#namaUser").textbox('readonly', true);
		$("#fileBuktiPPL").textbox('readonly', true);
		$("#namaFileBuktiPPL").textbox('readonly', true);
		$("#linkFile").empty();
		
		comboEaPPL($("#kodePPLUSer"));
		comboEaPPL($("#KodePPLUSer"));
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
		var row = $('#dg2').datagrid('getSelected');
		$("#namaUser").textbox('setValue', row.name);
		$("#kodeUser").textbox('setValue', row.userId);
		$('#win').window('close');
	}
	
	
	function retrieve() {
		var jsonurl = 'pasEaPPLUserListAll.htm?' + 'KodePPLUSer='
				+ $('#KodePPLUSer').combobox('getValue') + "&"
				+ 'PenyelenggaraPPL=' + $('#PenyelenggaraPPL').val() + "&"
				+ 'KodeUser=' + $('#KodeUser').val() + "&" + "userId="
				+ "${userId}";
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

	/* ============FORM FUNCTION ========== pasEaPPLUsertambah*/
	function doAdd() {
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasEaPPLUserAdd.htm?' + "userId=" + "${userId}";
		onAdd();
		$("#linkFile").empty();
		$("#lamaPPL").numberbox({value:0});
		$("#nilai").numberbox({value:0});
	}
	function doEdit() {
		idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasEaPPLUserEdit.htm?' + "userId=" + "${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			//cari nama user yang akan diedit
			$.ajax({
				url:'getUserByUserId.htm?param='+row.kodeUser,
			 	success	: function(result){
			 		var x = JSON.parse(result);
			 		$("#namaUser").textbox('setValue', x.name);
			 }
			});
			$("#linkFile").empty();
			$("#linkFile").append('<a href=downloadFiles.htm?param='+(row.fileBuktiPPL).replace(" ","%20")+' download>'+row.fileBuktiPPL+'</a>');
			onEdit();
		}
	}
	function doShow() {
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
							$.post('pasEaPPLUserDelete.htm', {
								kodePPLUSer : row.kodePPLUSer,
								kodeUser : row.kodeUser,
								userId : "${userId}"
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

	function idRequired(t) {
		/*              $('#kodePPLUSer').textbox({   required: t});
		                $('#kodeUser').textbox({   required: t});
		$('#idJurnalTransaksi').textbox({   required: t			});
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
		$('#kodePPLUSer').textbox('readonly', true);
		$('#penyelenggaraPPL').textbox('readonly', true);
		$('#tglAkhirPPL').textbox('readonly', true);
		$('#namaFileBuktiPPL').textbox('readonly', true);
		$('#fileBuktiPPL').textbox('readonly', true);
		$('#kodeUser').textbox('readonly', true);
		$('#tglAwalPPL').textbox('readonly', true);
		$('#lamaPPL').textbox('readonly', true);
		$('#nilai').textbox('readonly', true);
		$('#btnSave').linkbutton('disable');
		$("#cariUserId").attr("disabled", "disabled"); 
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#kodePPLUSer').textbox('readonly', false);
		$('#penyelenggaraPPL').textbox('readonly', false);
		$('#tglAkhirPPL').textbox('readonly', false);
		$('#namaFileBuktiPPL').textbox('readonly', true);
		$('#fileBuktiPPL').textbox('readonly', true);
		$('#kodeUser').textbox('readonly', true);
		$('#tglAwalPPL').textbox('readonly', false);
		$('#lamaPPL').textbox('readonly', false);
		$('#nilai').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
		$("#cariUserId").removeAttr("disabled"); 
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#kodePPLUSer').textbox('readonly', true);
		$('#penyelenggaraPPL').textbox('readonly', false);
		$('#tglAkhirPPL').textbox('readonly', false);
		$('#namaFileBuktiPPL').textbox('readonly', true);
		$('#fileBuktiPPL').textbox('readonly', true);
		$('#kodeUser').textbox('readonly', true);
		$('#tglAwalPPL').textbox('readonly', false);
		$('#lamaPPL').textbox('readonly', false);
		$('#nilai').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
		$("#cariUserId").attr("disabled", "disabled"); 
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'pasEaPPLUserReport.htm?' + 'KodePPLUSer='
				+ $('#KodePPLUSer').val() + "&" + 'PenyelenggaraPPL='
				+ $('#PenyelenggaraPPL').val() + "&" + 'KodeUser='
				+ $('#KodeUser').val() + "&" + "userId=" + "${userId}";
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
