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
                <label>User Id</label> : 
                <input name="userId" type="text" id="userIdSearch" size="30" maxlength="30"><br>
				<label>Unit</label> : 
                <input name="unitId" type="text" id="unitId" size="30" maxlength="30"><br>
                <div id="btn">     
                    <%@ include file="/util/searchButton.jsp" %>    
                </div>
            </form> 
            <div id="result"></div>
        </div>
        <hr>
<!-- ******************************END  FORM PENCARIAN******************************* -->  

<!-- **********************TABLE RESULT************************************** -->
        <table id="dg" title="Daftar User" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar" pagination="true"
               data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="userId" width="100" sortable="true">User ID</th> 
                    <th field="name" width="250" sortable="true">Nama</th>
                    <th field="branchCode" width="100" sortable="true">Kode Unit</th> 
                    <th field="createBy" width="100" sortable="true">Di Buat</th> 
                    <th field="createDate" width="100" sortable="true">Tgl Buat</th>
                    <th field="updateBy" width="100" sortable="true">Di Ubah</th> 
                    <th field="updateDate" width="100" sortable="true">Tgl Ubah</th>
                    <th field="endTime" width="100" sortable="true">endTime</th>
                </tr>
            </thead>
        </table>        
                 
        <div id="toolbar">
        <%@ include file="/util/toolbar.jsp" %>          
        	<td align="right">
        	<!-- 
        		 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-authorize" plain="true" onclick="" id="btnAdd" ><%=properties.getProperty("button.otorize")  %></a>
        	-->
        	</td>
        	</tr>
        </table>
        </div>
 <!-- ************************** END LIST/TABLE ******************************************** -->       
    
          
<!-- ************************** FORM ******************************************** -->
	<div id="dlg" class="easyui-dialog"	style="width: 750px;  padding: 10px 20px" closed="true"	buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>User ID</label> :<input name="userId"	class="easyui-textbox" required="true" id="userId">
				<input type="button" name="btnKirim" id="btnCariUser" value="Cari" onclick="cariUser()"> 
			</div>
			<div class="fitem">
				<label>Nama User</label> :<input name="name" class="easyui-textbox" required="true"  id="namax">	
							
			</div>
			
			<div class="fitem">
				<label>Password</label> :<input type="password" name="password" class="easyui-textbox" required="true" id="password">
			</div>			
			<div class="fitem">
				<!-- label>Kode Kanwil</label> :<input id="branchCodeKanwil" name="branchCodeKanwil" value="aa" style="width: 300px;"-->
				<div class="fitem">	<label>Tingkat</label> :<input name="kodeTk"	class="easyui-textbox" id="kodeTk"></div>
           
			</div>
			<div class="fitem">
				<label>Kode Cabang</label> :<input id="branchCodeAll" name="branchCodeAll" value="aa" style="width: 300px;">
			</div>
			
			<div class="fitem">
				<label>Email</label> :<input name="email" class="easyui-textbox" validType="email" id="email">
			</div>
			
			<div class="fitem">
				<label>Start Time</label> :<input class="easyui-datebox" name="startTime" id="startTime" 
				data-options="formatter:myformatter,parser:myparser"/>
			</div>
			<div class="fitem">
				<label>End Time  </label> :<input name="endTime" class="easyui-datebox" id="endTime" data-options="formatter:myformatter,parser:myparser"/>
			</div>
			<div class="fitem">
				<label>Status</label> :<select class="easyui-combobox" name="enabled" id="enabled" style="width:60px;" data-options="panelHeight:'auto'">
							<option value="Y">Ya</option>
							<option value="N">Tidak</option>
				</select>
			</div>			
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
//window pencarian
/*function cariUser() {
	//alert("testtttt..... click");
	$('#win').window({
        width:600,
        height:400,
        href:'cariUser.htm',
        modal:true,
        minimizable:false,
        maximizable:false,
        collapsible:false
        
        });
    //$('#cari').show();
}
*/

