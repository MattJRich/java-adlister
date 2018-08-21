<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] names = {"matt", "chris", "zach"};
    request.setAttribute("allNames", names);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="stuff" value="<%= new java.util.Date()%>"/>
    <c:forEach var="name" items="${allNames}">
        ${name}<br>
    </c:forEach>


Time on the server is ${stuff}


</body>
</html>
