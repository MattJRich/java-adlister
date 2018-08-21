<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] cities = {"New York", "Philly", "San antonio"};
    request.setAttribute("allCities", cities);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="city" items="${allCities}">
        ${city}<br>
    </c:forEach>
</body>
</html>
