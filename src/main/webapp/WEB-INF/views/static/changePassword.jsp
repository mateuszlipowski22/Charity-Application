<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="header.jsp"/>
    </header>
      <section class="login-page">
        <form:form modelAttribute="userDTO" method="post" action="/changePassword">
          <div class="form-group">
            <h1>Nowe hasło:</h1>
            <form:password path="password"/>
          </div>
          <div class="form-group">
            <h1>Powtórz hasło:</h1>
            <input type="password" name="password2">
          </div>
          <div>
            <form:errors path="password"></form:errors>
          </div>
          <div class="form-group form-group--buttons">
            <input type="hidden" name="id" value="${userDTO.id}"/>
            <form:hidden path="name"></form:hidden>
            <form:hidden path="surname"></form:hidden>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn" type="submit">Zmień haslo</button>
          </div>
        </form:form>
      </section>
<jsp:include page="footer.jsp"/>

