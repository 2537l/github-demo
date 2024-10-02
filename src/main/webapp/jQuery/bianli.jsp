<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/9/20
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery练习</title>
</head>
<body>

<table border="1">
  <tr>
    <th>学号</th> <th class="name">姓名</th> <th>性别</th> <th>电话</th> <th>爱好</th> <th>体重</th> <th>密码</th>
  </tr>
  <tr>
    <td>1</td> <td class="name">小白</td> <td>男</td> <td>12345678901</td> <td>打游戏</td> <td>55.4</td> <td><input type="password" value="123"></td>
  </tr>
  <tr>
    <td>2</td> <td class="name">小王</td> <td>男</td> <td>46315728101</td> <td>足球</td> <td>60.3</td> <td><input type="password" value="123"></td>
  </tr>
  <tr>
    <td>3</td> <td class="name">小明</td> <td>女</td> <td>12435675124</td> <td>篮球，跑步</td> <td>40.9</td> <td><input type="password" value="123"></td>
  </tr>
  <tr>
    <td>4</td> <td class="name">小蓝</td> <td>女</td> <td>14356725643</td> <td>跳绳，跑步</td> <td>43.8</td> <td><input type="password" value="123"></td>
  </tr>
  <tr>
    <td>5</td> <td class="name">小红</td> <td>女</td> <td>13542679551</td> <td>打游戏，睡觉</td> <td>45.6</td> <td><input type="password" value="123"></td>
  </tr>
</table>

<script src="jquery-3.7.1.min.js">
</script>
<script>
  $(document).ready(function () {
    //1.姓名列标红
    $("tr").children(".name").css("background-color","red");
    //2.将第三行性别改为人妖
    $("tr").eq(3).children("td").eq(2).text("人妖");
    //3.将第三行的整行字体加粗
    $("tr").eq(3).children("td").css("font-weight","bold");
    //4.将第五行的密码框变成文本框
    $("tr").eq(5).children("td").last().children("input").attr("type","text");
  })
</script>
</body>
</html>
