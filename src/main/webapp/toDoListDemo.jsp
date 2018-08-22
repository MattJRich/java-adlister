<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/22/18
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="toDoListDemo.jsp" method="post">
        Add new item: <input type="text" name="item">
        <button>Submit</button>
    </form>
    <hr>
    Item entered: <%= request.getParameter("item") %>

<%
    PrintWriter myPrint = response.getWriter();
    List<String> items = (List<String>) session.getAttribute("myToDoList");
    if (items == null) {
        items = new ArrayList<String>();
        session.setAttribute("myToDoList", items);
    }

    String theItem = request.getParameter("item");
    if (theItem != null) {
        items.add(theItem);
    }
%>
<p>To do list: </p>

    <ol>
        <%
            for (String item: items) {
                myPrint.println(
                        item
                );

            }
        %>
    </ol>

</body>
</html>
