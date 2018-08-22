<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/21/18
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1 align="center">Browse Our Ads!</h1>
    <c:forEach var="ad" items="${allAds}" >
        <div class="ad">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>

        </div>
    </c:forEach>

</div>
</body>
</html>
