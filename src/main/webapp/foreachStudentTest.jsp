<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/20/18
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.luv2code.jsp.Student" %>
<%
    List<Student> data = new ArrayList<>();
    data.add(new Student("Matt", "rich", false));
    data.add(new Student("greg", "roh", true));
    data.add(new Student("berry", "toot", false));

    request.setAttribute("myStudents", data);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gold customer</th>
        </tr>
        <c:forEach var="student" items="${myStudents}">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.goldCustomer}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
