<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (!request.getParameter("username").equals("admin")) {
        response.sendRedirect("/login.jsp");
    }
%>





<html>
<head>
    <title>Title</title>
    <%@include file="partials/linkMainCss.html"%>
</head>
<body>
    <h1>Hello <%= request.getParameter("username") %>!</h1>

</body>
</html>
