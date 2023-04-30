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
    <title>新增帖子</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h1 class="container">添加新帖子</h1><hr>
<form class="container" action="MessageServlet?statue=insertNewMessage" method="post">
    <table border="3" class="table">
    <tr><th>标题</th> <td><input type="text" name="title"></td></tr>
    <tr><th>发帖人</th> <td><%=session.getAttribute("name")%></td></tr>
    <tr><th>内容</th> <td><textarea type="text" name="content" size="70" style="height: 50px"></textarea></td></tr>
    <tr><td><input type="submit"></td></tr>
    </table>
</form>
</body>
</html>
