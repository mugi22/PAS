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

	<!-- ******************************FORM PENCARIAN******************************* -->
	<div id="div2">
		<form name="FREG" id="formCari" method="post" action="#">
			<table align="center">
				<tr>
					<td><label style="width: 150px;"><%=properties
					.getProperty("pasRaPKPT.KodeKantorAuditorPemilik")%></label> : <input
						name="KodeKantorAuditorPemilik" type="text" class="easyui-textbox"
						id="KodeKantorAuditorPemilik" size="30" maxlength="30"></td>
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaPKPT.KodePKPT")%></label>
						: <input name="KodePKPT" type="text" id="KodePKPT" size="30"
						class="easyui-textbox" maxlength="30"></td>
				</tr>
				<tr>
					<!-- td><label style="width: 150px;"><%=properties.getProperty("pasRaPKPT.StatusReviu")%></label>
						: <input name="StatusReviu" type="text" id="StatusReviu" size="30"
						class="easyui-textbox" maxlength="30"></td-->
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaPKPT.TahunPKPT")%></label>
						: <input name="TahunPKPT" type="text" id="TahunPKPT" size="30"
						class="easyui-textbox" maxlength="30"></td>
					<td><label style="width: 150px;"><%=properties.getProperty("pasRaPKPT.StatusPKPT")%></label>
						: <input name="StatusPKPT" type="text" id="StatusPKPT" size="30"
						maxlength="30"></td>
				</tr>
				<tr>
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
	<table id="dg" title="PASRAPKPT" class="easyui-datagrid"
		style="width: 100%;" toolbar="#toolbar" pagination="true"
		data-options="total:2000,pageSize:10" rownumbers="true"
		fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="kodePKPT" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.KodePKPT")%></th>
				<th field="tahunPKPT" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.TahunPKPT")%></th>
				<th field="kodeKantorAuditorPemilik" width="100" sortable="true"><%=properties
					.getProperty("pasRaPKPT.KodeKantorAuditorPemilik")%></th>
				<th field="statusPembuatan" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.StatusPembuatan")%></th>
				<th field="kodeUserPembuat" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.KodeUserPembuat")%></th>
				<th field="nomorSuratPengajuan" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.NomorSuratPengajuan")%></th>
				<th field="tanggalSuratPengajuan" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.TanggalSuratPengajuan")%></th>
				<th field="statusReviu" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.StatusReviu")%></th>
				<th field="kodeUserPenyetuju" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.KodeUserPenyetuju")%></th>
				<th field="nomorSuratPersetujuan" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.NomorSuratPersetujuan")%></th>
				<th field="tanggalSuratPersetujuan" width="100" sortable="true"><%=properties
					.getProperty("pasRaPKPT.TanggalSuratPersetujuan")%></th>
				<th field="kodePKPTYangDiRevisi" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.KodePKPTYangDiRevisi")%></th>
				<th field="kodeUserPeReviu" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.KodeUserPeReviu")%></th>
				<th field="statusPerstujuan" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.StatusPerstujuan")%></th>
				<th field="statusPKPT" width="100" sortable="true"><%=properties.getProperty("pasRaPKPT.StatusPKPT")%></th>

			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<%@ include file="/util/toolbar.jsp"%>
		<td align="right">
			<a href="javascript:void(0)"class="easyui-linkbutton" iconCls="icon-authorize" plain="true"	onclick="doDetailShow()" id="btnDetailShow"><%="Show "+properties.getProperty("button.detail")%></a>
			<a href="javascript:void(0)"class="easyui-linkbutton" iconCls="icon-authorize" plain="true"	onclick="doDetail()" id="btnDetail"><%=properties.getProperty("button.detail")%></a>
			<a href="javascript:void(0)"class="easyui-linkbutton" iconCls="icon-authorize" plain="true"	onclick="doPengajuan()" id="btnDetail"><%="Pengajuan"%></a>
			
		</td>
		</tr>
		</table>
	</div>

	<!-- ************************** END LIST/TABLE ******************************************** -->


	<!-- ************************** FORM ******************************************** -->
	<div id="dlg" class="easyui-dialog"
		style="width: 750px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" data-options="modal:true">
		<div class="ftitle">PASRAPKPT</div>
		<form id="fm" method="post" novalidate>
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.KodePKPT")%></label>:<input
								name="kodePKPT" class="easyui-textbox" id="kodePKPT">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.TahunPKPT")%></label>:<input
								name="tahunPKPT" class="easyui-textbox" id="tahunPKPT">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaPKPT.KodeKantorAuditorPemilik")%></label>:<input
								name="kodeKantorAuditorPemilik" class="easyui-textbox"
								id="kodeKantorAuditorPemilik">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.KodeUserPembuat")%></label>:<input
								name="kodeUserPembuat" class="easyui-textbox"
								id="kodeUserPembuat">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.StatusPembuatan")%></label>:<input
								name="statusPembuatan" class="easyui-textbox"
								id="statusPembuatan">
						</div></td>
				</tr>
				
				<!-- 
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.KodeUserPeReviu")%></label> :<input name="kodeUserPeReviu"	class="easyui-textbox" id="kodeUserPeReviu"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.StatusReviu")%></label> :<input name="statusReviu"	class="easyui-textbox" id="statusReviu"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.KodeUserPenyetuju")%></label> :<input name="kodeUserPenyetuju"	class="easyui-textbox" id="kodeUserPenyetuju"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.NomorSuratPersetujuan")%></label> :<input name="nomorSuratPersetujuan"	class="easyui-textbox" id="nomorSuratPersetujuan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.TanggalSuratPersetujuan")%></label> :<input name="tanggalSuratPersetujuan"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="tanggalSuratPersetujuan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.KodePKPTYangDiRevisi")%></label> :<input name="kodePKPTYangDiRevisi"	class="easyui-textbox" id="kodePKPTYangDiRevisi"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.StatusPerstujuan")%></label> :<input name="statusPerstujuan"	class="easyui-textbox" id="statusPerstujuan"></div></td></tr>	
                    <tr><td><div class="fitem">	<label><%=properties.getProperty("pasRaPKPT.StatusPKPT")%></label> :<input name="statusPKPT"	class="easyui-textbox" id="statusPKPT"></div></td></tr>	
					 -->
			</table>
			<div id="pengajuan" style="border: 1px;">
			<table>
                    <tr><td><div class="fitem">	<label id="lblNoSurat"><%=properties.getProperty("pasRaPKPT.NomorSuratPengajuan")%></label> :<input name="nomorSuratPengajuan"	class="easyui-textbox" id="nomorSuratPengajuan"></div></td>	
                    <td><div class="fitem">	<label id="lblTglSurat"><%=properties.getProperty("pasRaPKPT.TanggalSuratPengajuan")%></label> :<input name="tanggalSuratPengajuan"	class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" id="tanggalSuratPengajuan"></div></td></tr>	
			</table>
				</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="doSave()" style="width: 90px" id="btnSave">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px" id="btnCancel">Cancel</a>
	</div>
	<!-- ************************************************END FORM******************* -->



	<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&& LIST DETAIL&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->
	<!-- **********************TABLE RESULT**DETAIL************************************ -->
	<div id="detDlg" class="easyui-dialog"
		style="width: 90%; padding: 10px 20px" closed="true"
		data-options="modal:true">
		<!-- TAMPILKAN form masternya  -->
		<form id="fm" method="post" novalidate>
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.KodePKPT")%></label>:<input
								name="kodePKPT" class="easyui-textbox" id="kodePKPTDet">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.TahunPKPT")%></label>:<input
								name="tahunPKPT" class="easyui-textbox" id="tahunPKPTDet">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaPKPT.KodeKantorAuditorPemilik")%></label>:<input
								name="kodeKantorAuditorPemilik" class="easyui-textbox"
								id="kodeKantorAuditorPemilikDet">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.KodeUserPembuat")%></label>:<input
								name="kodeUserPembuat" class="easyui-textbox"
								id="kodeUserPembuatDet">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.StatusPembuatan")%></label>:<input
								name="statusPembuatan" class="easyui-textbox"
								id="statusPembuatanDet">
						</div></td>
				</tr>

				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaPKPT.Bulan")%></label>:<input
								name="bulanKegiatan" class="easyui-textbox"
								id="bulanKegiatanDet">
						</div></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton c6"
						iconCls="icon-ok" onclick="doRetrieveDet()" style="width: 90px"
						id="btnRetrieveDet">Retrieve</a></td>
				</tr>

			</table>

		</form>
		<table id="dgPKPT" title="PASRAKEGIATANPKPT" class="easyui-datagrid"
			style="width: 100%;" toolbar="#detToolbar" pagination="true"
			data-options="total:2000,pageSize:10" rownumbers="true"
			fitColumns="true" singleSelect="true">
			<thead>
				<tr>
					<!-- th field="kodePKPT" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KodePKPT")%></th-->
					<th field="kodeKegiatanPKPT" width="100" sortable="true"><%=properties
					.getProperty("pasRaKegiatanPKPT.KodeKegiatanPKPT")%></th>
					<th field="namaKegiatan" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.NamaKegiatan")%></th>
					<th field="kodeUserPembuat" width="100" sortable="true"><%=properties
					.getProperty("pasRaKegiatanPKPT.KodeUserPembuat")%></th>
					<th field="tanggalAwal" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAwal")%></th>
					<th field="tanggalAkhir" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAkhir")%></th>
					<th field="keteranganKegiatan" width="100" sortable="true"><%=properties
					.getProperty("pasRaKegiatanPKPT.KeteranganKegiatan")%></th>
					<th field="jenisTransportasi" width="100" sortable="true"><%=properties
					.getProperty("pasRaKegiatanPKPT.JenisTransportasi")%></th>
					<th field="biayaTransportasi" width="100" sortable="true"
						data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaTransportasi,0,'.',','); }"
						align="right"><%=properties
					.getProperty("pasRaKegiatanPKPT.BiayaTransportasi")%></th>
					<th field="biayaLumpsum" width="100" sortable="true"
						data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaLumpsum,0,'.',','); }"
						align="right"><%=properties.getProperty("pasRaKegiatanPKPT.BiayaLumpsum")%></th>
					<th field="biayaMobilDinas" width="100" sortable="true"
						data-options="formatter:function(value, row){return accounting.formatNumber(row.biayaMobilDinas,0,'.',','); }"
						align="right"><%=properties
					.getProperty("pasRaKegiatanPKPT.BiayaMobilDinas")%></th>
					<th field="statusInap" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.StatusInap")%></th>
					<th field="kodeAuditan" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KodeAuditan")%></th>
					<th field="kodeJenisPemeriksaan" width="100" sortable="true"><%=properties.getProperty("pasRaKegiatanPKPT.KodeJenisPemeriksaan")%></th>
				</tr>
			</thead>
		</table>
		<div id="detToolbar">
			<table width="100%">
				<tr>
					<td align="left">
						<a href="javascript:void(0)"	class="easyui-linkbutton" iconCls="icon-add" plain="true"
						onclick="detDoAdd()" id="detbtnAdd"><%=properties.getProperty("button.add")%></a>
						<a href="javascript:void(0)" class="easyui-linkbutton"	iconCls="icon-edit" plain="true" onclick="detDoEdit()"
						id="detbtnEdit"><%=properties.getProperty("button.edit")%></a> <a
						href="javascript:void(0)" class="easyui-linkbutton"	iconCls="icon-remove" plain="true" onclick="detDoDelete()"
						id="detbtnDelete"><%=properties.getProperty("button.delete")%></a>
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="detDoShow()"
						id="detbtnShow"><%=properties.getProperty("button.show")%></a></td>
					<td align="right"></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&& END LIST/TABLE &&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->


	<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&& FORM ***DETAIL&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->
	<div id="dlgPKPT" class="easyui-dialog"
		style="width: 750px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" data-options="modal:true">
		<form id="fmPKPT" method="post" novalidate>
			<table align="center">
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.KodePKPT")%></label>
							:<input name="kodePKPT" class="easyui-textbox" id="detkodePKPT">
						</div></td>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.KodeKegiatanPKPT")%></label>
							:<input name="kodeKegiatanPKPT" class="easyui-textbox"
								id="detkodeKegiatanPKPT">
						</div></td>
				</tr>
				<!-- tambaha unit kerja -->
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.KodeAuditan")%></label> :<input
								name="kodeAuditan" class="easyui-textbox" id="detkodeAuditan">
						</div></td>
					<td>
						<input name="cariUnit" id="cariUnitParent" value="Cari" type="button" onclick="cariAuditan()" style="width: 35px;">
					</td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.NamaAuditan")%></label> :<input
								name="namaAuditan" class="easyui-textbox" id="detnamaAuditan">
						</div></td>
				</tr>
				<!-- tambaha Jenis Pemeriksaan -->
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.KodeJenisPemeriksaan")%></label> :<input
								name="kodeJenisPemeriksaan" class="easyui-textbox" id="detkodeJenisPemeriksaan">
						</div></td>
				</tr>
				<!-- tambaha unit kerja END -->
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.NamaKegiatan")%></label>
							:<input name="namaKegiatan" class="easyui-textbox"
								style="width: 460px" id="detnamaKegiatan">
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.KeteranganKegiatan")%></label> :<input
								name="keteranganKegiatan" class="easyui-textbox"
								style="width: 460px" id="detketeranganKegiatan">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAwal")%></label>
							:<input name="tanggalAwal" class="easyui-datebox"
								data-options="formatter:myformatter,parser:myparser"
								id="dettanggalAwal">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.TanggalAkhir")%></label>
							:<input name="tanggalAkhir" class="easyui-datebox"
								data-options="formatter:myformatter,parser:myparser"
								id="dettanggalAkhir">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.JenisTransportasi")%></label> :<input
								name="jenisTransportasi" class="easyui-textbox"
								id="detjenisTransportasi">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.BiayaTransportasi")%></label> :<input
								name="biayaTransportasi" class="easyui-numberbox"
								data-options="min:0,precision:0,groupSeparator:','"
								id="detbiayaTransportasi">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.BiayaLumpsum")%></label>
							:<input name="biayaLumpsum" class="easyui-numberbox"
								data-options="min:0,precision:0,groupSeparator:','"
								id="detbiayaLumpsum">
						</div></td>
				</tr>
				<tr>

					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.BiayaMobilDinas")%></label> :<input
								name="biayaMobilDinas" class="easyui-numberbox"
								data-options="min:0,precision:0,groupSeparator:','"
								id="detbiayaMobilDinas">
						</div></td>
					<td><div class="fitem">
							<label><%=properties.getProperty("pasRaKegiatanPKPT.StatusInap")%></label>
							:<input name="statusInap" class="easyui-textbox"
								id="detstatusInap">
						</div></td>
				</tr>
				<tr>
					<td><div class="fitem">
							<label><%=properties
					.getProperty("pasRaKegiatanPKPT.KodeUserPembuat")%></label> :<input
								name="kodeUserPembuat" class="easyui-textbox"
								id="detkodeUserPembuat">
						</div></td>
				</tr>
				
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="detDoSave()" style="width: 90px"
			id="detbtnSave">Save</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlgPKPT').dialog('close')"
			style="width: 90px" id="btnCancel">Cancel</a>
	</div>
	<!-- ************************************************END DETAIL FORM******************* -->
	<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->


	<div id="win"></div>
