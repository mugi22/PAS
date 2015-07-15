<%@ page pageEncoding="UTF-8" %>
<!-- ******************************************DETAIL LIST (TABLE)********************************************-->
<div id="detDlg" class="easyui-dialog"
		style="width: 750px; padding: 10px 20px" closed="true"
		data-options="modal:true">
        <table id="detDg" title="LIST DETAIL RKAP" class="easyui-datagrid"
		style="width: 100%;" toolbar="#detToolbar" pagination="false"
		data-options="total:2000,pageSize:10" rownumbers="true" showFooter="true"
		fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="kodeKegiatanRKBPT" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.KodeKegiatanRKBPT")%></th> 
                    <th field="tanggalAwal" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.TanggalAwal")%></th> 
                    <th field="tanggalAkhir" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.TanggalAkhir")%></th> 
                    <th field="namaKegiatan" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.NamaKegiatan")%></th> 
                    <th field="keteranganKegiatan" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.KeteranganKegiatan")%></th> 
                    <th field="tempatKegiatan" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.TempatKegiatan")%></th> 
                    <th field="jumlahPersonil" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.jumlahPersonil,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanRKBPT.JumlahPersonil")%></th> 
                    <th field="jenisTransportasi" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.JenisTransportasi")%></th> 
                    <th field="biayaTransportasi" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaTransportasi,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanRKBPT.BiayaTransportasi")%></th> 
                    <th field="biayaLumpsum" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaLumpsum,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanRKBPT.BiayaLumpsum")%></th> 
                    <th field="kodeRKBPT" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.KodeRKBPT")%></th> 
                    <th field="statusInap" width="100"sortable="true"><%=properties.getProperty("pasRaKegiatanRKBPT.StatusInap")%></th> 
                    <th field="jarak" width="100"sortable="true"data-options="formatter:function(value, row){return accounting.formatNumber(row.jarak,0,'.',','); }"align="right"><%=properties.getProperty("pasRaKegiatanRKBPT.Jarak")%></th> 
                     
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
 </div>       
<!-- *****************************************END DETAIL LIST*************************************************** -->


<!-- *********************************************DETAIL FORM------------------------- -->
<div id="detDlgForm" class="easyui-dialog"	style="width: 750px;  padding: 10px 20px" closed="true"	buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">PASRAKEGIATANRKBPT</div>
		<form id="detFm" method="post" novalidate>
		<table align="center"> 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.KodeKegiatanRKBPT")%></label> :<input name="kodeKegiatanRKBPT"	class="easyui-textbox" id="kodeKegiatanRKBPT"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.TanggalAwal")%></label> :<input name="tanggalAwal"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="tanggalAwal"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.TanggalAkhir")%></label> :<input name="tanggalAkhir"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="tanggalAkhir"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.NamaKegiatan")%></label> :<input name="namaKegiatan"	class="easyui-textbox" id="namaKegiatan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.KeteranganKegiatan")%></label> :<input name="keteranganKegiatan"	class="easyui-textbox" id="keteranganKegiatan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.TempatKegiatan")%></label> :<input name="tempatKegiatan"	class="easyui-textbox" id="tempatKegiatan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.JumlahPersonil")%></label> :<input name="jumlahPersonil"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="jumlahPersonil"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.JenisTransportasi")%></label> :<input name="jenisTransportasi"	class="easyui-textbox" id="jenisTransportasi"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.BiayaTransportasi")%></label> :<input name="biayaTransportasi"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="biayaTransportasi"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.BiayaLumpsum")%></label> :<input name="biayaLumpsum"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="biayaLumpsum"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.KodeRKBPT")%></label> :<input name="kodeRKBPT"	class="easyui-textbox" id="kodeRKBPT"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.StatusInap")%></label> :<input name="statusInap"	class="easyui-textbox" id="statusInap"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaKegiatanRKBPT.Jarak")%></label> :<input name="jarak"	class="easyui-numberbox" data-options="min:0,precision:0,groupSeparator:','" id="jarak"></div></td></tr>	
			
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
	</div>
	
<!-- *********************************************DETAIL FORM END------------------------- -->
<script type="text/javascript">

function doDetail() {
	var row = $('#dg').datagrid('getSelected');
	if(row == null){
		$.messager.show({ // show error message
			title : 'Error',
			msg : result.errorMsg + "Row Belum Dipilih "
		});
	}else{
		$('#detDlg').dialog('open').dialog('setTitle', 'Detail RKAP');
		//$('#detKodeRKAP').textbox('setValue',row.kodeRKAP);
		//detRetrieve(row.kodeRKAP,row.nomorSuratPengajuan);
	}
}
	
function detDoAdd() { 
	var row = $('#dg').datagrid('getSelected');//row dari master
	idRequired(true);
	$('#detDlgForm').dialog('open').dialog('setTitle', 'Tambah');
	$('#detFm').form('clear');
	url = 'pasRaDetailRKAPAdd.htm?'+"userId="+"${userId}";
	$("#detKodeRKAP").textbox('setValue',row.kodeRKAP);
	onAddDet();
}
</script>


