<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>
    </header>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form modelAttribute="userDTO" method="post" action="/register">
        <div class="form-group">
          <form:input path="name" placeholder="Imie"/>
          <form:errors path="name"></form:errors>
        </div>
        <div class="form-group">
          <form:input path="surname" placeholder="Nazwisko"/>
          <form:errors path="surname"></form:errors>
        </div>
        <div class="form-group">
          <form:input path="email" placeholder="Email"/>
          <form:errors path="email"></form:errors>
        </div>
        <div class="form-group">
          <form:password path="password" placeholder="Hasło"/>
          <form:errors path="password"></form:errors>
        </div>
        <div class="form-group">
          <input type="password" name="password2" placeholder="Powtórz hasło">
        </div>
        <div class="form-group form-group--buttons">
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
        </form:form>
    </section>

<jsp:include page="footer.jsp"/>

