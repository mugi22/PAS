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
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.AlamatIP")%></label> : <input name="AlamatIP" type="text" id="AlamatIP" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.KodeRecord")%></label> : <input name="KodeRecord" type="text" id="KodeRecord" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.NamaTable")%></label> : <input name="NamaTable" type="text" id="NamaTable" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.Aksi")%></label> : <input name="Aksi" type="text" id="Aksi" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.KodeUserPelaku")%></label> : <input name="KodeUserPelaku" type="text" id="KodeUserPelaku" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.KodeAuditTrail")%></label> : <input name="KodeAuditTrail" type="text" id="KodeAuditTrail" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("pasKsAuditTrail.NamaKomputer")%></label> : <input name="NamaKomputer" type="text" id="NamaKomputer" size="30" maxlength="30"></td>
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
        <table id="dg" title="PASKSAUDITTRAIL" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="alamatIP" width="100"sortable="true"><%=properties.getProperty("pasKsAuditTrail.AlamatIP")%></th> 
                    <th field="kodeRecord" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.kodeRecord,0,'.',','); }"align="right"><%=properties.getProperty("pasKsAuditTrail.KodeRecord")%></th> 
                    <th field="namaTable" width="100"sortable="true"><%=properties.getProperty("pasKsAuditTrail.NamaTable")%></th> 
                    <th field="aksi" width="100"sortable="true"><%=properties.getProperty("pasKsAuditTrail.Aksi")%></th> 
                    <th field="kodeUserPelaku" width="100"sortable="true"><%=properties.getProperty("pasKsAuditTrail.KodeUserPelaku")%></th> 
                    <th field="kodeAuditTrail" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.kodeAuditTrail,0,'.',','); }"align="right"><%=properties.getProperty("pasKsAuditTrail.KodeAuditTrail")%></th> 
                    <th field="namaKomputer" width="100"sortable="true"><%=properties.getProperty("pasKsAuditTrail.NamaKomputer")%></th> 
                     
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
		<div class="ftitle">PASKSAUDITTRAIL</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.AlamatIP")%></label> :<input name="alamatIP"	class="easyui-textbox" id="alamatIP"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.KodeRecord")%></label> :<input name="kodeRecord"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="kodeRecord"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.NamaTable")%></label> :<input name="namaTable"	class="easyui-textbox" id="namaTable"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.Aksi")%></label> :<input name="aksi"	class="easyui-textbox" id="aksi"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.KodeUserPelaku")%></label> :<input name="kodeUserPelaku"	class="easyui-textbox" id="kodeUserPelaku"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.KodeAuditTrail")%></label> :<input name="kodeAuditTrail"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="kodeAuditTrail"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasKsAuditTrail.NamaKomputer")%></label> :<input name="namaKomputer"	class="easyui-textbox" id="namaKomputer"></div></td></tr>	
			
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
		var jsonurl = 'pasKsAuditTrailListAll.htm?'+
'AlamatIP='+$('#AlamatIP').val()+"&"+'KodeRecord='+$('#KodeRecord').val()+"&"+'NamaTable='+$('#NamaTable').val()+"&"+'Aksi='+$('#Aksi').val()+"&"+'KodeUserPelaku='+$('#KodeUserPelaku').val()+"&"+'KodeAuditTrail='+$('#KodeAuditTrail').val()+"&"+'NamaKomputer='+$('#NamaKomputer').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== pasKsAuditTrailtambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasKsAuditTrailAdd.htm?'+"userId="+"${userId}";
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
			url = 'pasKsAuditTrailEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
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
			url = 'pasKsAuditTrailEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
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
							$.post('pasKsAuditTrailDelete.htm', {
							                    kodeAuditTrail : row.kodeAuditTrail,
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
                    $('#kodeAuditTrail').textbox({   required: t});


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
		                    $('#alamatIP').textbox('readonly', true);
                    $('#kodeRecord').textbox('readonly', true);
                    $('#namaTable').textbox('readonly', true);
                    $('#aksi').textbox('readonly', true);
                    $('#kodeUserPelaku').textbox('readonly', true);
                    $('#kodeAuditTrail').textbox('readonly', true);
                    $('#namaKomputer').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		                    $('#alamatIP').textbox('readonly', false);
                    $('#kodeRecord').textbox('readonly', false);
                    $('#namaTable').textbox('readonly', false);
                    $('#aksi').textbox('readonly', false);
                    $('#kodeUserPelaku').textbox('readonly', false);
                    $('#kodeAuditTrail').textbox('readonly', false);
                    $('#namaKomputer').textbox('readonly', false);
		
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#alamatIP').textbox('readonly', false);
                    $('#kodeRecord').textbox('readonly', false);
                    $('#namaTable').textbox('readonly', false);
                    $('#aksi').textbox('readonly', false);
                    $('#kodeUserPelaku').textbox('readonly', false);
                    $('#kodeAuditTrail').textbox('readonly', true);
                    $('#namaKomputer').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'pasKsAuditTrailReport.htm?'+
					  'AlamatIP='+$('#AlamatIP').val()+"&"+'KodeRecord='+$('#KodeRecord').val()+"&"+'NamaTable='+$('#NamaTable').val()+"&"+'Aksi='+$('#Aksi').val()+"&"+'KodeUserPelaku='+$('#KodeUserPelaku').val()+"&"+'KodeAuditTrail='+$('#KodeAuditTrail').val()+"&"+'NamaKomputer='+$('#NamaKomputer').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
