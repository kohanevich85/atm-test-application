<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Страница баланса</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <style type="text/css">body {padding-top: 70px;}</style>
</head>
<body>
<div class="row">
    <div class="col-md-5 col-md-offset-4">
        <p>Баланс вашего счета:</p>
        <p>Номер карты: <c:out value="${sessionScope.card.cardNumber}"/></p>
        <p>Дата: <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="<%=new Date()%>"/>   </p>
        <p>Баланс: <c:out value="${sessionScope.card.amount}"/></p>
        <a role="button" class="btn btn-primary" href="/options">Назад</a>
        <a role="button" class="btn btn-primary" href="/exit">Выход</a>
    </div>
</div>
</body>
</html>
