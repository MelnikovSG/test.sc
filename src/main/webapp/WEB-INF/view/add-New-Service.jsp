<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%--    <script>--%>
<%--        function showAlert() {--%>
<%--            alert("Услуга была успешно предоставлена!");--%>
<%--        }--onsubmit="showAlert()"%>
<%--    </script>--%>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Форма оказания услуги</h2>
<br>
<form:form action="saveService" modelAttribute="services"  accept-charset="UTF-8">
    Имя <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Фамилия <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Отчество <form:input path="surName"/>
    <form:errors path="surName" cssClass="error"/>
    <br><br>
    Наименование услуги <form:select path="serviceName">
    <form:option value="Выдача охотничьего билета" label="Выдача охотничьего билета"/>
    <form:option value="Запись ребенка в первый класс" label="Запись ребенка в первый класс"/>
</form:select>
    <br><br>
    e-mail <form:input path="eMail"/>
    <form:errors path="eMail" cssClass="error"/>
    <br><br>
    <input type="submit" value="Отправить">
</form:form>
<br>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/All-Services'">Отмена</button>
</body>
</html>