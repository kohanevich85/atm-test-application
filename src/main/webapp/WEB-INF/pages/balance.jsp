<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Страница баланса</title>
</head>
<body>
    <c:set var="now" value="<%=new Date()%>"/>
    <p>Баланс вашего счета:</p>
    <p>Номер карты:<c:out value="${sessionScope.card.cardNumber}"/></p>
    <p>Дата: <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}"/>   </p>
    <p>Баланс:<c:out value="${sessionScope.card.amount}"/></p>
    <p><a href="/options">Назад</a></p>
    <p><a href="/exit">Выход</a></p>
</body>
</html>
