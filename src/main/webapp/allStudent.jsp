<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/18
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--页面取出数据--%>
<table border="1">
  <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>电话</th>
    <th colspan="2">操作</th>
  </tr>
<%--  用jstl标签遍历集合--%>
  <c:forEach var="stu" items="${model.data}">
    <tr>
      <td>${stu.sid}</td>
      <td>${stu.sname}</td>
      <td>${stu.sex}</td>
      <td>${stu.phone}</td>
      <td><a href="FindStudentByIdServlet?sid=${stu.sid}">修改</a></td>
      <td><a href="DeleteStudentServlet?sid=${stu.sid}">删除</a></td>
    </tr>
  </c:forEach>
</table>
当前为第${model.pageNum}页<br>
<a href="PageQueryServlet?pageNum=1&pageSize=5">首页</a>
<c:if test="${model.pageNum > 1}">
  <a href="PageQueryServlet?pageNum=${model.pageNum-1}&pageSize=5">上一页</a>
</c:if>
<c:if test="${model.pageNum <= 1}">
  <a>上一页</a>
</c:if>
<c:if test="${model.pageNum < model.maxPageNum}">
  <a href="PageQueryServlet?pageNum=${model.pageNum+1}&pageSize=5">下一页</a>
</c:if>
<c:if test="${model.pageNum >= model.maxPageNum}">
  <a>下一页</a>
</c:if>
<a href="PageQueryServlet?pageNum=${model.maxPageNum}&pageSize=5">尾页</a>
</body>
</html>
