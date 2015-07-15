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
					<td><label style="width: 120px;"><%=properties.getProperty("provinsi.KodeProvinsi")%></label>
						: <input name="KodeProvinsi" type="text" id="KodeProvinsi" required="true"
						size="60" ></td>
				
					<td><label style="width: 120px;"><%=properties.getProperty("kecamatan.KodeKabupaten")%></label>
						: <input name="KodeKabupaten" type="text" id="KodeKabupaten" required="true"
						size="50" ></td>
				</tr>
				<tr>
					<td><label style="width: 120px;"><%=properties.getProperty("kelurahan.KodeKecamatan")%></label>
						: <input name="KodeKecamatan" type="text" id="KodeKecamatan" required="true"
						size="50" ></td>
				
					<td><label style="width: 120px;"><%=properties.getProperty("kelurahan.NamaKelurahan")%></label>
						: <input name="NamaKelurahan" type="text" id="NamaKelurahan"
						size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 120px;"><%=properties.getProperty("kelurahan.IdKelurahan")%></label>
						: <input name="IdKelurahan" type="text" id="IdKelurahan" size="30"
						maxlength="30"></td>
				
					<td><label style="width: 120px;"><%=properties.getProperty("kelurahan.KodePos")%></label>
						: <input name="KodePos" type="text" id="KodePos" size="30"
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
        <table id="dg" title="KELURAHAN" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeKecamatan" width="100"sortable="true"><%=properties.getProperty("kelurahan.KodeKecamatan")%></th> 
                    <th field="namaKelurahan" width="100"sortable="true"><%=properties.getProperty("kelurahan.NamaKelurahan")%></th> 
                    <th field="idKelurahan" width="100"sortable="true"><%=properties.getProperty("kelurahan.IdKelurahan")%></th> 
                    <th field="kodePos" width="100"sortable="true"><%=properties.getProperty("kelurahan.KodePos")%></th> 
                     
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
		<div class="ftitle">KELURAHAN</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
		     		<tr><td><div class="fitem">	<label><%=properties.getProperty("provinsi.KodeProvinsi")%></label> :<input name="kodeProvinsi"	class="easyui-textbox" id="kodeProvinsi" required=true style="width: 300px;"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kecamatan.KodeKabupaten")%></label> :<input name="kodeKabupaten"	class="easyui-textbox" id="kodeKabupaten" required=true style="width: 200px;"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kelurahan.KodeKecamatan")%></label> :<input name="kodeKecamatan"	class="easyui-textbox" id="kodeKecamatan" required=true style="width: 200px;"></div></td></tr>	
                    
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kelurahan.IdKelurahan")%></label> :<input name="idKelurahan"	class="easyui-textbox" id="idKelurahan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kelurahan.NamaKelurahan")%></label> :<input name="namaKelurahan"	class="easyui-textbox" id="namaKelurahan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kelurahan.KodePos")%></label> :<input name="kodePos"	class="easyui-textbox" id="kodePos" required="true"></div></td></tr>	
			
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
		
		//dropdown
		comboProvinsi($("#kodeProvinsi"));//form	
		comboKabupaten($("#kodeKabupaten"));//form
		comboKecamatan($("#kodeKecamatan"));//form
		
		comboKabupaten($("#KodeKabupaten"),'',$("#KodeKecamatan"),'');		
		comboKecamatan($("#KodeKecamatan"));
		comboProvinsiToKabupaten($("#KodeProvinsi"),'',$("#KodeKabupaten"),'',$("#KodeKecamatan"),'');//seacrh
	});

/*kecamatan berdasarkan kabupaten */	
	function comboKecamatan(cmbKab,kecamatan) {
		cmbKab.combobox({
			url : '',//'comboKecamatanByKabupaten.htm?param=',
			valueField : 'id',
			textField : 'text',
				onSelect: function(rec) {
				}
		});
		kecamatan = '';
	}
	
	//dari cmbkabupaten ke cmbkecamatan /kecamatan sesuai dengan kabupaten yang dipilih (click)
	function comboKabupaten(cmbKab,kabupaten,cmbKecamatan ,kecamatan) {
		cmbKab.combobox({
			url : '',//'comboAllBranch.htm?param=' + kabupaten
			valueField : 'id',
			textField : 'text',
			onSelect: function(rec) {
				cmbKecamatan.combobox('clear');
				var z = cmbKab.combobox('getValue');
				Urlkz = 'comboKecamatanByKabupaten.htm?param='+z+'&param2='+kecamatan;//+  
				cmbKecamatan.combobox('reload', Urlkz);
			}
		});
		kabupaten = '';
	}

	
