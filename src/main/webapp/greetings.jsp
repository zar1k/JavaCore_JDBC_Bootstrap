<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful</title>
</head>
<body>
<jsp:useBean id="user" scope="session" class="webproject.models.User"/>
<h3>Login Successful!</h3><br>

Name: ${user.firstName} <br>
Surname: ${user.lastName} <br>
</body>
</html>
