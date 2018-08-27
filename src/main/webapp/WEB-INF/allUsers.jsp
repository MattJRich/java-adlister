<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/25/18
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="username" items="${usernames}" >
        <h1><c:out value="${username}" /></h1>
    </c:forEach>

</body>
</html>
