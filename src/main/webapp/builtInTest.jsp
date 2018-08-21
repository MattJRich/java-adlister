<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="partials/myHeader.html" />
    <jsp:include page="partials/myFooter.jsp" />

    <p>Request User Agent: <%= request.getHeader("User-Agent") %></p>
    <p>Request Language: <%=request.getLocale()%></p>

</body>
</html>