var url;
var branchcode;
$("document").ready(function() {
	$("#btnAdd").linkbutton('${btnAdd}');
	$("#btnEdit").linkbutton('${btnEdit}');
	$("#btnDelete").linkbutton('${btnDelete}');
	$("#btnShow").linkbutton('${btnShow}');
	$('#cari').hide();
	$('#cc').layout('panel', 'west').panel('tittle', 'abc');
	comboEaTkKantorAuditor($('#kodeTk'));
	comboEaKantorAuditor($('#branchCodeAll'));
});
//comboPasEaKantorAuditorByTk //getPasEaKantorAuditor
/*pindah my.js
function comboEaKantorAuditor(cmbKantorAuditor,kantorAuditorSelected) {
	cmbKantorAuditor.combobox({
		url :'comboPasEaKantorAuditorByTk.htm?param='+'&param2='+kantorAuditorSelected,
		valueField : 'id',
		textField : 'text',
		panelHeight:'auto',
		onSelect: function(rec) {
		}
	});
}
*/

/*
pindah ke my.js
function comboEaTkKantorAuditor(cmbTk,tkSelected,cmbKantorAuditor,kantorAuditorSelected) {
	cmbTk.combobox({
		url :'comboEaTkKantorAuditor.htm?param2='+tkSelected+'&param=',
		valueField : 'id',
		textField : 'text',
		panelHeight:'auto',
		onSelect: function(rec) {
			//alert(cmbTk.combobox('getValue'));
			cmbKantorAuditor.combobox('clear');
			urlz ='comboPasEaKantorAuditorByTk.htm?param='+cmbTk.combobox('getValue')+'&param2='+kantorAuditorSelected;
			cmbKantorAuditor.combobox('reload',urlz);
		}
	});
}

*/

function doEdit() {
	var t;
	$('#fm').form('clear');
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
		$('#fm').form('clear');
		$('#fm').form('load', row);
		url = 'userEdit.htm?'+"userID="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
		upperCase($('#namax'));
		branchcode = row.branchCode;			
		
		comboEaTkKantorAuditor($('#kodeTk'));
		comboEaKantorAuditor($('#branchCodeAll'));
	//ambil kantorauditor berdasarkan kodekantor pada table user getPasEaKantorAuditor
		var t;
		$.ajax({
			url:'getPasEaKantorAuditor.htm?param='+branchcode,//cari kode parent nya
			async: true,
			success	: function(result){
				t = JSON.parse(result);
				//alert("t.kodeTk "+t.kodeTk+" branchcode"+branchcode);
				$('#kodeTk').combobox('clear');
				comboEaTkKantorAuditor($('#kodeTk'),t.kodeTk,$('#branchCodeAll'),branchcode);//cmbTk,tkSelected,cmbKantorAuditor,kantorAuditorSelected
				urlx= 'comboEaTkKantorAuditor.htm?param='+t.kodeTk+'&param2=';
				$('#kodeTk').combobox('reload',urlx);
				
				$('#branchCodeAll').combobox('clear');
				urlz ='comboPasEaKantorAuditorByTk.htm?param='+t.kodeTk+'&param2='+branchcode;
				$('#branchCodeAll').combobox('reload',urlz);
			}
		});
		onEdit();
	}
}








function doAdd() {
	$('#dlg').dialog('open').dialog('setTitle', 'Tambah User');
	$('#fm').form('clear');
	url = 'userAdd.htm?'+"userID="+"${userId}";
	upperCase($('#namax'));
	upperCase($('#userId'));
	branchcode = ''; //combobox tidak ada default
	comboEaKantorAuditor($('#branchCodeAll'),'');
	comboEaTkKantorAuditor($('#kodeTk'),'',$('#branchCodeAll'),'');
	
	onAdd();
}







