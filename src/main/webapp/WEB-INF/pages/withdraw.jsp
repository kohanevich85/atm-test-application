<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Страница снятия денег</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/js/keyboard.js" />"></script>
    <style type="text/css">body {padding-top: 70px;}</style>
</head>
<body>
<div class="row">
    <div class="col-md-5 col-md-offset-4">
        <form id="form" role="form" action="/withdraw" method="POST">
            <div class="form-group">
                <label>Введите сумму:</label>
                <input id="input1" type="number" name="amount" maxlength="5">
            </div>
            <button id="ok" type="submit" value="ОК">ОК</button>
            <button type="reset" value="Очистить">Очистить</button>
            <a role="button" class="btn btn-primary" href="/exit">Выход</a>
        </form>
        <c:forEach var="i" begin="0" end="9">
            <button class="btn btn-default btn-sm" id="keyboard_${i}">${i}</button>
        </c:forEach>
    </div>
</div>
</body>
</html>
