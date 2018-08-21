<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/21/18
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="theToDoList.jsp">
        Add New item: <input type="text" name="item">
        <button>Submit</button>
    </form>
    <hr>
Item entered: <%= request.getParameter("item")%>
<%
    List<String> items = (List<String>) session.getAttribute("myToDoList");
    if (items == null) {
        items = new ArrayList<String>();
        session.setAttribute("myToDoList", items);
    }

%>
</body>
</html>
