<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../../static/header.jsp"/>
    </header>

    <section class="login-page">
      <form:form modelAttribute="userDTO" method="post" action="/user/profile/edit">
        <div class="form-group">
          <h1>Imie:</h1>
          <form:input path="name"/>
        </div>
        <div>
          <form:errors path="name"></form:errors>
        </div>
        <div class="form-group">
          <h1>Nazwisko:</h1>
          <form:input path="surname"/>
        </div>
        <div>
          <form:errors path="surname"></form:errors>
        </div>
        <div class="form-group">
          <h1>Adres email:</h1>
          <form:input path="email"/>
        </div>
        <div>
          <form:errors path="email"></form:errors>
        </div>

        <div class="form-group form-group--buttons">
          <a href="/user/profile/${userDTO.id}/changePassword" class="btn btn--without-border">Zmien haslo</a>
          <input type="hidden" name="id" value="${userDTO.id}"/>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <button class="btn" type="submit">Edytuj dane</button>
        </div>
      </form:form>
    </section>

<jsp:include page="../../static/footer.jsp"/>

