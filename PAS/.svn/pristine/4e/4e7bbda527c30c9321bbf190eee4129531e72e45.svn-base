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
					<td><label style="width: 150px;"><%=properties.getProperty("kabupaten.KodeProvinsi")%></label>
						: <input name="KodeProvinsi" type="text" id="KodeProvinsi"
						style="width: 400px;"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("kabupaten.KodeKabupaten")%></label>
						: <input name="KodeKabupaten" type="text" id="KodeKabupaten"
						size="30" maxlength="30"></td>
				</tr>
				<tr>
					<td><label style="width: 150px;"><%=properties.getProperty("kabupaten.NamaKabupaten")%></label>
						: <input name="NamaKabupaten" type="text" id="NamaKabupaten"
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
        <table id="dg" title="KABUPATEN" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeProvinsi" width="100"sortable="true"><%=properties.getProperty("kabupaten.KodeProvinsi")%></th> 
                    <th field="kodeKabupaten" width="100"sortable="true"><%=properties.getProperty("kabupaten.KodeKabupaten")%></th> 
                    <th field="namaKabupaten" width="100"sortable="true"><%=properties.getProperty("kabupaten.NamaKabupaten")%></th> 
                     
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
		<div class="ftitle">KABUPATEN</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kabupaten.KodeProvinsi")%></label> :<input style="width: 300px;" name="kodeProvinsi"	class="easyui-textbox" id="kodeProvinsi" required=true></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kabupaten.KodeKabupaten")%></label> :<input name="kodeKabupaten"	class="easyui-textbox" id="kodeKabupaten" required=true></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("kabupaten.NamaKabupaten")%></label> :<input name="namaKabupaten"	class="easyui-textbox" id="namaKabupaten"></div></td></tr>	
			
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
		comboProvinsi($("#kodeProvinsi"));
		comboProvinsi($("#KodeProvinsi"));
	});

	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'kabupatenListAll.htm?'+
'KodeProvinsi='+$('#KodeProvinsi').combobox('getValue')+"&"+'KodeKabupaten='+$('#KodeKabupaten').val()+"&"+'NamaKabupaten='+$('#NamaKabupaten').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== kabupatentambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'kabupatenAdd.htm?'+"userId="+"${userId}";
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
			url = 'kabupatenEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
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
							$.post('kabupatenDelete.htm', {
							                    kodeProvinsi : row.kodeProvinsi,
                    kodeKabupaten : row.kodeKabupaten,
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
	
	
function idRequired(t){
      /* $('#kodeProvinsi').combobox({   required: t});
      $('#kodeKabupaten').combobox({   required: t});*/
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
		                    $('#kodeProvinsi').textbox('readonly', true);
                    $('#kodeKabupaten').textbox('readonly', true);
                    $('#namaKabupaten').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
          $('#kodeProvinsi').textbox('readonly', false);
                $('#kodeKabupaten').textbox('readonly', false);
                $('#namaKabupaten').textbox('readonly', false);
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		            $('#kodeProvinsi').textbox('readonly', true);
                    $('#kodeKabupaten').textbox('readonly', true);
                    $('#namaKabupaten').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'kabupatenReport.htm?'+
					  'KodeProvinsi='+$('#KodeProvinsi').val()+"&"+'KodeKabupaten='+$('#KodeKabupaten').val()+"&"+'NamaKabupaten='+$('#NamaKabupaten').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