function doAmbil(){ //ambil key dari row yang dipilih/klik
	var row = $('#dg2').datagrid('getSelected');
	//alert(row.userId);
	$('#userId').textbox('setValue',row.userId);
	$('#win').window('close'); 
}
	
	/* function untuk list data*/
	function retrieve() {
		var jsonurl = 'userListAll.htm?param=' + $('#userIdSearch').val()+"&"+"userID="+"${userId}"+'&'+"unitId="+$('#unitId').val();
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

	/* ============FORM FUNCTION ==========*/

	
	

	function addComboBranch(branchcode) {
		$('#branchCodeAll').combobox({
			url : 'comboAllBranch.htm?param=' + branchcode,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});
		branchcode = '';
	}
	


function addComboKanwil(selectedValue,unit) {
	$('#branchCodeKanwil').combobox({
		url : 'comboAllKanwil.htm?param=' + selectedValue,
		valueField : 'id',
		textField : 'text',
		panelHeight:'auto',
		onSelect: function(rec) {	
            /*alert('kode kanwil   --->'+$('#branchCodeKanwil').combobox('getValue')+"unit  "+unit);*/
			$('#branchCodeAll').combobox('clear');
		     urlk = 'comboAllBranch.htm?param='+$('#branchCodeKanwil').combobox('getValue')+"&selected="+unit;//11875
	         $('#branchCodeAll').combobox('reload', urlk);
			}
		});
	selectedValue = '';
}

	
/*
 * 
function addComboByParent(parent) {	
	$('#branchCodeKanwil').combobox({
		url : 'comboAllBranch.htm?param=' + parent,
		valueField : 'id',
		textField : 'text',
		panelHeight:'auto',
		 onSelect: function(rec) {			
			 $('#branchCodeAll').combobox('clear');
			 var urlk = 'comboAllBranch.htm?param='+rec.id;
	            $('#branchCodeAll').combobox('reload', urlk);			
		}
	});
	branchcode = '';
}	
	
 */	
	
	
	
	
	
	
	
	
	
	
	function doShow() {
		/*$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'userEdit.htm?'+"userID="+"${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten;
			upperCase($('#namax'));
	
			onShow();
		}*/
		doEdit();
		onShow();
	}

	function doDelete() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('userDelete.htm', {
								userId : row.userId,
								userID:"${userId}"
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
		$('#fm').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var resultx = eval('(' + result + ')');
				if (resultx === 'fail' || result === null) {
					alert("Simpan Gagal");
					$.messager.show({
						title : 'Error',
						msg : "Simpan Gagal"
					});
				} else {
					alert("Simpan Sukses ");
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
					//var kd = $('#kode').val();
					//$('#kodeProvinsi').val(kd);
					//                        var jsonurl =  'provinsiAjax.htm?param='+$('#kodeProvinsi').val();
					$('#dg').datagrid({
						url : jsonurl
					});
				}
			}
		});
	}

	/*inputan readonly atau tidak saat onShow */
	function onShow() {
		//list button
		$('#btnCariUser').hide();
		$('#userId').textbox('readonly', true);
		$('#namax').textbox('readonly', true);
		$('#password').textbox('readonly', true);
		$('#branchCodeAll').textbox('readonly', true);
		$('#email').textbox('readonly', true);
		$('#startTime').textbox('readonly', true);
		$('#endTime').textbox('readonly', true);
		$('#enabled').combobox('readonly', true);
		//form button
		$('#btnSave').linkbutton('disable');
		
	}
	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		//list button
		$('#btnCariUser').show();
		$('#userId').textbox('readonly', false);
		$('#namax').textbox('readonly', false);
		$('#password').textbox('readonly', false);
		$('#branchCodeAll').textbox('readonly', false);
		$('#email').textbox('readonly', false);
		$('#startTime').textbox('readonly', false);
		$('#endTime').textbox('readonly', false);
		$('#enabled').combobox('readonly', false);
		//form button
		$('#btnSave').linkbutton('enable');
	
	}
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		//list buttonbtn CariUser
		$('#btnCariUser').hide();
		$('#userId').textbox('readonly', true);
		$('#namax').textbox('readonly', false);
		$('#password').textbox('readonly', false);
		$('#branchCodeAll').textbox('readonly', false);
		$('#email').textbox('readonly', false);
		$('#startTime').textbox('readonly', false);
		$('#endTime').textbox('readonly', false);
		$('#enabled').combobox('readonly', false);
		//form button
		$('#btnSave').linkbutton('enable');
		
	}


	
	
	
	
	
	
	
	
	
	
	
</script>