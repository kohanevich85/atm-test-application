<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница ввода ПИН-кода</title>
    <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/js/card.js" />"></script>
</head>
<body>
<div>Введите 4-х значный пин код:</div>
<form action="/pinCode" method="POST">
    <p><input id="pinCode" type="password" name="pinCode" placeholder="****" pattern="[0-9]{4}" size="4 " maxlength="4"><br>
    <p><input type="submit" value="ОК"></p>
    <p><input type="reset" value="Очистить">
    <p><a href="/exit">Выход</a></p>
</form>
</body>
</html>
