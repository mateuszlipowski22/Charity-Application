<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Oddam w dobre ręce</title>

    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>
</head>
<body>

<c:if test="${pageContext.request.requestURL=='http://localhost:8080/WEB-INF/views/static/index.jsp'}">
<header class="header--main-page">
</c:if>

<c:if test="${pageContext.request.requestURL=='http://localhost:8080/WEB-INF/views/user/donation/form.jsp'}">
<header class="header--main-page">
</c:if>

<c:if test="${pageContext.request.requestURL!='http://localhost:8080'}">
<header class="header">
</c:if>">

    <nav class="container container--70">

        <sec:authorize access="isAuthenticated()">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj <sec:authentication property="principal.username"/>
                <ul class="dropdown">
                    <li><a href="/user/profile/show">Profil</a></li>
                    <li><a href="/user/donation/all">Moje zbiórki</a></li>
                    <li><a href="#" onclick="document.getElementById('myForm').submit();">Wyloguj</a></li>

                    <form action="<c:url value="/logout"/>" method="post" id="myForm">
                        <a href="#" onclick="document.getElementById('myForm').submit();">Wyloguj</a>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>

                </ul>
            </li>
        </ul>
        </sec:authorize>

        <sec:authorize access="isAnonymous()">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>
        </sec:authorize>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <sec:authorize access="hasRole('USER')">
            <li><a href="/user/donation/add" class="btn btn--without-border">Przekaż dary</a></li>
            </sec:authorize>
            <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>