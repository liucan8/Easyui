<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/9
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user list</title>
    <link rel="stylesheet" type="text/css" href="../js/jqui/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../js/jqui/icon.css" />
    <script type="text/javascript" src="../js/jqui/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jqui/jquery.easyui.min.js"></script>

    <script>
        $(function(){
            $('#tt').datagrid({
                      url:'datagrid_data.json',
                columns:[[
                          {field:'itemid',title:'Item ID',rowspan:2,width:80,sortable:true},
                          {field:'productid',title:'Product ID',rowspan:2,width:80,sortable:true},
                          {title:'Item Details',colspan:4}
                      ],[
                          {field:'listprice',title:'List Price',width:80,align:'right',sortable:true},
                          {field:'unitcost',title:'Unit Cost',width:80,align:'right',sortable:true},
                          {field:'attr1',title:'Attribute',width:100},
                          {field:'status',title:'Status',width:60}
                     ]]
            });
        });
    </script>
</head>
<body>
<table id="tt"></table>
</body>
</html>
