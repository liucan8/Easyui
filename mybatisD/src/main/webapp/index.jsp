<html>
<head>
    <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="js/jquery/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery/themes/icon.css" />
    <script type="text/javascript" src="js/jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
    <script type="text/javascript" src="js/jquery.alerts.js"></script>
    <script>
        function checkName(){
            $.ajax({
                type: 'POST',
                url: 'mvc/showList.do',
                dataType: 'json',
                data:{
                   'user_name':'lc'
                },
                success: function(data){
                    alert(JSON.stringify(data));
                    if(data.isExist == 'fail'){
                        //jAlert('user is already existing...');

                        //$('#err1').html('<font color="red">user is already existing...</font>');
                    }else{
                        $('#err1').html('');
                    }
                }
            });
        }

        function get2vm(){
            $('#code').qrcode("Hello World!");
        }
        function enCodeUrl(){
            var url = "test.jsp?"+escape("name=lc&passw=123");
            alert(url);
        }

        //将表单数据转为json
        function form2Json(id) {

            var arr = $("#" + id).serializeArray();
            var jsonStr = "";

            jsonStr += '{';
            for (var i = 0; i < arr.length; i++) {
                jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",';
            }
            jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
            jsonStr += '}';

            var json = JSON.parse(jsonStr);
            return json;
        }

        function showJson(){
            var json = form2Json("form1");
            console.info(json);
        }
        $(function(){
            $('#t1').datagrid({
                url:'mvc/showList.do',
                striped:true,
                queryParams:{

                },
                toolbar: [{
                    iconCls: 'icon-edit',
                    handler: function(){alert('编辑按钮')}
                },'-',{
                    iconCls: 'icon-help',
                    handler: function(){alert('帮助按钮')}
                }],
                columns:[[
                    {field:'user_id',title:'userId',width:100},
                    {field:'user_name',title:'userName',width:100},
                    {field:'user_passWord',title:'userPassWord',width:100},
                    {field:'create_time',title:'createTime',width:100}
                ]]
            });

            $('#sear').click(function(){
                $('#t1').datagrid('load',{});
            });
        });
    </script>
</head>
<body>
<form id="form1" action="mvc/saveGrade.do" method="post">
    <input type="text" id="uname" name="user_name" onblur="checkName()" /><div id="err1"></div><%--onblur="checkName()"--%>
    <input type="text" id="passw" name="user_passWord" /><br />
    <input type="text" class="easyui-datebox" id="d1" name="create_time" required="required" onblur="showJson()" /><br />
    <input type="submit" value="register" />
</form>
<input type="button" value="get2VM" onclick="get2vm()" />
<input type="button" value="urlEncode" onclick="enCodeUrl()" />
<div id="code"></div>
<div id="magazineGrid">
</div>

<table class="easyui-datagrid" id="t1" data-options="fitColumns:true">
   <%-- <thead>
        <th data-options="field:'phone',width:100">phone</th>
        <th data-options="field:'sex',width:100">sex</th>
        <th data-options="field:'name',width:100">name</th>
    </thead>--%>
</table>
<input type="button" id="sear" value="search" />
</body>
</html>
