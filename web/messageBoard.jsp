<%@ page import="factory.DAOFactory" %>
<%@ page import="vo.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wannner
  Date: 2023/4/26
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%
    List<Message> list=(List<Message>) session.getAttribute("messageList");
    System.out.println(list.toString());
    int cnt=1;
%>
<div class="container">
    <h1 class="container">帖子管理</h1>
    <h4><%="你好!" + session.getAttribute("name")%></h4>
    <a href="logout.jsp">注销登录</a>
    <hr>
    <a class="container" href="newMessage.jsp">新增帖子</a>
    <table class="table" border="3">
        <tr><th>帖子ID</th> <th>标题</th> <th>内容</th> <th>作者</th> <th>最后修改时间</th> <th>删除</th></tr>
        <%
            for (Message message : list) {
                %>
        <tr>
        <td><%=message.getMessageID()%></td>
            <td><a href="MessageServlet?statue=showMessage&id=<%=message.getMessageID()%>"><%=message.getTitle()%></a></td>
        <td><%=message.getContent()%></td>
        <td><%=message.getWriter()%></td>
        <td><%=message.getWriterDate()%></td>
            <%
                if(message.getWriter().equals(session.getAttribute("name"))){//是本人发的帖子
                    %>
        <td><a href="MessageServlet?statue=deleteMessage&id=<%=message.getMessageID()%>">删除</a></td>
        <%
                }
            %>
        <%
            }
        %>
        </tr>
    </table>
</div>
</body>
</html>
