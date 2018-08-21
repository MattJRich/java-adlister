<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        } else {
            response.sendRedirect("/login.jsp");
        }
    }




%>



<html>
<head>
    <title>Title</title>
    <%@ include file="partials/linkMainCss.html" %>
</head>
<body>
   <%@ include file="partials/loginForm.html" %>
</body>
</html>
