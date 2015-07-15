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
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaKegiatanPKPT.NamaKegiatan")%></label>
						: <input name="NamaKegiatan" type="text" id="NamaKegiatan"	class="easyui-textbox" size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaKegiatanPKPT.KodePKPT")%></label>
						: <input name="KodePKPT" type="text" id="KodePKPT"	class="easyui-textbox" size="30" maxlength="30"></td>
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
        <table id="dgPKPT" title="PASRAKEGIATANPKPT" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeUserPembuat" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KodeUserPembuat")%></th> 
                    <th field="tanggalAwal" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAwal")%></th> 
                    <th field="tanggalAkhir" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAkhir")%></th> 
                    <th field="namaKegiatan" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.NamaKegiatan")%></th> 
                    <th field="keteranganKegiatan" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KeteranganKegiatan")%></th> 
                    <th field="jenisTransportasi" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.JenisTransportasi")%></th> 
                    <th field="biayaTransportasi" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaTransportasi,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanPKPT.BiayaTransportasi")%></th> 
                    <th field="biayaLumpsum" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaLumpsum,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanPKPT.BiayaLumpsum")%></th> 
                    <th field="kodeKegiatanPKPT" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KodeKegiatanPKPT")%></th> 
                    <th field="biayaMobilDinas" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaMobilDinas,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanPKPT.BiayaMobilDinas")%></th> 
                    <th field="kodePKPT" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KodePKPT")%></th> 
                    <th field="statusInap" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.StatusInap")%></th> 
                     
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
	<div id="dlgPKPT" class="easyui-dialog"	style="width: 750px;  padding: 10px 20px" closed="true"	buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">PASRAKEGIATANPKPT</div>
		<form id="fmPKPT" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.KodeUserPembuat")%></label> :<input name="kodeUserPembuat"	class="easyui-textbox" id="kodeUserPembuat"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAwal")%></label> :<input name="tanggalAwal"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="tanggalAwal"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAkhir")%></label> :<input name="tanggalAkhir"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="tanggalAkhir"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.NamaKegiatan")%></label> :<input name="namaKegiatan"	class="easyui-textbox" id="namaKegiatan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.KeteranganKegiatan")%></label> :<input name="keteranganKegiatan"	class="easyui-textbox" id="keteranganKegiatan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.JenisTransportasi")%></label> :<input name="jenisTransportasi"	class="easyui-textbox" id="jenisTransportasi"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.BiayaTransportasi")%></label> :<input name="biayaTransportasi"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="biayaTransportasi"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.BiayaLumpsum")%></label> :<input name="biayaLumpsum"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="biayaLumpsum"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.KodeKegiatanPKPT")%></label> :<input name="kodeKegiatanPKPT"	class="easyui-textbox" id="kodeKegiatanPKPT"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.BiayaMobilDinas")%></label> :<input name="biayaMobilDinas"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="biayaMobilDinas"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.KodePKPT")%></label> :<input name="kodePKPT"	class="easyui-textbox" id="kodePKPT"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanPKPT.StatusInap")%></label> :<input name="statusInap"	class="easyui-textbox" id="statusInap"></div></td></tr>	
			
		</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="doSave()" style="width: 90px" id="btnSave">Save</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" 	iconCls="icon-cancel" onclick="javascript:$('#dlgPKPT').dialog('close')"style="width: 90px" id="btnCancel">Cancel</a>
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
		var jsonurl = 'pasRaKegiatanPKPTListByMonth.htm?'+
