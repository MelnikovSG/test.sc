<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script>
        function showAlert(message) {
            alert(message);
        }

        function handleSubmit() {
            var isServiceSaved = '${services.serviceSaved}';

            if (isServiceSaved === 'true') {
                showAlert('Услуга была успешно предоставлена!');
            } else {
                showAlert('Услуга не была оказана, попробуйте позднее.');
                return false;
            }
        }
    </script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Форма оказания услуги</h2>
<br>
<form:form action="saveService" modelAttribute="services" accept-charset="UTF-8" onsubmit="return handleSubmit()">
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
<br><br>
<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/logout'">Выход</button>

<security:authorize access="hasRole('ADMIN')">
    <button onclick="location.href='${pageContext.request.contextPath}/admin'" type="button">Админка</button>
</security:authorize>

</body>
</html>
