<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/21/18
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/pizza" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name">
    <label for="address">Address</label>
    <input type="text" id="address" name="address">
    <label for="pizzaSize">Pizza Size</label>
    <select name="pizzaSize" id="pizzaSize">
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
    </select>
    <br>
    <input type="checkbox" name="topping" value="ham">Ham<br>
    <input type="checkbox" name="topping" value="sausage">Sausage<br>
    <input type="checkbox" name="topping" value="onion">Onion<br>
    <input type="checkbox" name="topping" value="mushroom">Mushroom<br>
    <input type="checkbox" name="topping" value="pepperoni">Pepperoni<br>
    <button>Submit</button>

</form>

</body>
</html>