/* dari pilih propinvi, kabupaten menyesuaikan*/
	function comboProvinsiToKabupaten(cmbProvinsi,provinsi,cmbKabupaten,kabupaten,cmbKecamatan ,kecamatan) {
		cmbProvinsi.combobox({
			url : 'comboProvinsi.htm?param=' + provinsi+'&param2='+provinsi,
			valueField : 'id',
			textField : 'text',
			onSelect: function(rec) {
				var z = cmbProvinsi.combobox('getValue');
				//alert(cmbKecamatan);
				cmbKabupaten.combobox('clear');	
				cmbKecamatan.combobox('clear');	
		        Urlk = 'comboKabupatenByProvinsi.htm?param='+z+'&param2='+kabupaten;//+          //"&selected="+unit;//11875
		        cmbKabupaten.combobox('reload', Urlk);
		        Urlk2 = 'comboKecamatanByKabupaten.htm?param='+'&param2='+kecamatan;// kosongkan data pada cmbKecamatan
				cmbKecamatan.combobox('reload', Urlk2);
				}
		});
		//status = '';
	}	
	
	
	
	
	
	
	
	/* ============FORM FUNCTION ========== kelurahantambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'kelurahanAdd.htm?'+"userId="+"${userId}";
		onAdd();
		comboKecamatan($("#kodeKecamatan"));
		comboKabupaten($("#kodeKabupaten"),'',$("#kodeKecamatan"),'');				 
		comboProvinsiToKabupaten($("#kodeProvinsi"),'',$("#kodeKabupaten"),'',$("#kodeKecamatan"),'');//seacrh
		
		
	}
	function doEdit() {
		//isialisasi dulu
		comboKecamatan($("#kodeKecamatan"));
		comboKabupaten($("#kodeKabupaten"),'',$("#kodeKecamatan"),'');				 
		comboProvinsiToKabupaten($("#kodeProvinsi"),'',$("#kodeKabupaten"),'',$("#kodeKecamatan"),'');//seacrh
		
		idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'kelurahanEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			/*ambil data kecamatan */
			var kodeKec,kodeKab;
			$.ajax({
				url:'getKodeKecamatan.htm?param='+row.kodeKecamatan,
				async: false,
				success	: function(result){
					kodeKec = result;
				}
			});
			t = JSON.parse(kodeKec);

			//ambil kabupaten berbasarkan kode kabupaten yang ada di kecamatan
			$.ajax({
				url:'getKodeKabupaten.htm?param='+t.kodeKabupaten,
				async: false,
				success	: function(result){
					kodeKab = result;
				}
			});
			u= JSON.parse(kodeKab);

			comboProvinsiToKabupaten($("#kodeProvinsi"),u.kodeProvinsi,$("#kodeKabupaten"),u.kodeKabupaten,$("#kodeKecamatan"),t.kodeKecamatan);//seacrh
			Urlkab = 'comboKabupatenByProvinsi.htm?param='+u.kodeProvinsi+'&param2='+u.kodeKabupaten;//+ 
			$("#kodeKabupaten").combobox('reload', Urlkab);
			
			UrlKec='comboKecamatanByKabupaten.htm?param='+u.kodeKabupaten+'&param2='+t.kodeKecamatan;
			$("#kodeKecamatan").combobox('reload', UrlKec);
			//alert("kodeKab "+kodeKab);
			onEdit();
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
							$.post('kelurahanDelete.htm', {
		                    		kodeKecamatan : row.kodeKecamatan,
                    				idKelurahan : row.idKelurahan,
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
					$('#dg').datagrid({
						url : jsonurl
					});
				}
			}
		});
	}

	
	
	
	
	
	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'kelurahanListAll.htm?'+
'KodeKecamatan='+$('#KodeKecamatan').combobox('getValue')+"&"+'NamaKelurahan='+$('#NamaKelurahan').val()+"&"+'IdKelurahan='+$('#IdKelurahan').val()+"&"+'KodePos='+$('#KodePos').val()+"&"+"userId="+"${userId}";
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
		
		//clear combobox
		comboProvinsiToKabupaten($("#KodeProvinsi"),"",$("#KodeKabupaten"),"",$("#KodeKecamatan"),"");//seacrh
		Urlkab = 'comboKabupatenByProvinsi.htm?param='+"00"+'&param2='+"0000";//+ 
		$("#KodeKabupaten").combobox('reload', Urlkab);
		
		UrlKec='comboKecamatanByKabupaten.htm?param='+"0000"+'&param2='+"000000";
		$("#KodeKecamatan").combobox('reload', UrlKec);
	}

	/* END function untuk list data*/
		
	
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
		$('#kodeKecamatan').textbox('readonly', true);
		$('#namaKelurahan').textbox('readonly', true);
		$('#idKelurahan').textbox('readonly', true);
		$('#kodePos').textbox('readonly', true);
		$('#btnSave').linkbutton('disable');
	}

	/*inputan readonly atau tidak saat Add*/

	function onAdd() {
		$('#kodeKecamatan').textbox('readonly', false);
		$('#namaKelurahan').textbox('readonly', false);
		$('#idKelurahan').textbox('readonly', false);
		$('#kodePos').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
	}

	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#kodeKecamatan').textbox('readonly', false);
		$('#namaKelurahan').textbox('readonly', false);
		$('#idKelurahan').textbox('readonly', true);
		$('#kodePos').textbox('readonly', false);

		$('#btnSave').linkbutton('enable');
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'kelurahanReport.htm?' + 'KodeKecamatan='
				+ $('#KodeKecamatan').combobox('getValue') + "&"
				+ 'NamaKelurahan=' + $('#NamaKelurahan').val() + "&"
				+ 'IdKelurahan=' + $('#IdKelurahan').val() + "&" + 'KodePos='
				+ $('#KodePos').val() + "&" + "userId=" + "${userId}";
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
