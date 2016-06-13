<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
    <p>Ошибка:</p>
    <p><c:out value="${errorMessage}"/></p>
    <p><a href="/exit">Выход</a></p>
    <p><a href="${backUrl}">Назад</a></p>
</body>
</html>
