<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Список всех оказанных услуг</h2>
<br>
<table>
    <tr>
        <th>Дата создания:</th>
        <th>Номер:</th>
        <th>Наименование услуги:</th>
        <th>Операции:</th>
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
                <input type="button" value="Подробно" onclick="window.location.href = '${moreButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/'">Получить услугу</button>
</body>
</html>