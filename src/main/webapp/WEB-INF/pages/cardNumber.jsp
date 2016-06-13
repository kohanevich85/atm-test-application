<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница ввода номера карты</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
    <script src="<c:url value="/js/cardNumber.js" />"></script>
</head>
<body>
<div class="container-fluid">
<p>Для начала работы введите 16-ти значный номер карты:</p><br>
<form id="cardNumberForm" role="form" action="/cardNumber" method="POST">
    <div class="form-group">
        <label for="cardNumber1">Номер карты:</label>
        <input disabled id="cardNumber1" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4"> -
        <input disabled id="cardNumber2" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4"> -
        <input disabled id="cardNumber3" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4"> -
        <input disabled id="cardNumber4" type="text" name="cardNumber" placeholder="1111" maxlength="4" size="4">
    </div>
    <button id="ok" class="btn btn-default" type="submit">ОК</button>
    <button class="btn btn-default" type="reset">Очистить</button>
</form>
    <button class="btn btn-default btn-sm" id="keyboard_1">1</button>
    <button class="btn btn-default btn-sm" id="keyboard_2">2</button>
    <button class="btn btn-default btn-sm" id="keyboard_3">3</button>
    <button class="btn btn-default btn-sm" id="keyboard_4">4</button>
    <button class="btn btn-default btn-sm" id="keyboard_5">5</button>
    <button class="btn btn-default btn-sm" id="keyboard_6">6</button>
    <button class="btn btn-default btn-sm" id="keyboard_7">7</button>
    <button class="btn btn-default btn-sm" id="keyboard_8">8</button>
    <button class="btn btn-default btn-sm" id="keyboard_9">9</button>
    <button class="btn btn-default btn-sm" id="keyboard_0">0</button>
</div>
</body>
</html>

