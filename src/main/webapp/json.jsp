<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/19
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON</title>
</head>
<body>

<button type="button" onclick="query()">查询所有学生信息</button>
<div id="allStudentInfo"></div>

<script>
  //json字符串默认会被定义为对象
  var stu1 = {"sid":"001", "sname":"小白", "sex":"男"}
  alert(stu1);
  //将整个json对象改成字符串则变成了json字符串
  var stu2 = "{\"sid\":\"001\", \"sname\":\"小白\", \"sex\":\"男\"}"
  alert(stu2);
  //利用eval()方法将json字符串转为对象
  var stu3 = eval("("+stu2+")");
  alert(stu3)
  alert(stu3.sid)
  function query(){
      //ajax请求
      //1.创建XMLHttpRequest对象
      var httpRequest = new XMLHttpRequest();
      //2.建立ajax请求
      httpRequest.open("get","JSONServlet","true")
      //3.获取ajax请求
      httpRequest.send();
      //4.设置回调函数
      httpRequest.onreadystatechange=function (){
          if(httpRequest.readyState == 4 && httpRequest.status==200){
              //readyState=4，代表响应就绪；status=200，代表后台正确处理请求
              //后台处理完成以后，要做什么事情，就写在这里
              var table = "<table border='1'> <tr> <th>学号</th> <th>姓名</th> <th>性别</th> <th>电话</th> </tr>"
              //将响应数据中的json字符串转成List对象
              var list = eval("("+httpRequest.responseText+")");
              list.forEach (function (stu,index) {
                  var str = "<tr> <td>"+stu.sid+"</td>  <td>"+stu.sname+"</td> <td>"+stu.sex+"</td> <td>"+stu.phone+"</td></tr>"
                  table += str;
              });
              table += "</table>"
              document.getElementById("allStudentInfo").innerHTML=table;
          }
      }
  }

</script>
</body>
</html>
