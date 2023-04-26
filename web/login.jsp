<%--
  Created by IntelliJ IDEA.
  User: wannner
  Date: 2023/4/26
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h1 class="container">贴吧管理-登陆页面</h1>
<br>
<form action="login" class="container" method="post">
    <table class="table" border="3">
        <tr>
            <td>用户id</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="id"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
