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

<title>Insert title here</title>
</head>
<body>
<!-- javascript:printDiv('printed') -->
<input type="button" value="Cetak" onclick="cetak()">
<div id="printArea">


	<table width="90%"	style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;">
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


<table id="myData" align="center" width="90%" cellpadding="0" cellspacing="0"  style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;">
	<thead>            
    	<tr>
			                    <th style="font-weight:bold" align="center" class="cfg_header" >KodeTkAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >KodeAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >NamaAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >AlamatAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >KotaAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >ProvinsiAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >KoordinatAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >TelephoneAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >FaximiliAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >UserNamePicTl</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >PasswordPicTl</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >StatusAuditan</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >KdParent</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >NikPicTl</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >NamaPicTl</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >NoHpPicTl</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >EmailPicTl</th> 
                     
    	</tr>
	</thead>
</table>
</div>
</body>

<script type="text/javascript">

	$("document").ready(function(){
		var uri ='pasEaAuditanDataReport.htm?';
		var s = window.location.search.replace("?", "") ;
		$.ajax({
			url:uri+"&"+s,
			success	: function(result){			
				var x = JSON.parse(result);
				var no = 1;
				 $.each(x, function( index, value ) {
	                 var row = $("<tr>"+
	                       			        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.kodeTkAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.kodeAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.namaAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.alamatAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.kotaAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.provinsiAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.koordinatAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.telephoneAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.faximiliAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.userNamePicTl + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.passwordPicTl + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.statusAuditan + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.kdParent + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.nikPicTl + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.namaPicTl + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.noHpPicTl + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.emailPicTl + "</font></div></td>"+

	                		     "</tr>");
	                 $("#myData").append(row);
	                 no++;
	              });
				var z =  $("<tr> <td colspan='5' align='left' style='background-color:#CCF;'> <div class='cfg_detailx'><font class='f_boldhd'>" +'T O T A L'+ "</font></div></td></tr>");
				$("#myData").append(z);
			}
		});
	});

function cetak(){
	printDiv('printed');
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
