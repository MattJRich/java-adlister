<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String makeItLowercase(String input) {
        return input.toLowerCase();
    }
%>
<%
    PrintWriter myPrint = response.getWriter();
    response.setContentType("text/html");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        for (int i = 0; i < 5; i++) {
            myPrint.println("I love to code<br>");

        }
    %>
    <h1><%= makeItLowercase("Hello World")%></h1>

</body>
</html>
