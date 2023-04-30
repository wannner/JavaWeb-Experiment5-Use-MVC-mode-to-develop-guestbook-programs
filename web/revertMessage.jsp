<%@ page import="vo.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="vo.Revert" %><%--
  Created by IntelliJ IDEA.
  User: wannner
  Date: 2023/4/26
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子详情</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%
    Message message=(Message)session.getAttribute("message");
    List<Revert> list=(List<Revert>) session.getAttribute("revertList");
    int cnt=1;
%>
<h1 class="container">帖子详情</h1>
<a class="container" href="messageBoard.jsp">返回帖子列表</a>
<table class="table container" border="3">
    <tr> <th>帖子序号</th> <td><%=message.getMessageID()%></td></tr>
    <tr> <th>标题</th> <td><%=message.getTitle()%></td></tr>
    <tr> <th>内容</th> <td><%=message.getContent()%></td></tr>
    <tr> <th>作者</th> <td><%=message.getWriter()%></td></tr>
    <tr> <th>创建时间</th> <td><%=message.getWriterDate()%></td></tr>
</table>
<br>
<h2 class="container">回帖详情</h2>
<table class="container" border="3">
    <tr> <th>楼层</th> <th>内容</th> <th>回帖者</th> <th>回帖时间</th> <th>删除</th> </tr>
    <%
        for (Revert revert : list) {
            %>
    <tr>
        <td><%=cnt++%></td> <td><%=revert.getContent()%></td> <td><%=revert.getWriter()%></td> <td><%=revert.getWriterDate()%></td>
        <%
        if(session.getAttribute("name").equals(revert.getWriter())){//是本人发的帖子
        %>
        <td><a>删除</a></td>
            <%
                }
        %>
    </tr>
    <%
        }
    %>
</table>
<br><br>
<form class="container" action="RevertServlet?statue=insertRevert&id=<%=message.getMessageID()%>" method="post">
    内容：<textarea type="text" name="content" size="70" style="height: 50px"></textarea>
    <input type="submit">

</form>

</body>
</html>
