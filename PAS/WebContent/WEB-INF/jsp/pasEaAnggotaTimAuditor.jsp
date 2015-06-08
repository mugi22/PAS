<%-- 
Create by CodeGenerator
jspTemplate<meta http-equiv="Content-type" content="text/html;charset=UTF-8">
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
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
					.getProperty("pasEaAnggotaTimAuditor.KodeTkKantorAuditor")%></label>
						: <input name="KodeTkKantorAuditor" type="text"
						id="KodeTkKantorAuditor" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaAnggotaTimAuditor.KodeKantorAuditor")%></label>
						: <input name="KodeKantorAuditor" type="text"
						id="KodeKantorAuditor" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaAnggotaTimAuditor.KodeUserKetuaTimAuditor")%></label>
						: <input name="KodeUserKetuaTimAuditor" type="text"
						id="KodeUserKetuaTimAuditor" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaAnggotaTimAuditor.KodeUserAnggotaTimAuditor")%></label>
						: <input name="KodeUserAnggotaTimAuditor" type="text"
						id="KodeUserAnggotaTimAuditor" size="30" maxlength="30"></td>
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
        <table id="dg" title="PASEAANGGOTATIMAUDITOR" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeTkKantorAuditor" width="100"sortable="true"><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeTkKantorAuditor")%></th> 
                    <th field="kodeKantorAuditor" width="100"sortable="true"><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeKantorAuditor")%></th> 
                    <th field="kodeUserKetuaTimAuditor" width="100"sortable="true"><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeUserKetuaTimAuditor")%></th> 
                    <th field="kodeUserAnggotaTimAuditor" width="100"sortable="true"><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeUserAnggotaTimAuditor")%></th> 
                     
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
		<div class="ftitle">PASEAANGGOTATIMAUDITOR</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeTkKantorAuditor")%></label> :<input name="kodeTkKantorAuditor"	class="easyui-textbox" id="kodeTkKantorAuditor"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeKantorAuditor")%></label> :<input name="kodeKantorAuditor"	class="easyui-textbox" id="kodeKantorAuditor"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeUserKetuaTimAuditor")%></label> :<input name="kodeUserKetuaTimAuditor"	class="easyui-textbox" id="kodeUserKetuaTimAuditor"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaAnggotaTimAuditor.KodeUserAnggotaTimAuditor")%></label> :<input name="kodeUserAnggotaTimAuditor"	class="easyui-textbox" id="kodeUserAnggotaTimAuditor"></div></td></tr>	
			
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
		
		comboEaKantorAuditor($('#kodeKantorAuditor'));//form
		comboEaTkKantorAuditor($('#kodeTkKantorAuditor'),'',$('#kodeKantorAuditor'),'');//form
		comboEaKantorAuditor($('#KodeKantorAuditor'));
		comboEaTkKantorAuditor($('#KodeTkKantorAuditor'),'',$('#KodeKantorAuditor'),'');
		comboUserByBranch($('#kodeUserAnggotaTimAuditor'));
		comboUserByBranch($('#kodeUserKetuaTimAuditor'));
	});

	function test() {
		alert("testtttt..... click");
	}
	//overide yang di my.js
	function comboEaKantorAuditor(cmbKantorAuditor,kantorAuditorSelected) {
		comboUserByBranch($('#kodeUserKetuaTimAuditor'));
			cmbKantorAuditor.combobox({
			url :'comboPasEaKantorAuditorByTk.htm?param='+'&param2='+kantorAuditorSelected,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			onSelect: function(rec) {
				var z = JSON.stringify(rec);
				$.ajax({
					url:'comboKetuaTimAuditor.htm?param='+rec.id,				
					success:function(result){
					
					$('#kodeUserKetuaTimAuditor').combobox('clear');
					urlk ='comboUserBranch.htm?param='+rec.id+'&param2='+result;
					$('#kodeUserKetuaTimAuditor').combobox('reload',urlk);
					 $('#kodeUserKetuaTimAuditor').textbox('readonly', true);
					
					$('#kodeUserAnggotaTimAuditor').combobox('clear');
					urlk ='comboUserBranch.htm?param='+rec.id+'&param2='+result;
					$('#kodeUserAnggotaTimAuditor').combobox('reload',urlk);
					
					}
					});
			}
		});
	}
	
	function comboUserByBranch(cmbUser,userSelected) {
		cmbUser.combobox({
		url :'comboUserBranch.htm?param='+'&param2='+userSelected,
		valueField : 'id',
		textField : 'text',
		panelHeight:'auto',
		onSelect: function(rec) {
		}
	});
}


	function retrieve() {		
		var jsonurl = 'pasEaAnggotaTimAuditorListAll.htm?'+
'KodeUserAnggotaTimAuditor='+$('#KodeUserAnggotaTimAuditor').val()+"&"+'KodeTkKantorAuditor='+$('#KodeTkKantorAuditor').combobox('getValue')+"&"+'KodeKantorAuditor='+$('#KodeKantorAuditor').combobox('getValue')+"&"+'KodeUserKetuaTimAuditor='+$('#KodeUserKetuaTimAuditor').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== pasEaAnggotaTimAuditortambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasEaAnggotaTimAuditorAdd.htm?'+"userId="+"${userId}";
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
			url = 'pasEaAnggotaTimAuditorEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
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
			url = 'pasEaAnggotaTimAuditorEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
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
							$.post('pasEaAnggotaTimAuditorDelete.htm', {
							kodeUserAnggotaTimAuditor : row.kodeUserAnggotaTimAuditor,
		                    kodeTkKantorAuditor : row.kodeTkKantorAuditor,
		                    kodeKantorAuditor : row.kodeKantorAuditor,
		                    kodeUserKetuaTimAuditor : row.kodeUserKetuaTimAuditor,
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
	/*                $('#kodeUserAnggotaTimAuditor').textbox({   required: t});
                    $('#kodeTkKantorAuditor').textbox({   required: t});
                    $('#kodeKantorAuditor').textbox({   required: t});
                    $('#kodeUserKetuaTimAuditor').textbox({   required: t});


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
		            $('#kodeUserAnggotaTimAuditor').textbox('readonly', true);
                    $('#kodeTkKantorAuditor').textbox('readonly', true);
                    $('#kodeKantorAuditor').textbox('readonly', true);
                    $('#kodeUserKetuaTimAuditor').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		                    $('#kodeUserAnggotaTimAuditor').textbox('readonly', false);
                    $('#kodeTkKantorAuditor').textbox('readonly', false);
                    $('#kodeKantorAuditor').textbox('readonly', false);
                    $('#kodeUserKetuaTimAuditor').textbox('readonly', false);
		
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#kodeUserAnggotaTimAuditor').textbox('readonly', true);
                    $('#kodeTkKantorAuditor').textbox('readonly', true);
                    $('#kodeKantorAuditor').textbox('readonly', true);
                    $('#kodeUserKetuaTimAuditor').textbox('readonly', true);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'pasEaAnggotaTimAuditorReport.htm?'+
					  'KodeUserAnggotaTimAuditor='+$('#KodeUserAnggotaTimAuditor').val()+"&"+'KodeTkKantorAuditor='+$('#KodeTkKantorAuditor').val()+"&"+'KodeKantorAuditor='+$('#KodeKantorAuditor').val()+"&"+'KodeUserKetuaTimAuditor='+$('#KodeUserKetuaTimAuditor').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
