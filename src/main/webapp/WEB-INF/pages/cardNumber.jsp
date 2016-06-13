<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница ввода номера карты</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/js/keyboard.js" />"></script>
    <style type="text/css">body {padding-top: 70px;}</style>
</head>
<body>
    <div class="row">
        <div class="col-md-5 col-md-offset-4">
            <p>Для начала работы введите 16-ти значный номер карты:</p><br>
            <form id="form" role="form" action="/cardNumber" method="POST">
                <div class="form-group">
                    <label>Номер карты:</label>
                    <input id="input1" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4"> -
                    <input id="input2" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4"> -
                    <input id="input3" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4"> -
                    <input id="input4" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4">
                </div>
                <button id="ok" class="btn btn-default" type="submit">ОК</button>
                <button class="btn btn-default" type="reset">Очистить</button>
            </form>
            <c:forEach var="i" begin="0" end="9">
                <button class="btn btn-default btn-sm" id="keyboard_${i}">${i}</button>
            </c:forEach>
        </div>
    </div>
</body>
</html>

