<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница отчета о результате операции</title>
</head>
<body>
    <c:set var="now" value="<%=new Date()%>"/>
    <p>Операция прошла успешно</p>
    <p>Номер карты:<c:out value="${sessionScope.card.cardNumber}"/></p>
    <p>Дата: <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}"/></p>
    <p>Баланс:<c:out value="${sessionScope.card.amount}"/></p>
    <p>Выдано:${amount}</p>
    <a href="/options">Назад</a>
    <a href="/exit">Выход</a>
</body>
</html>
