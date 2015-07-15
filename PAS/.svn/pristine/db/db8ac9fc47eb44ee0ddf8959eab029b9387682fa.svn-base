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
        <table id="dg2" title="Pencarian Kantor Auditan" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar2" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeTkAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaAuditan.KodeTkAuditan")%></th> 
                    <th field="kodeAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaAuditan.KodeAuditan")%></th> 
                    <th field="namaAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaAuditan.NamaAuditan")%></th> 
                    <th field="alamatAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaAuditan.AlamatAuditan")%></th> 
                    <th field="kotaAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaAuditan.KotaAuditan")%></th> 
                    <th field="provinsiAuditan" width="100"sortable="true"><%=properties.getProperty("pasEaAuditan.ProvinsiAuditan")%></th> 
                </tr>
            </thead>
        </table>  
       <div id="toolbar2">
        	<table width="100%">
        	<tr>
        	<td align="left">        	
        		<label>Auditan</label><input type="text" name="namaAuditans" id="namaAuditans" style="width: 100px;">
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="cariauditanList()" id="cariauditanList"><%= properties.getProperty("button.cari") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="ambilauditan()" id="btnAmbil"><%= properties.getProperty("button.ambil") %></a>
        	</td>
        	</tr>
        </table>
        </div>

 <!-- ************************** END LIST/TABLE ******************************************** -->       
    
<script type="text/javascript">
function cariauditanList(s) {
	var jsonurl = 'pasEaAuditanListCari.htm?'+'namaAuditan='+$('#namaAuditans').val()+"&userId="+"${userId}";
	$('#dg2').datagrid({
		url : jsonurl,
		onLoadSuccess : function(data) {
			if (data.total == 0) {
				alert("Data Tidak Ditemukan..................");
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

	
</script>
