<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/21/18
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Nice guess! ${number} is correct! ${guess}</h1>
    <form action="http://localhost:8080/guess">
        <button>Guess Again</button>
    </form>
</body>
</html>
