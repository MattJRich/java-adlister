<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <p>${sessionScope.user.email}</p>
        <hr>
        <h3>${sessionScope.user.username} Ads: </h3>
        <c:forEach var="ad" items="${sessionScope.userAds}" >
            <div>
                <h5>${ad.title}</h5>
                <p>${ad.description}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
