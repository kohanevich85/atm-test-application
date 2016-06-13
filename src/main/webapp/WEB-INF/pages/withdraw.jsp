<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница снятия денег</title>
</head>
<body>
<form action="/withdraw" method="POST">
    <p><b>Введите сумму:</b></p>
    <p><input type="number" name="amount" maxlength="5"></p>
    <p><input type="submit" value="ОК"></p>
    <p><input type="reset" value="Очистить">
    <p><a href="/exit">Выход</a></p>
</form>
</body>
</html>
