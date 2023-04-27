<%--
  Created by IntelliJ IDEA.
  User: wannner
  Date: 2023/4/26
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子删除</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h1 class="container">删除成功！</h1>
<p class="container">即将在3秒钟后返回列表页面</p>
<%
    response.setHeader("Refresh", "3;url=MessageServlet?id=<%=request%>");
%>
</body>
</html>