</body>
</html>



<script>
	var url;
	var branchcode;
	$("document").ready(
			function() {
				$("#btnAdd").linkbutton('${btnAdd}');
				$("#btnEdit").linkbutton('${btnEdit}');
				$("#btnDelete").linkbutton('${btnDelete}');
				$("#btnShow").linkbutton('${btnShow}');
				$("#KodeKantorAuditorPemilik").textbox('setValue',"${tblUser.branchCode}");
				$("#kodePKPT").textbox('readonly', true);
				
				comboLookup($("#StatusPKPT"), 'STATUS-PKPT');
			});

	function doDetail() {
		$('#detbtnDelete').linkbutton("disable");
		$('#detbtnAdd').linkbutton("disable");
		var row = $('#dg').datagrid('getSelected');
		if (row == null) {
			$.messager.show({ // show error message
				title : 'Error',
				msg : result.errorMsg + "Row Belum Dipilih "
			});
		} else {
			comboLookup($("#statusPembuatanDet"), 'STATUS_PEMBUATAN_RKAP');
			$('#detDlg').dialog('open').dialog('setTitle', 'Detail RKAP');
			$('#kodePKPTDet').textbox('setValue', row.kodePKPT).textbox('readonly', true);
			$('#tahunPKPTDet').textbox('setValue', row.tahunPKPT).textbox('readonly', true);
			$('#kodeKantorAuditorPemilikDet').textbox('setValue',row.kodeKantorAuditorPemilik).textbox('readonly', true);
			$('#statusPembuatanDet').textbox('setValue', row.statusPembuatan).textbox('readonly', true);
			$('#kodeUserPembuatDet').textbox('setValue', row.kodeUserPembuat).textbox('readonly', true);
			comboBulan($("#bulanKegiatanDet"));
		}
	}

	function doRetrieveDet() {
		var bulan = $("#bulanKegiatanDet").combobox('getValue');
		var kodePKPT = $('#kodePKPTDet').val();
		var thPKPT = $('#tahunPKPTDet').val();
		if (bulan == "") {
			alert("Bulan Tidak Boleh Kosong");
			return;
		}
		var jsonurl = 'pasRaKegiatanPKPTListByMonth.htm?' + 'bulan=' + bulan
				+ "&" + 'KodePKPT=' + kodePKPT + "&" + 'thPKPT=' + thPKPT + "&"
				+ "userId=" + "${userId}";
		$('#dgPKPT').datagrid({
			url : jsonurl,
			onLoadSuccess : function(data) {
				if (data.total == 0) {
					alert("Data Tidak Ditemukan..................");
				}
			}
		});
	}

	$('#dgPKPT').datagrid({
		onDblClickRow : function() {
			//var row = $('#dgPKPT').datagrid('getSelected');
			detDoEdit();
			//alert("Double Clik dataGrid "+row.kodePKPT);
			//$('#dlgPKPT').dialog('open').dialog('setTitle', 'Detail PKPT');
		}
	});

	//onSelect: function(rec) {
	
	
	function detDoEdit() {
		idRequired(false);
		comboYesNo($('#detstatusInap'));
		comboLookup($("#detjenisTransportasi"), 'TRANSPORTASI');//
		comboEaJenisPemeriksaan($('#detkodeJenisPemeriksaan'), "");
		comboLookup($("#statusPembuatan"), 'STATUS_PEMBUATAN_RKAP');
		$('#fmPKPT').form('clear');
		var row = $('#dgPKPT').datagrid('getSelected');
		if (row) {
			$('#dlgPKPT').dialog('open').dialog('setTitle', 'Edit');
			$('#fmPKPT').form('clear');
			$('#fmPKPT').form('load', row);
			url = 'pasRaKegiatanPKPTEdit.htm?' + "userId=" + "${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			comboEaJenisPemeriksaan($('#detkodeJenisPemeriksaan'), row.kodeJenisPemeriksaan);
			$.ajax({
				url: "getPasEaAuditan.htm?param="+	$("#detkodeAuditan").val()+"&param2="	,
				success	: function(result){
					var x = JSON.parse(result);
					$("#detnamaAuditan").textbox('setValue',x.namaAuditan);
				}
			});
		}
		
		$('#detkodeJenisPemeriksaan').combobox({
			onSelect: function(rec) {
				$('#detnamaKegiatan').textbox('setValue',"Pemeriksaan "+$('#detkodeJenisPemeriksaan').combobox('getText')+" = "+$("#detnamaAuditan").val());
			}
			});
		detonEdit();
	}

	function detDoSave() {
		idRequired(false);
		$('#fmPKPT').form('submit', {
			url : 'pasRaKegiatanPKPTEdit.htm?' + "userId=" + "${userId}",
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				/*var x = JSON.parse(result);
					if(successCode == 0){
						alertError("Simpan Gagal <br>"+x.message);
					}else{
						alertAll('Simpan Sukses');
						$('#dlgPKPT').dialog('close'); // close the dialog
						$('#dgPKPT').datagrid('reload'); // reload the user data
					}
				 */

				var resultx = eval('(' + result + ')');
				if (resultx === 'fail' || result === null) {
					alertError("Simpan Gagal");
				} else {
					alertAll('Simpan Sukses');
					$('#dlgPKPT').dialog('close'); // close the dialog
					$('#dgPKPT').datagrid('reload'); // reload the user data
				}

			}
		});
	}

	function detonEdit() {
		$('#detkodeUserPembuat').textbox('readonly', true);
		$('#dettanggalAwal').textbox('readonly', true);
		$('#dettanggalAkhir').textbox('readonly', true);
		$('#detnamaKegiatan').textbox('readonly', false);
		$('#detketeranganKegiatan').textbox('readonly', false);
		$('#detjenisTransportasi').textbox('readonly', false);
		$('#detbiayaTransportasi').textbox('readonly', false);
		$('#detbiayaLumpsum').textbox('readonly', false);
		$('#detkodeKegiatanPKPT').textbox('readonly', true);
		$('#detbiayaMobilDinas').textbox('readonly', false);
		$('#detkodePKPT').textbox('readonly', true);
		$('#detstatusInap').textbox('readonly', false);
		$('#detbtnSave').linkbutton('enable');
	}
	
	
	function cariAuditan() {
		$('#win').window({
	        width:800,		        height:400,
	        href:'pasEaAuditanCari.htm?'+window.location.search.replace("?", ""),
	        modal:true,		        minimizable:false,		        maximizable:false,		        collapsible:false        
	        });
}

