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
<%@ include file="/util/include.jsp"%>
<title>User</title>
</head>
<body>


	<!-- **********************TABLE RESULT************************************** -->
	<table id="detDg" title="PASRADETAILRKAP" class="easyui-datagrid"
		style="width: 100%;" toolbar="#detToolbar" pagination="false"
		data-options="total:2000,pageSize:10" rownumbers="true"
		fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="kodeMataAnggaran" width="100" sortable="true"><%=properties.getProperty("pasRaDetailRKAP.KodeMataAnggaran")%></th>
				<th field="namaMataAnggaran" width="100" sortable="true"><%=properties.getProperty("pasRaDetailRKAP.NamaMataAnggaran")%></th>
				<th field="nominalMataAnggaran" width="100" sortable="true"
					data-options="formatter:function(value, row){return accounting.formatNumber(row.nominalMataAnggaran,0,'.',','); }"
					align="right"><%=properties.getProperty("pasRaDetailRKAP.NominalMataAnggaran")%></th>
				<th field="kodeRKAP" width="100" sortable="true"><%=properties.getProperty("pasRaDetailRKAP.KodeRKAP")%></th>

			</tr>
		</thead>
	</table>
	<div id="detToolbar">
		<table width="100%">
        	<tr>
        	<td align="left">        	
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="detDoAdd()" id="detbtnAdd" ><%= properties.getProperty("button.add") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="detDoEdit()" id="detbtnEdit"><%= properties.getProperty("button.edit") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="detDoDelete()" id="detbtnDelete"><%= properties.getProperty("button.delete") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="detDoShow()" id="detbtnShow"><%= properties.getProperty("button.show") %></a>
        	</td>
		<td align="right">
			<!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-authorize" plain="true" onclick="" id="btnAdd" ><%=properties.getProperty("button.otorize") %></a>
        	 -->
		</td>
		</tr>
		</table>
	</div>

	<!-- ************************** END LIST/TABLE ******************************************** -->


	<!-- ************************** FORM ******************************************** -->
	<div id="detDlg" class="easyui-dialog"
		style="width: 750px; padding: 10px 20px" closed="true"
		buttons="#detDlg-buttons" data-options="modal:true">
		<div class="ftitle">PASRADETAILRKAP</div>
		<form id="detFm" method="post" novalidate>
			<table align="center">
			<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaDetailRKAP.KodeRKAP")%></label>
							:<input name="kodeRKAP" class="easyui-textbox" id="detKodeRKAP">
							
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaDetailRKAP.KodeMataAnggaran")%></label>
							:<input name="kodeMataAnggaran" class="easyui-textbox"	id="kodeMataAnggaran">
							<a href="javascript:void(0)" class="easyui-linkbutton c6"
							iconCls="icon-search" onclick="searchCOA()" style="width: 90px" id="btnSave">Cari</a>
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaDetailRKAP.NamaMataAnggaran")%></label>
							:<input name="namaMataAnggaran" class="easyui-textbox"
								id="namaMataAnggaran">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaDetailRKAP.NominalMataAnggaran")%></label>
							:<input name="nominalMataAnggaran" class="easyui-numberbox"
								data-options="min:0,precision:0,groupSeparator:','"
								id="nominalMataAnggaran">
						</div></td>
				</tr>
				

			</table>
		</form>
	</div>
	<div id="detDlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="detDoSave()" style="width: 90px" id="btnSave">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#detDlg').dialog('close')"
			style="width: 90px" id="btnCancel">Cancel</a>
	</div>
	<!-- ************************************************END FORM******************* -->
<div id="win2"></div>

<!-- 

</body>
</html>
-->

<script>
var url;
var branchcode;
	$("document").ready(function() {
		detRetrieve();
	});
	

