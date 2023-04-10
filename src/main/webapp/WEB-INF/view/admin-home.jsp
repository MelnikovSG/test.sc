<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Home</title>
</head>
<body>
<h1>Привет, Админ!</h1>
<br><br>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/'">Оказать услугу</button>
<br><br>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/All-Services'">Все оказанные услуги
</button>
<br><br>
<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/logout'">Выход</button>
<br><br>
</body>
</html>