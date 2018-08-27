<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/25/18
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome to your profile <c:out value="${sessionScope.user.username}" /></h1>
    <c:forEach var="ad" items="${sessionScope.usersAds}" >
       <div>
           <h2><c:out value="${ad.title}" /></h2>
           <p><c:out value="${ad.description}" /></p>
       </div>
    </c:forEach>

    <button><a href="/ads/create">Create Ad</a></button>
    <button><a href="/changePassword">Change Password</a></button>
    <button><a href="/editUsername">Edit username</a></button>
    <button><a href="/logout">Logout</a></button>

</body>
</html>
