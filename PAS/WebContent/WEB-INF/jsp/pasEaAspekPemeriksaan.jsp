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
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaAspekPemeriksaan.KodeJenisPemeriksaan")%></label>
						: <input name="KodeJenisPemeriksaan" type="text"
						id="KodeJenisPemeriksaan" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaAspekPemeriksaan.KodeAspekPemeriksaan")%></label>
						: <input name="KodeAspekPemeriksaan" type="text"
						id="KodeAspekPemeriksaan" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaAspekPemeriksaan.KdParent")%></label>
						: <input name="KdParent" type="text" id="KdParent" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaAspekPemeriksaan.Status")%></label>
						: <input name="Status" type="text" id="Status" size="30"
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
        <table id="dg" title="PASEAASPEKPEMERIKSAAN" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeJenisPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KodeJenisPemeriksaan")%></th> 
                    <th field="kodeAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KodeAspekPemeriksaan")%></th> 
                    <th field="namaAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.NamaAspekPemeriksaan")%></th> 
                    <th field="keteranganAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KeteranganAspekPemeriksaan")%></th> 
                    <th field="tujuanAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.TujuanAspekPemeriksaan")%></th> 
                    <th field="kdParent" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KdParent")%></th> 
                    <th field="status" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.Status")%></th> 
                    <th field="HavaChild" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.HaveChild")%></th> 
                     
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
		<div class="ftitle">PASEAASPEKPEMERIKSAAN</div>
		<form id="fm" method="post" novalidate>
		<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaAspekPemeriksaan.KodeJenisPemeriksaan")%></label>
							:<input name="kodeJenisPemeriksaan" class="easyui-textbox"
								id="kodeJenisPemeriksaan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaAspekPemeriksaan.KodeAspekPemeriksaan")%></label>
							:<input name="kodeAspekPemeriksaan" class="easyui-textbox"
								id="kodeAspekPemeriksaan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaAspekPemeriksaan.NamaAspekPemeriksaan")%></label>
							:<input name="namaAspekPemeriksaan" class="easyui-textbox"
								id="namaAspekPemeriksaan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaAspekPemeriksaan.KeteranganAspekPemeriksaan")%></label>
							:<input name="keteranganAspekPemeriksaan" class="easyui-textbox"
								id="keteranganAspekPemeriksaan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaAspekPemeriksaan.TujuanAspekPemeriksaan")%></label>
							:<input name="tujuanAspekPemeriksaan" class="easyui-textbox"
								id="tujuanAspekPemeriksaan" data-options="multiline:true" style="height:60px; width: 400px;">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaAspekPemeriksaan.KdParent")%></label>
							:<input name="kdParent" class="easyui-textbox" id="kdParent">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaAspekPemeriksaan.HaveChild")%></label>
							:<input name="HavaChild" class="easyui-textbox" id="HavaChild" >
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaAspekPemeriksaan.Status")%></label>
							:<input name="status" class="easyui-textbox" id="status">
						</div></td>
				</tr>
				

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
		comboLookup($('#Status'),"STATUS");//seach
		comboLookup($('#status'),"STATUS");//form 
		comboEaJenisPemeriksaan($('#KodeJenisPemeriksaan'),"");
		comboEaJenisPemeriksaan($('#kodeJenisPemeriksaan'),"");
		comboYesNo($('#HavaChild'));
		//comboYesNo($('#isDelete'));
	});

	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'pasEaAspekPemeriksaanListAll.htm?'+
'Status='+$('#Status').combobox('getValue')+"&"+'KodeAspekPemeriksaan='+$('#KodeAspekPemeriksaan').val()+"&"+'KodeJenisPemeriksaan='+$('#KodeJenisPemeriksaan').combobox('getValue')+"&"+'KdParent='+$('#KdParent').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== pasEaAspekPemeriksaantambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasEaAspekPemeriksaanAdd.htm?'+"userId="+"${userId}";
		onAdd();
	}
	function doEdit() {
		//idRequired(false);
		comboYesNo($('#haveChild'));
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasEaAspekPemeriksaanEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
			//
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
							$.post('pasEaAspekPemeriksaanDelete.htm', {
							                    kodeAspekPemeriksaan : row.kodeAspekPemeriksaan,
                    kodeJenisPemeriksaan : row.kodeJenisPemeriksaan,
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
		                    $('#status').textbox('readonly', true);
                    $('#kodeAspekPemeriksaan').textbox('readonly', true);
                    $('#namaAspekPemeriksaan').textbox('readonly', true);
                    $('#keteranganAspekPemeriksaan').textbox('readonly', true);
                    $('#tujuanAspekPemeriksaan').textbox('readonly', true);
                    $('#kodeJenisPemeriksaan').textbox('readonly', true);
                    $('#kdParent').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		            $('#status').textbox('readonly', false);
                    $('#kodeAspekPemeriksaan').textbox('readonly', true);
                    $('#namaAspekPemeriksaan').textbox('readonly', false);
                    $('#keteranganAspekPemeriksaan').textbox('readonly', false);
                    $('#tujuanAspekPemeriksaan').textbox('readonly', false);
                    $('#kodeJenisPemeriksaan').textbox('readonly', false);
                    $('#kdParent').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#status').textbox('readonly', false);
                    $('#kodeAspekPemeriksaan').textbox('readonly', true);
                    $('#namaAspekPemeriksaan').textbox('readonly', false);
                    $('#keteranganAspekPemeriksaan').textbox('readonly', false);
                    $('#tujuanAspekPemeriksaan').textbox('readonly', false);
                    $('#kodeJenisPemeriksaan').textbox('readonly', true);
                    $('#kdParent').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'pasEaAspekPemeriksaanReport.htm?'+
					  'Status='+$('#Status').val()+"&"+'KodeAspekPemeriksaan='+$('#KodeAspekPemeriksaan').val()+"&"+'KodeJenisPemeriksaan='+$('#KodeJenisPemeriksaan').val()+"&"+'KdParent='+$('#KdParent').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
