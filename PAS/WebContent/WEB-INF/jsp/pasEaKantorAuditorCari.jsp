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

<!-- **********************TABLE RESULT************************************** -->
        <table id="dg2" title="PECARIAN KANTOR AUDITOR" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar2" pagination="true"  data-options="total:2000,pageSize:10"
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
         <div id="toolbar2">
        	<table width="100%">
        	<tr>
        	<td align="left">        	
        		<label>Kantor Auditor</label><input type="text" name="Nama" id="namaKantor" style="width: 100px;">
        		<label>Kode Kantor </label><input type="text" name="KodeKantor" id="KodeKantor" style="width: 100px;">
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="cari()" id="cariauditanList"><%= properties.getProperty("button.cari") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="ambil()" id="btnAmbil"><%= properties.getProperty("button.ambil") %></a>
        	</td>
        	</tr>
        </table>
        </div>
    
<script type="text/javascript">
function cari(s) {
	var jsonurl = 'pasEaKantorAuditorListAll.htm?'+
	'Status='+/*$('#Status').val()+*/"&"+'Nama='+$('#namaKantor').val()+"&"+
	'KodeTk='/*+$('#KodeTk').combobox('getValue')*/+"&"+
	'KodeKantor='+$('#KodeKantor').val()+"&"+'Provinsi='/*+$('#Provinsi').combobox('getValue')*/+"&"+'KodeParent='+
	/*$('#KodeParent').val()+*/
	"&"+"userId="+"${userId}";
	$('#dg2').datagrid({
		url : jsonurl,
		onLoadSuccess : function(data) {
			if (data.total == 0) {
				alert("Data Tidak Ditemukan..................");
			}
		}
	});
}


</body>
</html>



<script>
var url;
var branchcode;
	$("document").ready(function() {
		//$("#btnAdd").linkbutton('${btnAdd}');
		//$("#btnEdit").linkbutton('${btnEdit}');
		//$("#btnDelete").linkbutton('${btnDelete}');
		//$("#btnShow").linkbutton('${btnShow}');	
		//comboEaTkKantorAuditor($('#kodeTk'));
		//comboEaTkKantorAuditor($('#KodeTk'));
		//comboLookup($('#status'),"STATUS-AUDITAN");
		
		//=====================
		//comboProvinsi($("#provinsi"));//form	
		//comboKabupaten($("#kota"));//form
		
		//comboKabupaten($("#Kota"));
		//comboProvinsiToKabupaten($("#Provinsi"),'',$("#Kota"),'');//seacrh	
	});


	
	
	
	
	
	
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
		$('#dg2').datagrid({
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
		$('#dg2').datagrid({
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
		var row = $('#dg2').datagrid('getSelected');
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
		var row = $('#dg2').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('pasEaKantorAuditorDelete.htm', {
				                    kodeKantor : row.kodeKantor,
									userId:"${userId}"
							}, function(result) {
								if (result.success) {
									$('#dg2').datagrid('reload'); // reload the user data
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
					$('#dg2').datagrid('reload'); // reload the user data
					$('#dg2').datagrid({
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
