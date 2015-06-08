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
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaKantorAuditor.KodeKantor")%></label>
						: <input name="KodeKantor" type="text" id="KodeKantor" size="30"
						maxlength="30"></td>
				
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaKantorAuditor.Nama")%></label>
						: <input name="Nama" type="text" id="Nama" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaKantorAuditor.KodeTk")%></label>
						: <input name="KodeTk" type="text" id="KodeTk" size="30"
						maxlength="30"></td>
				
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaKantorAuditor.KodeParent")%></label>
						: <input name="KodeParent" type="text" id="KodeParent" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaKantorAuditor.Status")%></label>
						: <input name="Status" type="text" id="Status" size="30"
						maxlength="30"></td>
				
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaKantorAuditor.Provinsi")%></label>
						: <input name="Provinsi" type="text" id="Provinsi" style="width: 300px;"></td>
				</tr>

				<tr>
					<td colspan="2">
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
        <table id="dg" title="PAS_EA_KANTOR_AUDITOR" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeKantor" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.KodeKantor")%></th> 
                    <th field="nama" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Nama")%></th> 
                    <th field="kodeTk" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.KodeTk")%></th> 
                    <th field="kodeParent" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.KodeParent")%></th> 
                    <th field="status" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Status")%></th> 
                    <th field="alamat" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Alamat")%></th> 
                    <th field="provinsi" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Provinsi")%></th> 
                    <th field="kota" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Kota")%></th> 
                    <th field="telp" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Telp")%></th> 
                    <th field="fax" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Fax")%></th> 
                    <th field="koordinat" width="100"sortable="true"><%=properties.getProperty("pasEaKantorAuditor.Koordinat")%></th> 
                     
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
		<div class="ftitle">PAS_EA_KANTOR_AUDITOR</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
        	<tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.KodeKantor")%></label> :<input name="kodeKantor"	class="easyui-textbox" id="kodeKantor"></div></td>	
        	<td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Nama")%></label> :<input name="nama"	class="easyui-textbox" id="nama"></div></td></tr>	
            <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.KodeTk")%></label> :<input name="kodeTk"	class="easyui-textbox" id="kodeTk"></div></td>
            <td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.KodeParent")%></label> :<input name="kodeParent"	class="easyui-textbox" id="kodeParent"></div></td></tr>	
            <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Status")%></label> :<input name="status"	class="easyui-textbox" id="status"></div></td>
            <tr><td colspan="2"><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Alamat")%></label> :<input name="alamat"	class="easyui-textbox" id="alamat" style="width: 400px;"></div></td></tr>		
            <tr><td colspan="2"><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Provinsi")%></label> :<input name="provinsi" style="width: 400px;"	class="easyui-textbox" id="provinsi"></div></td></tr>	
            <tr><td colspan="2"><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Kota")%></label> :<input name="kota"  style="width: 400px;"	class="easyui-textbox" id="kota"></div></td></tr>	
            <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Telp")%></label> :<input name="telp"	class="easyui-textbox" id="telp"></div></td>	
            <td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Fax")%></label> :<input name="fax"	class="easyui-textbox" id="fax"></div></td></tr>	
            <tr><td><div class="fitem">	<label><%=properties.getProperty("pasEaKantorAuditor.Koordinat")%></label> :<input name="koordinat"	class="easyui-textbox" id="koordinat"></div></td></tr>	
			
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
		comboEaTkKantorAuditor($('#kodeTk'));
		comboEaTkKantorAuditor($('#KodeTk'));
		comboLookup($('#status'),"STATUS-AUDITAN");
		
		//=====================
		comboProvinsi($("#provinsi"));//form	
		comboKabupaten($("#kota"));//form
		
		comboKabupaten($("#Kota"));
		comboProvinsiToKabupaten($("#Provinsi"),'',$("#Kota"),'');//seacrh	
	});

