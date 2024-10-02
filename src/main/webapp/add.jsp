<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/18
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title></head><body>
<form action="AddStudentServlet" method="post">
    <h2>新增学生</h2>
    姓名<input name="name",type="text"><br>
    性别<input type="radio" name="sex" value="男" checked>男
        <input type="radio" name="sex" value="女" >女 <br>
    电话<input name="phone"><br>
    <button type="submit">添加</button>
</form>
<form action="PageQueryServlet" method="post">
    <button type="submit">查看学生信息</button>
</form>
</body></html>
