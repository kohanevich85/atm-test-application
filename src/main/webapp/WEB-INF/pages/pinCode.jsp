<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница ввода ПИН-кода</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/js/keyboard.js" />"></script>
    <style type="text/css">body {padding-top: 70px;}</style>
</head>
<body>
    <div class="row">
        <div class="col-md-5 col-md-offset-4">
            <p>Введите 4-х значный пин код:</p>
            <form role="form" id="form" action="/pinCode" method="POST">
                <div class="form-group">
                    <label>Пин код:</label>
                    <input autocomplete="off" id="input1" type="password" name="pinCode" placeholder="****" pattern="[0-9]{4}" size="4 " maxlength="4">
                </div>
                <button id="ok" class="btn btn-default" type="submit">ОК</button>
                <button class="btn btn-default" type="reset">Очистить</button>
                <a role="button" class="btn btn-primary" href="/exit">Выход</a>
            </form>
            <c:forEach var="i" begin="0" end="9">
                <button class="btn btn-default btn-sm" id="keyboard_${i}">${i}</button>
            </c:forEach>
        </div>
    </div>
</body>
</html>
