<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/util/include.jsp" %>

<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td style="	vertical-align: top;">
 	<div id="p" class="easyui-panel" title="Cara Periksa" style="width:600px;height:400px;padding:10px;"
            data-options="tools:[{iconCls:'icon-reload', handler:function(){$('#p').panel('refresh', 'awal.htm');}}]">
            <input type="button" onclick="test();">
            
                <table title="Folder Browser" class="easyui-treegrid" style="width:700px;height:250px"
            data-options="
                url: 'treegrid_data1.json',
                method: 'get',
                rownumbers: true,
                idField: 'id',
                treeField: 'name'
            ">
        <thead>
            <tr>
                <th data-options="field:'name'" width="220">Name</th>
                <th data-options="field:'size'" width="100" align="right">Size</th>
                <th data-options="field:'date'" width="150">Modified Date</th>
            </tr>
        </thead>
    </table>
 
            
            
            
            
            
            
            
            
            
     <!--        <table>
            	<tr>
            		<td onclick="alert('hhhhhhhhhhhhh')">Aspek1</td><td>Aspek2</td>
            	</tr>
            	<tr>
            		<td>Aspek2</td><td>Aspek2</td>
            	</tr>
            	<tr>
            		<td>Aspek3</td><td>Aspek2</td>
            	</tr>
            	<tr>
            		<td>Aspek4</td><td>Aspek2</td>
            	</tr>
            </table>
            -->
    </div>
</td>
<td style="	vertical-align: top;">
 <div id="p2" class="easyui-panel" title="Hasil Periksaan" style="width:400px;height:200px;padding:10px;"
            data-options=" tools:[{iconCls:'icon-reload', handler:function(){$('#p').panel('refresh', 'awal.htm'); } }]">
            <form action="">
	            <label>test</label><input type="text">
	            <input type="submit" value="submit">
            </form>
    </div>
    <br>
     <div id="p3" class="easyui-panel" title="Hasil Periksaan" style="width:400px;height:200px;padding:10px;"
            data-options="
                tools:[{
                    iconCls:'icon-reload',
                    handler:function(){
                        $('#p').panel('refresh', 'awal.htm');
                    }
                }]
            ">
            <form action="">
            <label>test</label><input type="text">
            <input type="submit" value="submit">
            </form>
    </div>
</td>
</tr>

</table>

<script type="text/javascript">
function test(){
	$('#p2').append("<table>"
			+"<tr>"+"<td>aaaaaaaa</td>"+"</tr>"
			+"<tr>"+"<td>bbbbbbbb</td>"+"</tr>"
			+"<tr>"+"<td>cccccccc</td>"+"</tr>"
			+"<tr>"+"<td>dddddddd</td>"+"</tr>"
			+"<tr>"+"<td>eeeeeeee</td>"+"</tr>"
			+"</table>");
}
</script>


</body>

</html>