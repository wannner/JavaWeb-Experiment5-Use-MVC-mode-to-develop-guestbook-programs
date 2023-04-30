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
    <title>添加成功</title>
</head>
<body>
<h1 class="container">添加成功！</h1>
<p class="container">即将在3秒钟后返回详情页面</p>
<%
    response.setHeader("Refresh", "3;url=MessageServlet?statue=showAllMessage");
%>
</body>
</html>
