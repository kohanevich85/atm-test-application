<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница операций</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <style type="text/css">body {padding-top: 70px;}</style>
</head>
<body>
<div class="row">
    <div class="col-md-5 col-md-offset-4">
        <div>Выберети одну из опций:</div><br>
        <a role="button" class="btn btn-primary" href="/balance">Баланс</a>
        <a role="button" class="btn btn-primary" href="/withdraw">Снять сумму</a>
        <a role="button" class="btn btn-primary" href="/exit" >Выход</a>
    </div>
</div>
</body>
</html>
