<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>
    </header>

    <section class="login-page">
      <h2>Zapomniane haslo - wprowadz adres email do konta</h2>
      <form:form modelAttribute="userDTO" method="post" action="/forgottenPassword">
        <div class="form-group">
          <form:input path="email" placeholder="Email"/>
          <form:errors path="email"></form:errors>
        </div>
        <div class="form-group form-group--buttons">
            <form:hidden path="name"></form:hidden>
            <form:hidden path="surname"></form:hidden>
            <form:hidden path="password"></form:hidden>
            <button class="btn" type="submit">Zatwierdź</button>
        </div>
        </form:form>
    </section>

<jsp:include page="footer.jsp"/>

