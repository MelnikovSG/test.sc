<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Карточка с информацией об оказанной услуге</h2>
<br>
<form:form modelAttribute="services">
    Имя <form:input path="firstName"/>
    <br><br>
    Фамилия <form:input path="lastName"/>
    <br><br>
    Отчество <form:input path="surName"/>
    <br><br>
    Дата оказания <form:input path="createdDate"/>
    <br><br>
    Наименование услуги <form:input path="serviceName"/>
    <br><br>
    Номер <form:input path="id"/>
    <br><br>
</form:form>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/All-Services'">Вернуться</button>
</body>
</html>