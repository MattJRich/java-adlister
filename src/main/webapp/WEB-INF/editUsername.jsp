<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/25/18
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Current username: <c:out value="${sessionScope.user.username}" /></p>
<form action="/editUsername" method="post">
    <label>New Username</label>
    <input type="text" name="username">
    <button>Submit</button>
</form>
</body>
</html>
