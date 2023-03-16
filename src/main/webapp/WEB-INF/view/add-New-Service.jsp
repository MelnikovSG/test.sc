<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Services info</h2>
<br>
<form:form action="saveService" modelAttribute="services">
    Firstname <form:input path="firstName"/>
    <br><br>
    Lastname <form:input path="lastName"/>
    <br><br>
    Surname <form:input path="surName"/>
    <br><br>
    Service name <form:input path="serviceName"/>
    <br><br>
    Email <form:input path="eMail"/>
    <br><br>
    <input type="submit" value="Send">
</form:form>
<button type="button" onclick="window.location.href='http://localhost:8081/test_sc/All-Services'">Cancel</button>
</body>
</html>