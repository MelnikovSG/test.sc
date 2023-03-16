<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<body>
<h2>All services</h2>
<br>
<table>
    <tr>
        <th>Service name: </th>
        <th>User name: </th>
        <th>Date: </th>
        <th>Application number: </th>
    </tr>
    <c:forEach var="emp" items="${allServices}">
        <tr>
            <td>${emp.serviceName}</td>
            <td>${emp.userName}</td>
            <td>${emp.createdDate}</td>
            <td>${emp.serviceName}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>