<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/2
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User</title>
</head>
<body>
    <table width="60%" border="0">
        <c:forEach items="${userList}" var="user">
            <tr>
                <td> <font color="red">${user.userName}</font> </td>
                <td> <font color="red">${user.passWord}</font> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
