<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/22/18
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            text-align: center;
            background-color: lavender;
        }

        .header {
            background: rgba(146, 153, 163, .8) ;
            width: 60%;
            display: block;
            margin: 0 auto;
            box-shadow: 0 .4rem .8rem black;

        }

        .studentDiv {
            background-color: red;
            color: white;
            width: 40%;
            display: block;
            margin: 0 auto;
            box-shadow: 0 .4rem .8rem black;
        }
    </style>
</head>
<body>
    <h1 class="header">Currently Viewing Students</h1>
    <c:forEach var="student" items="${allStudents}" >
        <div class="studentDiv">
            <h1>${student.firstName} ${student.lastName}</h1>
            <p>${student.age}</p>
        </div>
    </c:forEach>

</body>
</html>
