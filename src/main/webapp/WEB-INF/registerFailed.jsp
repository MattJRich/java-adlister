<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/25/18
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/register" method="post">
    <label>Email</label>
    <input type="text" name="email">
    <label>Username</label>
    <input type="text" name="username">
    <label>Password</label>
    <input type="password" name="password">
    <button>SUBMIT</button>
</form>
    <p>Oops! Either your username or email address has already been used! Please try again</p>
</body>
</html>