/* pinda ke my.js
	
	function comboKabupaten(cmbKab,kabupaten) {
		cmbKab.combobox({
			url : '',//'comboAllBranch.htm?param=' + kabupaten
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});
		kabupaten = '';
	}

	

	function comboProvinsiToKabupaten(cmbProvinsi,provinsi,cmbKabupaten,kabupaten) {
		cmbProvinsi.combobox({
			url : 'comboProvinsi.htm?param=' + provinsi+'&param2='+provinsi,
			valueField : 'id',
			textField : 'text',
			onSelect: function(rec) {
				var z = cmbProvinsi.combobox('getValue');
				//alert("kabupaten "+kabupaten);
				cmbKabupaten.combobox('clear');		
		        Urlk = 'comboKabupatenByProvinsi.htm?param='+z+'&param2='+kabupaten;//+          //"&selected="+unit;//11875
		        cmbKabupaten.combobox('reload', Urlk);
		         //alert("rec "+Urlk);
				}
		});
		//status = '';
	}	
	
	
	
	
*/
	
	
	
	
	
	
/*	pindah ke my.js blommm*/
	function comboEaTkKantorAuditor(k) {
		k.combobox({
			url : 'comboEaTkKantorAuditor.htm?param=' + kodeTk+'&param2=',
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});
		kodeTk = '';
	}
	

	

	
	
	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'pasEaKantorAuditorListAll.htm?'+
'Status='+$('#Status').val()+"&"+'Nama='+$('#Nama').val()+"&"+'KodeTk='+$('#KodeTk').combobox('getValue')+"&"+'KodeKantor='+$('#KodeKantor').val()+"&"+'Provinsi='+$('#Provinsi').combobox('getValue')+"&"+'KodeParent='+$('#KodeParent').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== pasEaKantorAuditortambah*/

	function doAdd() { 
	//	idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasEaKantorAuditorAdd.htm?'+"userId="+"${userId}";
		//comboEaTkKantorAuditor();
		comboProvinsiToKabupaten($("#provinsi"),'',$("#kota"),'');//seacrh
		onAdd();
	}
	function doEdit() {
	//	idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasEaKantorAuditorEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			$.ajax({
				url:'getKodeKabupaten.htm?param='+row.kota,
				success	: function(result){
					t = JSON.parse(result);
					//alert(t.kodeProvinsi+"=="+t.kodeKabupaten);
					//untuk combop provinsi bila di klik
					comboProvinsiToKabupaten($("#provinsi"),t.kodeProvinsi,$("#kota"),t.kodeKabupaten);//seacrh
					//default combox kabupaten yang diambil dari selectnya
					Urlk = 'comboKabupatenByProvinsi.htm?param='+t.kodeProvinsi+'&param2='+t.kodeKabupaten;//+ 
					$("#kota").combobox('reload', Urlk);
				}
			});
			
			
			
			onEdit();
		}
	}
	function doShow() {
	//	idRequired(false);
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
							$.post('pasEaKantorAuditorDelete.htm', {
				                    kodeKantor : row.kodeKantor,
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
	//idRequired(false);
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
                    $('#kodeKantor').textbox({   required: t});


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
		                    $('#status').textbox('readonly', true);
                    $('#telp').textbox('readonly', true);
                    $('#nama').textbox('readonly', true);
                    $('#kodeTk').textbox('readonly', true);
                    $('#fax').textbox('readonly', true);
                    $('#alamat').textbox('readonly', true);
                    $('#koordinat').textbox('readonly', true);
                    $('#kodeKantor').textbox('readonly', true);
                    $('#provinsi').textbox('readonly', true);
                    $('#kota').textbox('readonly', true);
                    $('#kodeParent').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		                    $('#status').textbox('readonly', false);
                    $('#telp').textbox('readonly', false);
                    $('#nama').textbox('readonly', false);
                    $('#kodeTk').textbox('readonly', false);
                    $('#fax').textbox('readonly', false);
                    $('#alamat').textbox('readonly', false);
                    $('#koordinat').textbox('readonly', false);
                    $('#kodeKantor').textbox('readonly', false);
                    $('#provinsi').textbox('readonly', false);
                    $('#kota').textbox('readonly', false);
                    $('#kodeParent').textbox('readonly', false);
		
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#status').textbox('readonly', false);
                    $('#telp').textbox('readonly', false);
                    $('#nama').textbox('readonly', false);
                    $('#kodeTk').textbox('readonly', false);
                    $('#fax').textbox('readonly', false);
                    $('#alamat').textbox('readonly', false);
                    $('#koordinat').textbox('readonly', false);
                    $('#kodeKantor').textbox('readonly', true);
                    $('#provinsi').textbox('readonly', false);
                    $('#kota').textbox('readonly', false);
                    $('#kodeParent').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'pasEaKantorAuditorReport.htm?'+
					  'Status='+$('#Status').val()+"&"+'Nama='+$('#Nama').val()+"&"+'KodeTk='+$('#KodeTk').val()+"&"+'KodeKantor='+$('#KodeKantor').val()+"&"+'Provinsi='+$('#Provinsi').val()+"&"+'KodeParent='+$('#KodeParent').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
