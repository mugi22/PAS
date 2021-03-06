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
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaMasterRKAP.KodeRKAP")%></label>
						: <input name="KodeRKAP" type="text" id="KodeRKAP" size="30"
						maxlength="30" class="easyui-textbox" ></td>
				
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaMasterRKAP.TahunRKAP")%></label>
						: <input name="TahunRKAP" type="text" id="TahunRKAP" size="30"
						maxlength="30" class="easyui-textbox" ></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaMasterRKAP.StatusRKAP")%></label>
						: <input name="StatusRKAP" type="text" id="StatusRKAP" size="30"
						maxlength="30" class="easyui-textbox" ></td>
				
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasRaMasterRKAP.KodeKantorAuditorPemilik")%></label>
						: <input name="KodeKantorAuditorPemilik" type="text"
						id="KodeKantorAuditorPemilik" size="30" maxlength="30" class="easyui-textbox" ></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasRaMasterRKAP.StatusPersetujuan")%></label>
						: <input name="StatusPersetujuan" type="text"
						id="StatusPersetujuan" size="30" maxlength="30" class="easyui-textbox" ></td>
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
	<table id="dg" title="pasRaMasterRKAPPengajuan" class="easyui-datagrid"
		style="width: 100%;" toolbar="#toolbar" pagination="true"
		data-options="total:2000,pageSize:10" rownumbers="true"
		fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="kodeRKAP" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.KodeRKAP")%></th>
				<th field="tahunRKAP" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.TahunRKAP")%></th>
				<th field="statusRKAP" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.StatusRKAP")%></th>
				<th field="kodeRKAPYangDirevisi" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.KodeRKAPYangDirevisi")%></th>
				<th field="kodeKantorAuditorPemilik" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.KodeKantorAuditorPemilik")%></th>
				<th field="kodeUserPembuat" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.KodeUserPembuat")%></th>
				<th field="statusPembuatan" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.StatusPembuatan")%></th>
				
				<th field="nomorSuratPengajuan" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.NomorSuratPengajuan")%></th>
				<th field="tanggalSuratPengajuan" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.TanggalSuratPengajuan")%></th>
			<!-- 		
				<th field="kodeUserPreviu" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.KodeUserPreviu")%></th>
				<th field="statusReviu" width="100" sortable="true"><%=properties.getProperty("pasRaMasterRKAP.StatusReviu")%></th>
				<th field="kodeUserPenyetuju" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.KodeUserPenyetuju")%></th>
				<th field="statusPersetujuan" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.StatusPersetujuan")%></th>
				<th field="nomorSuratPersetujuan" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.NomorSuratPersetujuan")%></th>
				<th field="tanggalSuratPersetujuan" width="100" sortable="true"><%=properties
					.getProperty("pasRaMasterRKAP.TanggalSuratPersetujuan")%></th>
				-->
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<%@ include file="/util/toolbar.jsp"%>
		<td align="right">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-authorize" plain="true" onclick="doDetail()" id="btnDetail" >Detail</a>
        	 
		</td>
		</tr>
		</table>
	</div>

	<!-- ************************** END LIST/TABLE ******************************************** -->


	<!-- ************************** FORM ******************************************** -->
	<div id="dlg" class="easyui-dialog"
		style="width: 90%; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">PASRAMASTERRKAP</div>
		<form id="fm" method="post" novalidate>
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.KodeRKAP")%></label>
							:<input name="kodeRKAP" class="easyui-textbox" id="kodeRKAP">
						</div></td>
				
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.TahunRKAP")%></label>
							:<input name="tahunRKAP" class="easyui-textbox" id="tahunRKAP">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.StatusRKAP")%></label>
							:<input name="statusRKAP" class="easyui-textbox" id="statusRKAP">
						</div></td>
				
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.KodeRKAPYangDirevisi")%></label>
							:<input name="kodeRKAPYangDirevisi" class="easyui-textbox"
								id="kodeRKAPYangDirevisi">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.KodeKantorAuditorPemilik")%></label>
							:<input name="kodeKantorAuditorPemilik" class="easyui-textbox"
								id="kodeKantorAuditorPemilik" >
						</div></td>
				
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.KodeUserPembuat")%></label>
							:<input name="kodeUserPembuat" class="easyui-textbox"
								id="kodeUserPembuat">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.StatusPembuatan")%></label>
							:<input name="statusPembuatan" class="easyui-textbox"
								id="statusPembuatan">
						</div></td>
				
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.NomorSuratPengajuan")%></label>
							:<input name="nomorSuratPengajuan" class="easyui-textbox"
								id="nomorSuratPengajuan">
						</div></td>
				</tr>
				
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.TanggalSuratPengajuan")%></label>
							:<input name="tanggalSuratPengajuan" class="easyui-datebox"
								data-options="formatter:myformatter,parser:myparser"
								id="tanggalSuratPengajuan">
						</div></td>
				<!-- 
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.KodeUserPreviu")%></label>
							:<input name="kodeUserPreviu" class="easyui-textbox"
								id="kodeUserPreviu">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaMasterRKAP.StatusReviu")%></label>
							:<input name="statusReviu" class="easyui-textbox"
								id="statusReviu">
						</div></td>
				
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.KodeUserPenyetuju")%></label>
							:<input name="kodeUserPenyetuju" class="easyui-textbox"
								id="kodeUserPenyetuju">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.StatusPersetujuan")%></label>
							:<input name="statusPersetujuan" class="easyui-textbox"
								id="statusPersetujuan">
						</div></td>
				
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.NomorSuratPersetujuan")%></label>
							:<input name="nomorSuratPersetujuan" class="easyui-textbox"
								id="nomorSuratPersetujuan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaMasterRKAP.TanggalSuratPersetujuan")%></label>
							:<input name="tanggalSuratPersetujuan" class="easyui-datebox"
								data-options="formatter:myformatter,parser:myparser"
								id="tanggalSuratPersetujuan">
						</div></td>
				</tr>
				-->
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="doSave()" style="width: 90px" id="btnSave">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px" id="btnCancel">Cancel</a>
	</div>
	<!-- ************************************************END FORM******************* -->

