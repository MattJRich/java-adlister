<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/21/18
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: blanchedalmond;
            text-align: center;
        }
        .header {
            color: white;
            background-color: gray;
            width: 60%;
            margin: 0 auto;
        }


    </style>
</head>
<body>
    <h1 class="header">Pizza Order</h1>
    <p>Name for order: ${name}</p>
    <p>Address for order: ${address}</p>
    <p>Pizza Size: ${pizzaSize}</p>
    <p>Toppings: </p>
        <c:forEach var="topping" items="${toppings}" >
            <p>${topping}</p>
        </c:forEach>



</body>
</html>
