<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/21/18
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${guess} was you number.. You need to guess HIGHER!! ${number}</h1>
    <form action="http://localhost:8080/guess">
        <button>Guess Again</button>
    </form>

</body>
</html>
