<%--
  Created by IntelliJ IDEA.
  User: wannner
  Date: 2023/4/26
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CHECK</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%
    String name=(String) request.getAttribute("name");
    System.out.println(name);
    if (name == null) {
%>
<div class="container">
    <h1 class="container">账号或密码输入错误！</h1>
    <a class="container" href="login.jsp">请重新登录！</a>
</div>

<%
    }else{
        session.setAttribute("name",name);
        %>
<div class="container">
    <h1 class="container"><%=name%>,登陆成功！</h1>
    <a class="container" href="messageBoard.jsp">进入列表页面</a>
</div>

<%
    }
%>
</body>
</html>