<div id="win"></div>
</body>
</html>



<script>
	var url;
	var branchcode;
	$("document").ready(function() {
		$("#btnAdd").linkbutton('disable');
		$("#btnEdit").linkbutton('${btnEdit}');
		$("#btnDelete").linkbutton('disable');
		$("#btnShow").linkbutton('${btnShow}');
		comboLookup($("#statusPembuatan"),'STATUS_PEMBUATAN_RKAP');
		comboLookup($("#statusReviu"),'STATUS_REVIU_RKAP');
		comboLookup($("#statusPersetujuan"),'STATUS_PERSETUJUAN_RKAP');
		comboLookup($("#statusRKAP"),'STATUS_RKAP');
		$("#kodeKantorAuditorPemilik").textbox('setValue',"${tblUser.branchCode}");
		$("#KodeKantorAuditorPemilik").textbox('setValue',"${tblUser.branchCode}");
		$("#KodeKantorAuditorPemilik").textbox('readonly',true);
		
		
	});

	function doDetail() {
		
		var row = $('#dg').datagrid('getSelected');
		if(row == null){
			$.messager.show({ // show error message
				title : 'Error',
				msg : result.errorMsg + "Row Belum Dipilih "
			});
		}
		$('#win').window(
				{
					width : 800,
					height : 400,
					href : 'pasRaDetailRKAP.htm?'
							+ window.location.search.replace("?", "")+"&kodeRKAP="+row.kodeRKAP+"&statusPembuatan="+row.statusPembuatan,
					modal : true,
					minimizable : false,
					maximizable : false,
					collapsible : false,
					title : 'Detail RKAP'
				});
	}

	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {
		var jsonurl = 'pasRaMasterRKAPPengajuanListAll.htm?' + 'KodeRKAP='
				+ $('#KodeRKAP').val() + "&" + 'TahunRKAP='
				+ $('#TahunRKAP').val() + "&" + 'StatusRKAP='
				+ $('#StatusRKAP').val() + "&" + 'KodeKantorAuditorPemilik='
				+ $('#KodeKantorAuditorPemilik').val() + "&"
				+ 'StatusPersetujuan=' + $('#StatusPersetujuan').val() + "&"
				+ "userId=" + "${userId}";
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
		var z = $("#KodeKantorAuditorPemilik").val();
		
		$('#formCari').form('clear');
		
		var jsonurl = "listClear.htm";
		$('#dg').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total > 0) {
					alert("Clear Gagal..................");
				}
				$("#KodeKantorAuditorPemilik").textbox('setValue',"${tblUser.branchCode}");
			}
		});
		
	}

	/* END function untuk list data*/

	/* ============FORM FUNCTION ========== pasRaMasterRKAPtambah*/

	function doAdd() {
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasRaMasterRKAPAdd.htm?' + "userId=" + "${userId}";
		onAdd();
		$("#kodeKantorAuditorPemilik").textbox('setValue',"${tblUser.branchCode}");
		$("#kodeUserPembuat").textbox('setValue',"${tblUser.userId}");
		$('#kodeRKAP').textbox('readonly', false);
		$('#kodeRKAP').textbox('textbox').focus();
		$('#kodeRKAP').textbox('readonly', false);
		
		//
	}
	function doEdit() {
		//idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasRaMasterRKAPPengajuanEdit.htm?' + "userId=" + "${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			//if(row.statusRKAP == 'A' ||row.statusPembuatan =='SS'){
			//	onShow();
			//}else{
			//	onEdit();
			//}
			$('#kodeRKAP').textbox('readonly', true);
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
		//if(row.statusRKAP == 'A' ||row.statusPembuatan =='SS'){
		//	alert("Status RKAP "+row.statusRKAP+" atau "+"Status Pembuatan "+row.statusPembuatan);
		//	return;
		//}
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('pasRaMasterRKAPDelete.htm', {
								kodeRKAP : row.kodeRKAP,
								userId : "${userId}"
							}, function(result) {
								if (result.success == true) {
									$('#dg').datagrid('reload'); // reload the user data
								} else {
									alert(result.success);
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
		if($("#statusPembuatan").combobox("getValue") != "SS"){
			alert("RKAP Belum Selesai");
			return;
		}
		
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
				$('#kodeRKAP').textbox('readonly', false);
			}
		});
	}

	function idRequired(t) {
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
		$('#kodeRKAP').textbox('readonly', true);
		$('#tahunRKAP').textbox('readonly', true);
		$('#statusRKAP').textbox('readonly', true);
		$('#kodeRKAPYangDirevisi').textbox('readonly', true);
		$('#kodeKantorAuditorPemilik').textbox('readonly', true);
		$('#kodeUserPembuat').textbox('readonly', true);
		$('#statusPembuatan').textbox('readonly', true);
		$('#nomorSuratPengajuan').textbox('readonly', true);
		$('#tanggalSuratPengajuan').textbox('readonly', true);
		$('#kodeUserPreviu').textbox('readonly', true);
		$('#statusReviu').textbox('readonly', true);
		$('#kodeUserPenyetuju').textbox('readonly', true);
		$('#statusPersetujuan').textbox('readonly', true);
		$('#nomorSuratPersetujuan').textbox('readonly', true);
		$('#tanggalSuratPersetujuan').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#kodeRKAP').textbox('readonly', true);
		//$('#kodeRKAP').textbox('clear').textbox('textbox').focus();
		
		$('#tahunRKAP').textbox('readonly', true);
		$('#statusRKAP').textbox('readonly', true);
		$('#kodeRKAPYangDirevisi').textbox('readonly', true);
		$('#kodeKantorAuditorPemilik').textbox('readonly', true);
		$('#kodeUserPembuat').textbox('readonly', true);
		$('#statusPembuatan').textbox('readonly', true);
		$('#nomorSuratPengajuan').textbox('readonly', false);
		$('#tanggalSuratPengajuan').textbox('readonly', flase);
		$('#kodeUserPreviu').textbox('readonly', true);
		$('#statusReviu').textbox('readonly', true);
		$('#kodeUserPenyetuju').textbox('readonly', true);
		$('#statusPersetujuan').textbox('readonly', true);
		$('#nomorSuratPersetujuan').textbox('readonly', true);
		$('#tanggalSuratPersetujuan').textbox('readonly', true);

		$('#btnSave').linkbutton('enable');
	
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#kodeRKAP').textbox('readonly', true);
		$('#tahunRKAP').textbox('readonly', true);
		$('#statusRKAP').textbox('readonly', true);
		$('#kodeRKAPYangDirevisi').textbox('readonly', true);
		$('#kodeKantorAuditorPemilik').textbox('readonly', true);
		$('#kodeUserPembuat').textbox('readonly', true);
		$('#statusPembuatan').textbox('readonly', false);
		$('#nomorSuratPengajuan').textbox('readonly', false);
		$('#tanggalSuratPengajuan').textbox('readonly', false);
		$('#kodeUserPreviu').textbox('readonly', true);
		$('#statusReviu').textbox('readonly', true);
		$('#kodeUserPenyetuju').textbox('readonly', true);
		$('#statusPersetujuan').textbox('readonly', true);
		$('#nomorSuratPersetujuan').textbox('readonly', true);
		$('#tanggalSuratPersetujuan').textbox('readonly', true);

		$('#btnSave').linkbutton('enable');
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'pasRaMasterRKAPReport.htm?' + 'KodeRKAP='
				+ $('#KodeRKAP').val() + "&" + 'TahunRKAP='
				+ $('#TahunRKAP').val() + "&" + 'StatusRKAP='
				+ $('#StatusRKAP').val() + "&" + 'KodeKantorAuditorPemilik='
				+ $('#KodeKantorAuditorPemilik').val() + "&"
				+ 'StatusPersetujuan=' + $('#StatusPersetujuan').val() + "&"
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
