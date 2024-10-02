<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/18
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UpdateStudentServlet?sid=${studentinfo.sid}" method="post">
    <h2>修改学生信息</h2>
    姓名<input name="name" type="text" value="${studentinfo.sname}"><br>
    <c:if test="${studentinfo.sex == '男'}">
        性别<input type="radio" name="sex" value="男" checked>男
        <input type="radio" name="sex" value="女" >女 <br>
    </c:if>
    <c:if test="${studentinfo.sex == '女'}">
        性别<input type="radio" name="sex" value="男" >男
        <input type="radio" name="sex" value="女" checked >女 <br>
    </c:if>
    电话<input name="phone" value="${studentinfo.phone}"><br>
    <button type="submit">修改</button>
</form>
<form action="FindAllStudent" method="post">
    <button type="submit">查看学生信息</button>
</form>
</body>
</html>
