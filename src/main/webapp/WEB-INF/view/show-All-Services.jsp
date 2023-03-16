<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All services</h2>
<br>
<table>
    <tr>
        <th>Date:</th>
        <th>Application number:</th>
        <th>Service name:</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${allServices}">
        <c:url var="moreButton" value="/more-info">
            <c:param name="empId" value="${emp.id}"/>

        </c:url>
        <tr>
            <td>${emp.createdDate}</td>
            <td>${emp.id}</td>
            <td>${emp.serviceName}</td>
            <td>
                <input type="button" value="More" onclick="window.location.href = '${moreButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/'">Add service</button>
</body>
</html>