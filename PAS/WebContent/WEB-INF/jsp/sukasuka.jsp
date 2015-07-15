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
<td><label style="width: 150px;"><%=properties.getProperty("sukasuka.SukaSukaID")%></label> : <input name="SukaSukaID" type="text" id="SukaSukaID" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("sukasuka.SukaName")%></label> : <input name="SukaName" type="text" id="SukaName" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("sukasuka.SukaTgl")%></label> : <input name="SukaTgl" type="text" id="SukaTgl" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("sukasuka.SukaGaji")%></label> : <input name="SukaGaji" type="text" id="SukaGaji" size="30" maxlength="30"></td>
</tr>
                    <tr>
<td><label style="width: 150px;"><%=properties.getProperty("sukasuka.SukaJmlx")%></label> : <input name="SukaJmlx" type="text" id="SukaJmlx" size="30" maxlength="30"></td>
</tr>

				 <tr>
	            	<td colspan="1">
	                <div id="btn">     
	                    <%@ include file="/util/searchButton.jsp" %>
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
        <table id="dg" title="SUKASUKA" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="sukaSukaID" width="100"sortable="true"><%=properties.getProperty("sukasuka.SukaSukaID")%></th> 
                    <th field="sukaName" width="100"sortable="true"><%=properties.getProperty("sukasuka.SukaName")%></th> 
                    <th field="sukaTgl" width="100"sortable="true"><%=properties.getProperty("sukasuka.SukaTgl")%></th> 
                    <th field="sukaGaji" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.sukaGaji,0,'.',','); }"align="right"><%=properties.getProperty("sukasuka.SukaGaji")%></th> 
                    <th field="sukaJmlx" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.sukaJmlx,0,'.',','); }"align="right"><%=properties.getProperty("sukasuka.SukaJmlx")%></th> 
                     
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
		<div class="ftitle">SUKASUKA</div>
		<form id="fm" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("sukasuka.SukaSukaID")%></label> :<input name="sukaSukaID"	class="easyui-textbox" id="sukaSukaID"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("sukasuka.SukaName")%></label> :<input name="sukaName"	class="easyui-textbox" id="sukaName"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("sukasuka.SukaTgl")%></label> :<input name="sukaTgl"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="sukaTgl"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("sukasuka.SukaGaji")%></label> :<input name="sukaGaji"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="sukaGaji"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("sukasuka.SukaJmlx")%></label> :<input name="sukaJmlx"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="sukaJmlx"></div></td></tr>	
			
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
	});

	function test() {
		alert("testtttt..... click");
	}

	function retrieve() {		
		var jsonurl = 'sukasukaListAll.htm?'+
'SukaSukaID='+$('#SukaSukaID').val()+"&"+'SukaName='+$('#SukaName').val()+"&"+'SukaTgl='+$('#SukaTgl').val()+"&"+'SukaGaji='+$('#SukaGaji').val()+"&"+'SukaJmlx='+$('#SukaJmlx').val()+"&"+"userId="+"${userId}";
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
	
	/* ============FORM FUNCTION ========== sukasukatambah*/

	function doAdd() { 
		idRequired(true);
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'sukasukaAdd.htm?'+"userId="+"${userId}";
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
			url = 'sukasukaEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
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
			url = 'sukasukaEdit.htm?'+"userId="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
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
							$.post('sukasukaDelete.htm', {
							                    sukaSukaID : row.sukaSukaID,
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
/*
                    $('#sukaSukaID').textbox({   required: t});

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
		                    $('#sukaSukaID').textbox('readonly', true);
                    $('#sukaName').textbox('readonly', true);
                    $('#sukaTgl').textbox('readonly', true);
                    $('#sukaGaji').textbox('readonly', true);
                    $('#sukaJmlx').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}
	
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		                    $('#sukaSukaID').textbox('readonly', false);
                    $('#sukaName').textbox('readonly', false);
                    $('#sukaTgl').textbox('readonly', false);
                    $('#sukaGaji').textbox('readonly', false);
                    $('#sukaJmlx').textbox('readonly', false);
		
		$('#btnSave').linkbutton('enable');
	}
	
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		                    $('#sukaSukaID').textbox('readonly', true);
                    $('#sukaName').textbox('readonly', false);
                    $('#sukaTgl').textbox('readonly', false);
                    $('#sukaGaji').textbox('readonly', false);
                    $('#sukaJmlx').textbox('readonly', false);
	
		$('#btnSave').linkbutton('enable');
	}
/*===============================================REPORT==================================*/
function doCetak(){
		var repUrl = 'sukasukaReport.htm?'+
					  'SukaSukaID='+$('#SukaSukaID').val()+"&"+'SukaName='+$('#SukaName').val()+"&"+'SukaTgl='+$('#SukaTgl').val()+"&"+'SukaGaji='+$('#SukaGaji').val()+"&"+'SukaJmlx='+$('#SukaJmlx').val()+"&"+"userId="+"${userId}";;
		var s = window.location.search.replace("?", "");
		window.open(repUrl+"&"+s,
				"_blank", 
				"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}

	
</script>