function searchCOA() {
		$('#win2').window(
				{
					width : 800,
					height : 400,
					//href : 'pasRaDetailRKAP.htm?'
					//		+ window.location.search.replace("?", "")+"&kodeRKAP="+row.kodeRKAP+"&statusPembuatan="+row.statusPembuatan,
					modal : true,
					minimizable : false,
					maximizable : false,
					collapsible : false,
					title : 'Pencarian COA'
				});
	}
	
	
	
	
	function test() {
		alert("testtttt..... click");
	}

	function detRetrieve() {		
		var jsonurl = 'pasRaDetailRKAPListAll.htm?'+
'KodeMataAnggaran='+""+"&"+'KodeRKAP='+"${kodeRKAP}"+"&"+"userId="+"${userId}";
		$('#detDg').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total == 0) {
					//alert("Data Tidak Ditemukan.......xxxxx...........");statusPembuatan
				} 
				$("#detbtnAdd").linkbutton("enable");
				$("#detbtnEdit").linkbutton("enable");
				$("#detbtnDelete").linkbutton("enable");
				$("#detbtnShow").linkbutton('enable');
				var x = "${nomorSuratPengajuan}";
				//alert(" x "+x);
				if(x != "undefined"){
					//alert("disini");
					$("#detbtnAdd").linkbutton("disable");
					$("#detbtnEdit").linkbutton("disable");
					$("#detbtnDelete").linkbutton("disable");
					$("#detbtnShow").linkbutton('enable');	
				}
				
			}
		});
	}

	function detDoClear() {
		$('#formCari').form('clear');
		var jsonurl = "listClear.htm";
		$('#detDg').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total > 0) {
					alert("Clear Gagal..................");
				}
			}
		});
	}

	/* END function untuk list data*/
	
	/* ============FORM FUNCTION ========== pasRaDetailRKAPtambah*/

	function detDoAdd() { 
		idRequired(true);
		$('#detDlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#detFm').form('clear');
		url = 'pasRaDetailRKAPAdd.htm?'+"userId="+"${userId}";
		$("#detKodeRKAP").textbox('setValue',"${kodeRKAP}");
		onAdd();
	}
	function detDoEdit() {
		idRequired(false);
		$('#detFm').form('clear');
		var row = $('#detDg').datagrid('getSelected');
		if (row) {
			$('#detDlg').dialog('open').dialog('setTitle', 'Edit');
			$('#detFm').form('clear');
			$('#detFm').form('load', row);
			url = 'pasRaDetailRKAPEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
		}
	}
	function detDoShow() {
		idRequired(false);
		detDoEdit();
		onShow();
		$('#detDlg').dialog('open').dialog('setTitle', 'Tampil');
	}
	
	function detDoDelete() {
		idRequired(false);
		var row = $('#detDg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('pasRaDetailRKAPDelete.htm', {
							                    kodeMataAnggaran : row.kodeMataAnggaran,
                    kodeRKAP : row.kodeRKAP,
							userId:"${userId}"
							}, function(result) {
								if (result.success) {
									$('#detDg').datagrid('reload'); // reload the user data
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

	function detDoSave() {
	idRequired(false);
		$('#detFm').form('submit', {
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
					$('#detDlg').dialog('close'); // close the dialog
					$('#detDg').datagrid('reload'); // reload the user data
					//$('#detDg').datagrid({	url : jsonurl});
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
		$('#kodeMataAnggaran').textbox('readonly', true);
		$('#namaMataAnggaran').textbox('readonly', true);
		$('#nominalMataAnggaran').textbox('readonly', true);
		$('#detKodeRKAP').textbox('readonly', true);
		$('#btnSave').linkbutton('disable');
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#kodeMataAnggaran').textbox('readonly', false);
		$('#namaMataAnggaran').textbox('readonly', false);
		$('#nominalMataAnggaran').textbox('readonly', false);
		$('#detKodeRKAP').textbox('readonly', true);
		$('#btnSave').linkbutton('enable');
		$('#kodeMataAnggaran').textbox('textbox').focus();
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#kodeMataAnggaran').textbox('readonly', true);
		$('#namaMataAnggaran').textbox('readonly', false);
		$('#nominalMataAnggaran').textbox('readonly', false);
		$('#detKodeRKAP').textbox('readonly', true);
		$('#btnSave').linkbutton('enable');
		$('#nominalMataAnggaran').textbox('textbox').focus();
	}
	/*===============================================REPORT==================================
	function doCetak() {
		var repUrl = 'pasRaDetailRKAPReport.htm?' + 'KodeMataAnggaran='
				+ $('#KodeMataAnggaran').val() + "&" + 'KodeRKAP='
				+ $('#KodeRKAP').val() + "&" + "userId=" + "${userId}";
		;
		var s = window.location.search.replace("?", "");
		window
				.open(
						repUrl + "&" + s,
						"_blank",
						"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}
	*/
</script>
<!-- -->
</body>
</html>
 