'NamaKegiatan='+$('#NamaKegiatan').val()+"&"+'KodePKPT='+$('#KodePKPT').val()+"&"+"userId="+"${userId}";
		$('#dgPKPT').datagrid({
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
		$('#dgPKPT').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total > 0) {
					alert("Clear Gagal..................");
				}
			}
		});
	}

	/* END function untuk list data*/
	
	/* ============FORM FUNCTION ========== pasRaKegiatanPKPTtambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlgPKPT').dialog('open').dialog('setTitle', 'Tambah');
		$('#fmPKPT').form('clear');
		url = 'pasRaKegiatanPKPTAdd.htm?'+"userId="+"${userId}";
		onAdd();
	}
	function doEdit() {
		idRequired(false);
		$('#fmPKPT').form('clear');
		var row = $('#dgPKPT').datagrid('getSelected');
		if (row) {
			$('#dlgPKPT').dialog('open').dialog('setTitle', 'Edit');
			$('#fmPKPT').form('clear');
			$('#fmPKPT').form('load', row);
			url = 'pasRaKegiatanPKPTEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
		}
	}
	function doShow() {
		idRequired(false);
		doEdit();
		onShow();
		$('#dlgPKPT').dialog('open').dialog('setTitle', 'Tampil');
	/*
		$('#fmPKPT').form('clear');
		var row = $('#dgPKPT').datagrid('getSelected');		
		if (row) {
			$('#dlgPKPT').dialog('open').dialog('setTitle', 'Tampil');
			$('#fmPKPT').form('clear');
			$('#fmPKPT').form('load', row);
			url = 'pasRaKegiatanPKPTEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
			onShow();
		}
		*/
	}
	
	function doDelete() {
		idRequired(false);
		var row = $('#dgPKPT').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('pasRaKegiatanPKPTDelete.htm', {
							                    kodeKegiatanPKPT : row.kodeKegiatanPKPT,
                    kodePKPT : row.kodePKPT,
							userId:"${userId}"
							}, function(result) {
								if (result.success) {
									$('#dgPKPT').datagrid('reload'); // reload the user data
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
		$('#fmPKPT').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
			var x = JSON.parse(result);
				if(successCode == 0){
					alertError("Simpan Gagal <br>"+x.message);
				}else{
					alertAll('Simpan Sukses');
					$('#dlgPKPT').dialog('close'); // close the dialog
					$('#dgPKPT').datagrid('reload'); // reload the user data
				}
			
			/*
				var resultx = eval('(' + result + ')');
				if (resultx === 'fail' || result === null) {	alertError("Simpan Gagal");					
				} else {	alertAll('Simpan Sukses');
					$('#dlgPKPT').dialog('close'); // close the dialog
					$('#dgPKPT').datagrid('reload'); // reload the user data
				}
				*/
			}
		});
	}
	
	
function idRequired(t){
/*
                    $('#kodeKegiatanPKPT').textbox({   required: t});
                    $('#kodePKPT').textbox({   required: t});

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
		                    $('#kodeUserPembuat').textbox('readonly', true);
                    $('#tanggalAwal').textbox('readonly', true);
                    $('#tanggalAkhir').textbox('readonly', true);
                    $('#namaKegiatan').textbox('readonly', true);
                    $('#keteranganKegiatan').textbox('readonly', true);
                    $('#jenisTransportasi').textbox('readonly', true);
                    $('#biayaTransportasi').textbox('readonly', true);
                    $('#biayaLumpsum').textbox('readonly', true);
                    $('#kodeKegiatanPKPT').textbox('readonly', true);
                    $('#biayaMobilDinas').textbox('readonly', true);
                    $('#kodePKPT').textbox('readonly', true);
                    $('#statusInap').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		                    $('#kodeUserPembuat').textbox('readonly', false);
                    $('#tanggalAwal').textbox('readonly', false);
                    $('#tanggalAkhir').textbox('readonly', false);
                    $('#namaKegiatan').textbox('readonly', false);
                    $('#keteranganKegiatan').textbox('readonly', false);
                    $('#jenisTransportasi').textbox('readonly', false);
                    $('#biayaTransportasi').textbox('readonly', false);
                    $('#biayaLumpsum').textbox('readonly', false);
                    $('#kodeKegiatanPKPT').textbox('readonly', false);
                    $('#biayaMobilDinas').textbox('readonly', false);
                    $('#kodePKPT').textbox('readonly', false);
                    $('#statusInap').textbox('readonly', false);
		
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#kodeUserPembuat').textbox('readonly', false);
                    $('#tanggalAwal').textbox('readonly', false);
                    $('#tanggalAkhir').textbox('readonly', false);
                    $('#namaKegiatan').textbox('readonly', false);
                    $('#keteranganKegiatan').textbox('readonly', false);
                    $('#jenisTransportasi').textbox('readonly', false);
                    $('#biayaTransportasi').textbox('readonly', false);
                    $('#biayaLumpsum').textbox('readonly', false);
                    $('#kodeKegiatanPKPT').textbox('readonly', true);
                    $('#biayaMobilDinas').textbox('readonly', false);
                    $('#kodePKPT').textbox('readonly', true);
                    $('#statusInap').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'pasRaKegiatanPKPTReport.htm?'+
					  'NamaKegiatan='+$('#NamaKegiatan').val()+"&"+'KodePKPT='+$('#KodePKPT').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
