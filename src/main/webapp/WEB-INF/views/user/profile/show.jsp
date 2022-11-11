<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../../static/header.jsp"/>
    </header>

    <section class="login-page">
      <h2>Strona użytkownia ${currentUserDTO.name}</h2>
        <div class="form-group">
          <h2>Imie: ${currentUserDTO.name}</h2>
        </div>
        <div class="form-group">
          <h2>Nazwisko: ${currentUserDTO.surname}</h2>
        </div>
        <div class="form-group">
          <h2>Adress email: ${currentUserDTO.email}</h2>
        </div>
        <div class="form-group form-group--buttons">
          <a href="login.html" class="btn btn--without-border">Edytuj dane</a>
          <a href="login.html" class="btn btn--without-border">Moje Zbiórki</a>
        </div>
    </section>

<jsp:include page="../../static/footer.jsp"/>

