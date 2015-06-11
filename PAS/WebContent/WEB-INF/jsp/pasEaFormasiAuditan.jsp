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
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaFormasiAuditan.Nama")%></label>
						: <input name="Nama" type="text" id="Nama" size="30"
						maxlength="30"></td>
				
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaFormasiAuditan.KodeTkAuditan")%></label>
						: <input name="KodeTkAuditan" type="text" id="KodeTkAuditan"
						size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasEaFormasiAuditan.KodeAuditan")%></label>
						: <input name="KodeAuditan" type="text" id="KodeAuditan" size="30"
						maxlength="30"></td>
				
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasEaFormasiAuditan.KodeFormasiAuditan")%></label>
						: <input name="KodeFormasiAuditan" type="text"
						id="KodeFormasiAuditan" size="30" maxlength="30"></td>
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
        <table id="dg" title="PASEAFORMASIAUDITAN" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="jabatan" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.Jabatan")%></th> 
                    <th field="grade" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.Grade")%></th> 
                    <th field="nik" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.Nik")%></th> 
                    <th field="nama" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.Nama")%></th> 
                    <th field="kodeTkAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.KodeTkAuditan")%></th> 
                    <th field="kodeAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.KodeAuditan")%></th> 
                    <th field="kodeFormasiAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaFormasiAuditan.KodeFormasiAuditan")%></th> 
                     
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
		<div class="ftitle">PASEAFORMASIAUDITAN</div>
		<form id="fm" method="post" novalidate>
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaFormasiAuditan.KodeAuditan")%></label>
							:<input name="kodeAuditan" class="easyui-textbox"
								id="kodeAuditan" required="true">
						</div>
					</td>
					<td>
						<input name="cariUnit" value="Cari" type="button" onclick="cariAuditan()" style="width: 35px;">
					</td>
					<td>
						<input name="namaAuditan" class="easyui-textbox"  id="namaAuditan" style="width: 200px;" >
					</td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaFormasiAuditan.KodeTkAuditan")%></label>
							:<input name="kodeTkAuditan" class="easyui-textbox"
								id="kodeTkAuditan" required="true">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasEaFormasiAuditan.KodeFormasiAuditan")%></label>
							:<input name="kodeFormasiAuditan" class="easyui-textbox"
								id="kodeFormasiAuditan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaFormasiAuditan.Jabatan")%></label>
							:<input name="jabatan" class="easyui-textbox" id="jabatan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaFormasiAuditan.Grade")%></label>
							:<input name="grade" class="easyui-textbox" id="grade">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaFormasiAuditan.Nik")%></label>
							:<input name="nik" class="easyui-textbox" id="nik">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasEaFormasiAuditan.Nama")%></label>
							:<input name="nama" class="easyui-textbox" id="nama">
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
		$('#namaAuditan').textbox('readonly', true);
		
		comboEaTkAuditon($('#KodeTkAuditan'),"");//form
		comboEaTkAuditon($('#kodeTkAuditan'),"");//form
		
		comboLookup($('#grade'),"GRADE");
		comboLookup($('#kodeFormasiAuditan'),"FORMASI");
		comboLookup($('#KodeFormasiAuditan'),"FORMASI");
		comboLookup($('#jabatan'),"JABATAN");
	});

	function test() {
		alert("testtttt..... click");
	}

	/*pencarian auditan*/
	
	function cariAuditan() {
			$('#win').window({
		        width:800,		        height:400,
		        href:'pasEaAuditanCari.htm?'+window.location.search.replace("?", ""),
		        modal:true,		        minimizable:false,		        maximizable:false,		        collapsible:false        
		        });
	}
	
	function ambilauditan(s) {
		var row = $('#dg2').datagrid('getSelected');
		$("#kodeAuditan").textbox('setValue', row.kodeAuditan);
		$("#namaAuditan").textbox('setValue', row.namaAuditan);
		comboEaTkAuditon($('#kodeTkAuditan'),row.kodeTkAuditan);
		$('#win').window('close'); 
	}

	
	
	
	
	
	function retrieve() {		
		var jsonurl = 'pasEaFormasiAuditanListAll.htm?'+
'Nama='+$('#Nama').val()+"&"+'KodeTkAuditan='+$('#KodeTkAuditan').combobox('getValue')+"&"+'KodeAuditan='+$('#KodeAuditan').val()+"&"+
'KodeFormasiAuditan='+$('#KodeFormasiAuditan').combobox('getValue')+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== pasEaFormasiAuditantambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasEaFormasiAuditanAdd.htm?'+"userId="+"${userId}";
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
			url = 'pasEaFormasiAuditanEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
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
			url = 'pasEaFormasiAuditanEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
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
							$.post('pasEaFormasiAuditanDelete.htm', {
							                    kodeTkAuditan : row.kodeTkAuditan,
                    kodeAuditan : row.kodeAuditan,
                    kodeFormasiAuditan : row.kodeFormasiAuditan,
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
	/*                $('#kodeTkAuditan').textbox({   required: t});
                    $('#kodeAuditan').textbox({   required: t});
                    $('#kodeFormasiAuditan').textbox({   required: t});


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
		$('#jabatan').textbox('readonly', true);
		$('#grade').textbox('readonly', true);
		$('#nik').textbox('readonly', true);
		$('#nama').textbox('readonly', true);
		$('#kodeTkAuditan').textbox('readonly', true);
		$('#kodeAuditan').textbox('readonly', true);
		$('#kodeFormasiAuditan').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#jabatan').textbox('readonly', false);
		$('#grade').textbox('readonly', false);
		$('#nik').textbox('readonly', false);
		$('#nama').textbox('readonly', false);
		$('#kodeTkAuditan').textbox('readonly', true);
		$('#kodeAuditan').textbox('readonly', false);
		$('#kodeFormasiAuditan').textbox('readonly', false);

		$('#btnSave').linkbutton('enable');
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#jabatan').textbox('readonly', false);
		$('#grade').textbox('readonly', false);
		$('#nik').textbox('readonly', false);
		$('#nama').textbox('readonly', false);
		$('#kodeTkAuditan').textbox('readonly', true);
		$('#kodeAuditan').textbox('readonly', true);
		$('#kodeFormasiAuditan').textbox('readonly', true);

		$('#btnSave').linkbutton('enable');
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'pasEaFormasiAuditanReport.htm?' + 'Nama='
				+ $('#Nama').val() + "&" + 'KodeTkAuditan='
				+ $('#KodeTkAuditan').val() + "&" + 'KodeAuditan='
				+ $('#KodeAuditan').val() + "&" + 'KodeFormasiAuditan='
				+ $('#KodeFormasiAuditan').val() + "&" + "userId="
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
