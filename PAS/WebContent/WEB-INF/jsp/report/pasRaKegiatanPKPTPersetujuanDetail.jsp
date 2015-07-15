<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="css/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="css/demo.css">
        <link rel="stylesheet" type="text/css" href="css/color.css">
        <link rel="stylesheet" type="text/css" href="css/searchcss.css">     
        <link rel="stylesheet" type="text/css" href="css/configzz.css"> 
         
        <script type="text/javascript" src="css/jquery-1.11.2.js"></script>
        <script type="text/javascript" src="css/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="css/formater.js"></script>
		<script type="text/javascript" src="css/accounting.min.js"></script>
		<script type="text/javascript" src="css/myalert.js"></script>
		<script type="text/javascript" src="css/my.js"></script>

<title>Detail PKPT</title>
<!-- style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style-->
</head>
<body>
<!-- javascript:printDiv('printed') -->
<input type="button" value="Cetak" onclick="cetak()">
<div id="printArea">


	<table width="90%" align="center"	style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; border: 1px solid black; border-collapse: collapse;">
		<tr>
			<td colspan="3" style="font-weight: bold;" align="left">
				Daftar XXXXXXXXX
			</td>
			<td colspan="3" style="font-weight: bold;" align="right">
				PIN000X
			</td>
		</tr>
		<tr>
			<td colspan="3" style="font-weight: bold;" align="left">
				PT.	XXXXXXXX
			</td>
			<td colspan="3" style="font-weight: bold;" align="right">
				Tgl	Cetak : 28/04/2015
			</td>
		</tr>
		<tr>
			<td colspan="6" style="font-weight: bold;" align="center">
				Daftar XXXXXXXXX
			</td>
		</tr>
		<tr>
			<td colspan="6" style="font-weight: bold;" align="center">
				KANWIL XXXXXXXX
			</td>

		</tr>
		<tr>
			<td colspan="6" style="font-weight: bold;" align="center">
				Per	Tanggal : 27/04/2015
			</td>
		</tr>
	</table>
	<br>
	<br>


<table id="myData" align="center" width="90%" cellpadding="0" cellspacing="0"  style="font-family: Verdana, Arial, Helvetica, sans-serif; 
font-size: 12px;  border: 1px solid black;">
	<thead>            
    	<tr>
    				<th height='30' style="font-weight:bold" align="center" class="cfg_header" >No</th> 
                    <!-- th style="font-weight:bold" align="center" class="cfg_header" >Kode PKPT</th--> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Kode Kegiatan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Tgl Awal</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Tgl Akhir</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Kegiatan</th> 
                    <!-- th style="font-weight:bold" align="center" class="cfg_header" >KeteranganKegiatan</th--> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Tranportasi</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >By Taranportasi</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >By Lumpsum</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >By Mobil Dinas</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Inap</th> 
			        <th style="font-weight:bold" align="center" class="cfg_header" >User</th> 
                     
    	</tr>
	</thead>
</table>
</div>
</body>

<script type="text/javascript">

var monthNames = [ "Januari", "Februari", "Maret", "April", "Mai", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" ];

	$("document").ready(function(){
		var uri ='pasRaKegiatanPKPTDataPersetujuanDetail.htm?';
		var s = window.location.search.replace("?", "") ;
		$.ajax({
			url:uri+"&"+s,
			success	: function(result){			
				var x = JSON.parse(result);
				var no = 1;
				var bulan_before = "00";
				 $.each(x, function( index, value ) {
					 var kodePKPT="",namaKegiatan ="";
					 if (typeof value.kodePKPT == "undefined") value.kodePKPT=""  ;
					 if (typeof value.namaKegiatan == "undefined") value.namaKegiatan="" ;
					 if (typeof value.kodeKegiatanPKPT  == "undefined") value.kodeKegiatanPKPT ="" ;
					 if (typeof value.jenisTransportasi == "undefined")  value.jenisTransportasi ="" ;
					 if (typeof value.statusInap == "undefined") value.statusInap ="" ;
					 if (typeof value.kodeUserPembuat == "undefined") value.kodeUserPembuat ="" ;
					 var bln = value.tanggalAwal.substring(3, 5);
					 
		                if (bulan_before != bln){
		                	 $("#myData").append("<tr><td colspan='12' bgcolor='#66CCFF' height='30'> <font class='f_boldhd'> Kegiatan Bulan  : "+monthNames[parseInt(bln)-1]+""+"</font></td></tr>");
		                	 bulan_before = bln;
		                }
	                 var row = $("<tr>"+
	                		    "<td align='left' height='20' style='border: 1px solid black;' > " +  no+ "</div></td>"+
						        //"<td align='left' style='border: 1px solid black;'> " +  value.kodePKPT + "</div></td>"+
						        "<td align='left' style='border: 1px solid black;'> " +  value.kodeKegiatanPKPT + "</div></td>"+
						        "<td align='center' style='border: 1px solid black;'> " +  value.tanggalAwal + "</div></td>"+
						        "<td align='center' style='border: 1px solid black;'> " +  value.tanggalAkhir + "</div></td>"+
						        "<td align='left' style='border: 1px solid black;'> " +  value.namaKegiatan + "</div></td>"+
	                 			//<!--  "<td align='left'> " +  value.keteranganKegiatan + "</font></div></td>"+ -->
						        "<td align='left' style='border: 1px solid black;'> " +  value.jenisTransportasi + "</div></td>"+
						        "<td align='right' style='border: 1px solid black;'> " + accounting.formatNumber(value.biayaTransportasi,0,'.',',') + "</div></td>"+
						        "<td align='right' style='border: 1px solid black;'> " + accounting.formatNumber(value.biayaLumpsum,0,'.',',') + "</div></td>"+
						        "<td align='right' style='border: 1px solid black;'> " + accounting.formatNumber(value.biayaMobilDinas,0,'.',',') + "</div></td>"+
						        "<td align='left' style='border: 1px solid black;'> " +  value.statusInap + "</div></td>"+
						        "<td align='left' style='border: 1px solid black;'> " +  value.kodeUserPembuat + "</div></td>"+ "</tr>");
	             
	               
	                 $("#myData").append(row);
	                 no++;
	              });
				var z =  $("<tr> <td colspan='12' align='left' style='background-color:#CCF;'> <div class='cfg_detailx'>" +'T O T A L'+ "</div></td></tr>");
				$("#myData").append(z);
			}
		});
	});

function cetak(){
	printDiv('printArea');
}

function printDiv(divID) {
    //Get the HTML of div
    var divElements = document.getElementById(divID).innerHTML;
    //Get the HTML of whole page
    var oldPage = document.body.innerHTML;

    //Reset the page's HTML with div's HTML only
    document.body.innerHTML = 
      "<html><head><title></title></head><body>" + 
      divElements + "</body>";

    //Print Page
    window.print();

    //Restore orignal HTML
    document.body.innerHTML = oldPage; 
}
</script>
</html>
