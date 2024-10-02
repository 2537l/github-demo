<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/19
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax案例：用户名是否存在验证</title>
</head>
<body>
输入用户名:<input type="text" name="sname" id="sname"><span id="show"></span>

<%--ajax请求写在<script>标签中--%>
<script>
  //1.创建XMLHttpRequest对象，几乎所有内容都是在该对象里面
  //作用：1.在后台从客户端发送数据。2.从服务器接收数据。3.更新网页而不重新加载
  //**对不同的浏览器有不同的对象需要创建
  var httpRequest = new XMLHttpRequest();
  //2.建立ajax请求（请求方式，请求地址，是否异步（true））
  var sname = document.getElementById("sname").value;
  httpRequest.open("get","AjaxServlet?name="+sname,true);
  //3.发送ajax请求(如果是Post请求要在send方法中填写参数)
  //**post方法，必须设置请求头，而且要放在send方法前面
  //设置请求头
  //**xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  httpRequest.send();
  //4.设置回调函数
  httpRequest.onreadystatechange=function (){
      if(httpRequest.readyState == 4 && httpRequest.status==200){
          //readyState=4，代表响应就绪；status=200，代表后台正确处理请求
          //后台处理完成以后，要做什么事情，就写在这里
          document.getElementById("show").innerHTML=httpRequest.responseText;
      }
  }

</script>
</body>
</html>
