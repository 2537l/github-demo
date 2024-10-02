<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/30
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="FIleUpLoadServlet" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="sname"><br>
    头像：<input type="file" name="photo"><br>
    <button type="submit">提交</button>
</form>
</body>
</html>
