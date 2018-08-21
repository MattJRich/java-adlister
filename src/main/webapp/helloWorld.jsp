<%@ page import="static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    response.setContentType("text/html");
    PrintWriter myPrint = response.getWriter();
    for (int i = 0; i < 10; i++) {
        myPrint.println(i + ": Hello World<br>");
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>The time on the server is <%= new java.util.Date()%></h1>
    <h1>Hello to uppercased is : <%= new String("Hello").toUpperCase()%></h1>
    <p>25 multiplied by 4 = <%= 25 * 4%></p>
    <p>Is 10 less than 4? <%= 10 < 4 %></p>
</body>
</html>
