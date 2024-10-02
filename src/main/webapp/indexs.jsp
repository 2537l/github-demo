<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/13
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Check.jsp" method="post">
    <input name="checkCode" type="text" id="checkCode"/>
    <img src="CodeServlet" id="CreateCheckCode" align="middle">
    <a href="" onclick="myReload()"> 看不清,换一个</a>
    <input type="submit" value="提交" />
</form>

</body>
</html>
