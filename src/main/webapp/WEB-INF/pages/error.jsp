<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ошибка</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <style type="text/css">body {padding-top: 70px;}</style>
</head>
<body>
<div class="row">
    <div class="col-md-5 col-md-offset-4">
        <div class="alert alert-danger"><strong>Ошибка:</strong>
            <c:out value="${errorMessage}"/>
        </div>
        <a role="button" class="btn btn-primary" href="/exit">Выход</a>
        <a role="button" class="btn btn-primary" href="${backUrl}">Назад</a>
    </div>
</div>
</body>
</html>
