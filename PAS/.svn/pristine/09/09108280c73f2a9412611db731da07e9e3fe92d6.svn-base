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
			                    <th style="font-weight:bold" align="center" class="cfg_header" >Name</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >EndTime</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >StartTime</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Enabled</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Password</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >LastChangePwd</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >LimitApproval</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >LoginFailCount</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >BranchMobileId</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >UserId</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >BranchCode</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >LastLogIn</th> 
                    <th style="font-weight:bold" align="center" class="cfg_header" >Email</th> 
                     
    	</tr>
	</thead>
</table>
</div>
</body>

<script type="text/javascript">

	$("document").ready(function(){
		var uri ='userDataReport.htm?';
		var s = window.location.search.replace("?", "") ;
		$.ajax({
			url:uri+"&"+s,
			success	: function(result){			
				var x = JSON.parse(result);
				var no = 1;
				 $.each(x, function( index, value ) {
	                 var row = $("<tr>"+
	                       			        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.name + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.endTime + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.startTime + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.enabled + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.password + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.lastChangePwd + "</font></div></td>"+
        "<td align='right'> <div class='cfg_detail'><font class='f_boldhd'>" + accounting.formatNumber(value.limitApproval,0,'.',',') + "</font></div></td>"+
        "<td align='right'> <div class='cfg_detail'><font class='f_boldhd'>" + accounting.formatNumber(value.loginFailCount,0,'.',',') + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.branchMobileId + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.userId + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.branchCode + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.lastLogIn + "</font></div></td>"+
        "<td align='left'> <div class='cfg_detail'><font class='f_boldhd'>" +  value.email + "</font></div></td>"+

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
