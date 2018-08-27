<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/25/18
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Current username: <c:out value="${sessionScope.user.username}" /></p>
<p>That username is already taken please try a different one</p>
<form action="/editUsername" method="post">
    <label>New Username</label>
    <input type="text" name="username">
    <button>Submit</button>
</form>
</body>
</html>
