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
        <table id="dg2" title="PASEAASPEKPEMERIKSAAN" class="easyui-datagrid" style="width:100%;"
               toolbar="#toolbar2" pagination="true"  data-options="total:2000,pageSize:10"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeJenisPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KodeJenisPemeriksaan")%></th> 
                    <th field="kodeAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KodeAspekPemeriksaan")%></th> 
                    <th field="namaAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.NamaAspekPemeriksaan")%></th> 
                    <th field="keteranganAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KeteranganAspekPemeriksaan")%></th> 
                    <th field="tujuanAspekPemeriksaan" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.TujuanAspekPemeriksaan")%></th> 
                    <th field="kdParent" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.KdParent")%></th> 
                    <th field="status" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.Status")%></th> 
                    <th field="HavaChild" width="100"sortable="true"><%=properties.getProperty("pasEaAspekPemeriksaan.HaveChild")%></th> 
                     
                </tr>
            </thead>
        </table>  
        <div id="toolbar2">
        	<table width="100%">
        	<tr>
        	<td align="left">        	
        		<label>Jenis Pemeriksaan</label><input type="text" name="KodeJenisPemeriksaan2" id="KodeJenisPemeriksaan2" style="width: 300px;">
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="cari()" id="cariAspek"><%= properties.getProperty("button.cari") %></a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="ambilAspek()" id="btnAmbil"><%= properties.getProperty("button.ambil") %></a>
        	</td>
        	</tr>
        </table>
        </div>
 <!-- ************************** END LIST/TABLE ******************************************** -->       
 
<script type="text/javascript">
$("document").ready(function() {
	comboEaJenisPemeriksaan($('#KodeJenisPemeriksaan2'),"");
});




	function cari() {
		var jsonurl = 'pasEaAspekPemeriksaanListAllCari.htm?' + 'Status=' + ""
				+ "&" + 'KodeAspekPemeriksaan=' + "" + "&"
				+ 'KodeJenisPemeriksaan='
				+ $('#KodeJenisPemeriksaan2').combobox('getValue') + "&"
				+ 'KdParent=' + "&" + "userId=" + "${userId}";

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
	

	
</script>
