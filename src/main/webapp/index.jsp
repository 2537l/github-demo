<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<h1>${msg}</h1><!--作用：从session，application等作用域中取值-->
<form action="HttpServletDemo" method="post">
    用户名<input name="username">
    密码<input name="password" type="password">

    <button type="submit">登录</button>



</form>
<form action="LastLoginTimeServlet" method="get">
    <button type="submit">登录查看</button></form>
</body>
