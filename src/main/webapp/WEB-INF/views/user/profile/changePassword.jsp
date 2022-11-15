<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../../static/header.jsp"/>
    </header>

    <section class="login-page">
      <form:form modelAttribute="userDTO" method="post" action="/user/profile/changePassword">
        <div class="form-group">
          <h1>Nowe hasło:</h1>
          <form:password path="password"/>
        </div>
        <div>
          <form:hidden path="password"></form:hidden>
        </div>
        <div class="form-group form-group--buttons">
          <input type="hidden" name="id" value="${userDTO.id}"/>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <button class="btn" type="submit">Zmień haslo</button>
        </div>
      </form:form>
    </section>

<jsp:include page="../../static/footer.jsp"/>

