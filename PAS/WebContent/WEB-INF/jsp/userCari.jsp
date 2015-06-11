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
        <table id="dg2" title="Cari User" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar2" pagination="true"  data-options="total:2000,pageSize:10"
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
       <div id="toolbar2">
        	<table width="100%">
        	<tr>
        	<td align="left">        	
        		<label>User Name</label><input type="text" name="userName" id="userName" style="width: 100px;" class="easyui-textbox" >
        		<label>User ID</label><input type="text" name="userIDX" id="userIDX" style="width: 100px;" class="easyui-textbox" >
        		<label>Kode Unit</label><input type="text" name="kodeUnit" id="kodeUnit" style="width: 100px;" class="easyui-textbox" >
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="cariauditanList()" id="cariauditanList"><%= properties.getProperty("button.cari") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="ambilauditan()" id="btnAmbil"><%= properties.getProperty("button.ambil") %></a>
        		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="doClear()" id="btnReset"><%= properties.getProperty("button.reset") %></a>
        	
        	</td>
        	</tr>
        </table>
        </div>

 <!-- *************userListAll************* END LIST/TABLE ******************************************** -->       
    
<script type="text/javascript">
function cariauditanList(s) {
	//var jsonurl = 'userCari.htm?'+'namaAuditan='+$('#userName').val()+"&userId="+"${userId}";
	var jsonurl = 'userCariList.htm?param=' + $('#userIDX').val()+"&"+"userID="+"${userId}"+"&unitId="+"&nama="+$('#userName').val()
	+"&kodeUnit="+$('#kodeUnit').val();
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
	//$('#formCari').form('clear');
	var jsonurl = "listClear.htm";
	$('#userIDX').textbox('setValue','');
	$('#kodeUnit').textbox('setValue','');
	$('#userName').textbox('setValue','');
	$('#dg2').datagrid({
		url : jsonurl,
		onLoadSuccess : function(data) {
			if (data.total > 0) {
				alert("Clear Gagal..................");
			}
		}
	});
}



</script>
	
</body>
</html>



<script>
var url;
var branchcode;
	$("document").ready(function() {});

	
	

	function test() {
		alert("test");
		
	}
	


	
</script>