function ambilauditan(s) {
	var row = $('#dg2').datagrid('getSelected');
	$("#detkodeAuditan").textbox('setValue', row.kodeAuditan);
	$("#detnamaAuditan").textbox('setValue', row.namaAuditan);
	//comboEaTkAuditon($('#kodeTkAuditan'),row.kodeTkAuditan);
	$('#win').window('close'); 
}
	
	
	
	
	//=======================END DETAIL++++++++++++++++++++++++++++++++	

	function doEdit() {
		idRequired(false);
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		comboLookup($("#statusPembuatan"), 'STATUS_PEMBUATAN_RKAP');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasRaPKPTEdit.htm?' + "userId=" + "${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
			
		}
	}

	function retrieve() {
		var jsonurl = 'pasRaPKPTListAll.htm?' + 'KodeKantorAuditorPemilik='
				+ $('#KodeKantorAuditorPemilik').val() + "&" + 'StatusReviu='
				+/* $('#StatusReviu').val() */""+ "&" + 'KodePKPT='
				+ $('#KodePKPT').val() + "&" + 'TahunPKPT='
				+ $('#TahunPKPT').val() + "&" + 'StatusPKPT='
				+ $('#StatusPKPT').combobox('getValue') + "&" + "userId=" + "${userId}";
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

	/* ============FORM FUNCTION ========== pasRaPKPTtambah*/

	function doAdd() {
		$('#dlg').dialog('open').dialog('setTitle', 'Tambah');
		$('#fm').form('clear');
		url = 'pasRaPKPTAdd.htm?' + "userId=" + "${userId}";
		$("#kodeKantorAuditorPemilik").textbox('setValue',
				"${tblUser.branchCode}");
		$("#kodeUserPembuat").textbox('setValue', "${tblUser.userId}");
		comboLookup($("#statusPembuatan"), 'STATUS_PEMBUATAN_RKAP');
		$("#statusPembuatan").textbox('setValue', 'BS');
		$("#pengajuan").hide();
		onAdd();
		
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
		if(row.statusPKPT != 'B'){
			alert("PKPT Sudah tidak bisa Di Hapus");
			return;
		}
		if (row) {
			$.messager.confirm('Confirm', 'Anda Ingin Mengapus Data?',
					function(r) {
						if (r) {
							$.post('pasRaPKPTDelete.htm', {
								kodePKPT : row.kodePKPT,
								userId : "${userId}"
							}, function(result) {
								if (result.successCode == 1) {
									$('#dg').datagrid('reload'); // reload the user data
									alertInfo("Hapus Sukses");
								} else {
									alertError("Hapus Gagal <br>"+x.message);
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
				var x = JSON.parse(result);
				if(x.successCode == 1) {
					alertAll(x.message);
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
				} else {
					alertError(x.message);
				}
			}
		});
	}

	function doPengajuan(){
		$('#fm').form('clear');
		var row = $('#dg').datagrid('getSelected');
		if(row.statusPKPT != 'B'){
			alert("Bukan Status Pengajuan");
			return;
		}
		
		comboLookup($("#statusPembuatan"), 'STATUS_PEMBUATAN_RKAP');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', 'Edit');
			$('#fm').form('clear');
			$('#fm').form('load', row);
			url = 'pasRaPKPTPengajuan.htm?' + "userId=" + "${userId}";//?param='+row.kodeProvinsi+'&param2='+row.kodeKabupaten; //SESUAIKAN
			onEdit();
			
		}
		$("#pengajuan").show();
	}
	function idRequired(t) {
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
		$('#kodeKantorAuditorPemilik').textbox('readonly', true);
		$('#kodeUserPembuat').textbox('readonly', true);
		$('#statusPembuatan').textbox('readonly', true);
		$('#nomorSuratPengajuan').textbox('readonly', true);
		$('#tanggalSuratPengajuan').textbox('readonly', true);
		$('#statusReviu').textbox('readonly', true);
		$('#kodeUserPenyetuju').textbox('readonly', true);
		$('#nomorSuratPersetujuan').textbox('readonly', true);
		$('#tanggalSuratPersetujuan').textbox('readonly', true);
		$('#kodePKPTYangDiRevisi').textbox('readonly', true);
		$('#kodeUserPeReviu').textbox('readonly', true);
		$('#statusPerstujuan').textbox('readonly', true);
		$('#kodePKPT').textbox('readonly', true);
		$('#tahunPKPT').textbox('readonly', true);
		$('#statusPKPT').textbox('readonly', true);

		$('#btnSave').linkbutton('disable');
	}

	/*inputan readonly atau tidak saat Add*/
	function onAdd() {
		$('#kodeKantorAuditorPemilik').textbox('readonly', true);
		$('#kodeUserPembuat').textbox('readonly', true);
		$('#statusPembuatan').textbox('readonly', true);
		$('#nomorSuratPengajuan').textbox('readonly', false);
		$('#tanggalSuratPengajuan').textbox('readonly', false);
		
		$('#statusReviu').textbox('readonly', false);
		$('#kodeUserPenyetuju').textbox('readonly', false);
		$('#nomorSuratPersetujuan').textbox('readonly', false);
		$('#tanggalSuratPersetujuan').textbox('readonly', false);
		$('#kodePKPTYangDiRevisi').textbox('readonly', false);
		$('#kodeUserPeReviu').textbox('readonly', false);
		$('#statusPerstujuan').textbox('readonly', false);
		$('#kodePKPT').textbox('readonly', true);
		$('#tahunPKPT').textbox('readonly', false);
		$('#statusPKPT').textbox('readonly', false);
		$('#tahunPKPT').textbox('textbox').focus();
		$('#btnSave').linkbutton('enable');
	}

	$.extend($.fn.textbox.methods, {
		show: function(jq){
			return jq.each(function(){
				$(this).next().show();
			})
		},
		hide: function(jq){
			return jq.each(function(){
				$(this).next().hide();
			})
		}
	})
	/*inputan readonly atau tidak saat Edit */
	function onEdit() {
		$('#kodeKantorAuditorPemilik').textbox('readonly', true);
		$('#kodeUserPembuat').textbox('readonly', true);
		$('#statusPembuatan').textbox('readonly', false);
		$('#nomorSuratPengajuan').textbox('readonly', false);
		$('#tanggalSuratPengajuan').textbox('readonly', false);
		$('#statusReviu').textbox('readonly', false);
		$('#kodeUserPenyetuju').textbox('readonly', false);
		$('#nomorSuratPersetujuan').textbox('readonly', false);
		$('#tanggalSuratPersetujuan').textbox('readonly', false);
		$('#kodePKPTYangDiRevisi').textbox('readonly', false);
		$('#kodeUserPeReviu').textbox('readonly', false);
		$('#statusPerstujuan').textbox('readonly', false);
		$('#kodePKPT').textbox('readonly', true);
		$('#tahunPKPT').textbox('readonly', false);
		$('#statusPKPT').textbox('readonly', false);
		$("#pengajuan").hide();
		$('#btnSave').linkbutton('enable');
	}
	/*===============================================REPORT==================================*/
	function doCetak() {
		var repUrl = 'pasRaPKPTReport.htm?' + 'KodeKantorAuditorPemilik='
				+ $('#KodeKantorAuditorPemilik').val() + "&" + 'StatusReviu='
				+ $('#StatusReviu').val() + "&" + 'KodePKPT='
				+ $('#KodePKPT').val() + "&" + 'TahunPKPT='
				+ $('#TahunPKPT').val() + "&" + 'StatusPKPT='
				+ $('#StatusPKPT').val() + "&" + "userId=" + "${userId}";
		;
		var s = window.location.search.replace("?", "");
		window.open(repUrl + "&" + s,"_blank",
						"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no, \
				 menubar=no, status=no,'");
	}
	
	function doDetailShow() {
		var row = $('#dg').datagrid('getSelected');
		if (row == null) {
			$.messager.show({ // show error message
				title : 'Error',
				msg : result.errorMsg + "Row Belum Dipilih "
			});
		} else {
			var repUrl = 'pasRaKegiatanPKPTPersetujuanDetail.htm?' + 'NamaKegiatan='
					+/* $('#NamaKegiatan').val()*/"" + "&" 
					+ 'KodePKPT='+ row.kodePKPT + "&" + "userId=" + "${userId}";
			;
			var s = window.location.search.replace("?", "");
			window.open(repUrl + "&" + s,"_blank",
							"toolbar=no, scrollbars=yes, resizable=yes,	directories=no, location=no,  menubar=no, status=no,'");
			/*comboLookup($("#statusPembuatanDet"), 'STATUS_PEMBUATAN_RKAP');
			$('#detDlg').dialog('open').dialog('setTitle', 'Detail RKAP');
			$('#kodePKPTDet').textbox('setValue', row.kodePKPT).textbox('readonly', true);
			$('#tahunPKPTDet').textbox('setValue', row.tahunPKPT).textbox('readonly', true);
			$('#kodeKantorAuditorPemilikDet').textbox('setValue',row.kodeKantorAuditorPemilik).textbox('readonly', true);
			$('#statusPembuatanDet').textbox('setValue', row.statusPembuatan).textbox('readonly', true);
			$('#kodeUserPembuatDet').textbox('setValue', row.kodeUserPembuat).textbox('readonly', true);
			comboBulan($("#bulanKegiatanDet"));
			 */
		}
	}
</script>
