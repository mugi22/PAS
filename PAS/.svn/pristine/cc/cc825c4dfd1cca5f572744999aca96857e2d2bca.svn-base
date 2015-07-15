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
					.getProperty("pasEaProsedurPemeriksaan.KodeAspekPemeriksaan")%></label>
						: <input name="KodeAspekPemeriksaan" type="text"
						id="KodeAspekPemeriksaan" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaProsedurPemeriksaan.KodePemeriksaan")%></label>
						: <input name="KodePemeriksaan" type="text" id="KodePemeriksaan"
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
        <table id="dg" title="PASEAPROSEDURPEMERIKSAAN" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeJenisPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.KodeJenisPemeriksaan")%></th> 
                    <th field="kodeAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.KodeAspekPemeriksaan")%></th> 
                    <th field="kodePemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.KodePemeriksaan")%></th> 
                    <th field="caraPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.CaraPemeriksaan")%></th> 
                    <th field="petunjukPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.PetunjukPemeriksaan")%></th> 
                    <th field="namaFileTemplateKKP" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.NamaFileTemplateKKP")%></th> 
                    <th field="fileTemplateKKP" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.FileTemplateKKP")%></th> 
                    <th field="tkResikoAsptekTerperiksa" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.TkResikoAsptekTerperiksa")%></th> 
                    <th field="kriteria" width="100"sortable="true"><%=properties.getProperty("pasEaProsedurPemeriksaan.Kriteria")%></th> 
                     
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
		<div class="ftitle">PASEAPROSEDURPEMERIKSAAN</div>
		<form id="fm" method="post" novalidate>
		<table align="center" border="0">
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.KodeAspekPemeriksaan")%></label>
							:<input name="kodeAspekPemeriksaan" class="easyui-textbox"	id="kodeAspekPemeriksaan">
								<input type="button" value="Cari" style="width: 50px" onclick="cariAspek()" id="buttonCari">
						</div></td>
						
				</tr>
				
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.NamaAspek")%></label>
							:<input name="namaAspek" class="easyui-textbox"	id="namaAspek">
						</div></td>
				</tr>
				
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.KodeJenisPemeriksaan")%></label>
							:<input name="kodeJenisPemeriksaan" class="easyui-textbox"
								id="kodeJenisPemeriksaan" style="width: 400px;">
						</div></td>
						
				</tr>
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.KodePemeriksaan")%></label>
							:<input name="kodePemeriksaan" class="easyui-textbox"
								id="kodePemeriksaan">
						</div></td>
						
				</tr>
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.CaraPemeriksaan")%></label>
							:<input name="caraPemeriksaan" class="easyui-textbox"  	data-options="multiline:true" style="height:40px; width: 400px;"
								id="caraPemeriksaan">
						</div></td>
						
				</tr>
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties.getProperty("pasEaProsedurPemeriksaan.Kriteria")%></label>
							:<input name="kriteria" class="easyui-textbox" id="kriteria" data-options="multiline:true" style="height:40px; width: 400px;">
						</div></td>
						
				</tr>
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.PetunjukPemeriksaan")%></label>
							:<input name="petunjukPemeriksaan" class="easyui-textbox"	id="petunjukPemeriksaan" data-options="multiline:true" style="height:40px; width: 400px;">
						</div></td>
						
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.NamaFileTemplateKKP")%></label>
							:<input name="namaFileTemplateKKP" class="easyui-textbox"
								id="namaFileTemplateKKP">
						</div></td>
						<td></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.FileTemplateKKP")%></label>
							:<input name="fileTemplateKKP" class="easyui-textbox"
								id="fileTemplateKKP">
						</div></td>
						
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaProsedurPemeriksaan.TkResikoAsptekTerperiksa")%></label>
							:<input name="tkResikoAsptekTerperiksa" class="easyui-textbox"
								id="tkResikoAsptekTerperiksa">
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
		
		comboEaJenisPemeriksaan($('#kodeJenisPemeriksaan'),"");
		$('#kodeJenisPemeriksaan').textbox('readonly', true);
		$('#namaAspek').textbox('readonly', true);
	});

	function test() {
		alert("testtttt..... click");
	}
	
	
	
	function cariAspek() {
		$('#win').window(
				{
					width : 800,
					height : 400,
					href : 'pasEaAspekPemeriksaanCari.htm?'
							+ window.location.search.replace("?", ""),
					modal : true,					minimizable : false,					maximizable : false,				collapsible : false
				});
	}

	function ambilAspek(s) {
		var row = $('#dg2').datagrid('getSelected');
		$("#kodeAspekPemeriksaan").textbox('setValue', row.kodeAspekPemeriksaan);
    	$("#namaAspek").textbox('setValue', row.namaAspekPemeriksaan);
		
		comboEaJenisPemeriksaan($('#kodeJenisPemeriksaan'),row.kodeJenisPemeriksaan);
		$("#kodeJenisPemeriksaan").textbox('setValue', row.kodeJenisPemeriksaan);
		$('#win').window('close');
	}

	
	function retrieve() {		
		var jsonurl = 'pasEaProsedurPemeriksaanListAll.htm?'+
'KodeAspekPemeriksaan='+$('#KodeAspekPemeriksaan').val()+"&"+'KodePemeriksaan='+$('#KodePemeriksaan').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== pasEaProsedurPemeriksaantambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasEaProsedurPemeriksaanAdd.htm?'+"userId="+"${userId}";
		onAdd();
		//comboEaJenisPemeriksaan($('#kodeJenisPemeriksaan'),row.kodeJenisPemeriksaan);
	}
	function doEdit() {
		idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasEaProsedurPemeriksaanEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
			$.ajax({
				url:'getAspekPemeriksaanById.htm?param='+row.kodeAspekPemeriksaan+"&param2="+row.kodeJenisPemeriksaan,
				success	: function(result){
					x = JSON.parse(result);
					$("#namaAspek").textbox('setValue', x.namaAspekPemeriksaan);
				}
			});
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
							$.post('pasEaProsedurPemeriksaanDelete.htm', {
							                    kodeAspekPemeriksaan : row.kodeAspekPemeriksaan,
                    kodePemeriksaan : row.kodePemeriksaan,
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
	
	

	function idRequired(t) {
		/*
		 $('#kodeAspekPemeriksaan').textbox({   required: t});
		 $('#kodePemeriksaan').textbox({   required: t});
		 $('#kodeJenisPemeriksaan').textbox({   required: t});

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
		$('#kodeAspekPemeriksaan').textbox('readonly', true);
		$('#kodePemeriksaan').textbox('readonly', true);
		$('#caraPemeriksaan').textbox('readonly', true);
		$('#petunjukPemeriksaan').textbox('readonly', true);
		$('#namaFileTemplateKKP').textbox('readonly', true);
		$('#fileTemplateKKP').textbox('readonly', true);
		$('#tkResikoAsptekTerperiksa').textbox('readonly', true);
		$('#kriteria').textbox('readonly', true);
		$('#kodeJenisPemeriksaan').textbox('readonly', true);
		$('#btnSave').linkbutton('disable');
		//$('#buttonCari').textbox(readonly, true);
		$("#buttonCari").attr("disabled", "disabled"); 
		//$("#buttonCari").removeAttr("disabled"); 
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#kodeAspekPemeriksaan').textbox('readonly', true);
		$('#kodePemeriksaan').textbox('readonly', true);
		$('#caraPemeriksaan').textbox('readonly', false);
		$('#petunjukPemeriksaan').textbox('readonly', false);
		$('#namaFileTemplateKKP').textbox('readonly', false);
		$('#fileTemplateKKP').textbox('readonly', false);
		$('#tkResikoAsptekTerperiksa').textbox('readonly', false);
		$('#kriteria').textbox('readonly', false);
		$('#kodeJenisPemeriksaan').textbox('readonly', true);
		$('#btnSave').linkbutton('enable');
		$("#buttonCari").removeAttr("disabled"); 
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#kodeAspekPemeriksaan').textbox('readonly', true);
		$('#kodePemeriksaan').textbox('readonly', true);
		$('#caraPemeriksaan').textbox('readonly', false);
		$('#petunjukPemeriksaan').textbox('readonly', false);
		$('#namaFileTemplateKKP').textbox('readonly', false);
		$('#fileTemplateKKP').textbox('readonly', false);
		$('#tkResikoAsptekTerperiksa').textbox('readonly', false);
		$('#kriteria').textbox('readonly', false);
		$('#kodeJenisPemeriksaan').textbox('readonly', true);
		$("#buttonCari").attr("disabled", "disabled"); 
		$('#btnSave').linkbutton('enable');
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'pasEaProsedurPemeriksaanReport.htm?'
				+ 'KodeAspekPemeriksaan=' + $('#KodeAspekPemeriksaan').val()
				+ "&" + 'KodePemeriksaan=' + $('#KodePemeriksaan').val() + "&"
				+ "userId=" + "${userId}";
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
