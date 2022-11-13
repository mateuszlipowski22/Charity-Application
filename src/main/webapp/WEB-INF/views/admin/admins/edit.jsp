<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../static/header.jsp"/>

<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="m-0 font-weight-bold text-primary">
                Edycja konto administratora<br>
            </h1>
        </div>
        <div class="text-center">
            <h1 class="h4 text-gray-900 mb-4"><br>Wprowadz informacje o edytowanym administratorze</h1>
        </div>
        <form:form modelAttribute="adminDTO" method="post" action="/admin/admins/${adminDTO.id}/edit">
            <div class="form-group">
                <div class="col-sm">
                    <label class="label">Imie</label>
                    <div>
                        <form:input path="name" cssClass="form-control"></form:input>
                    </div>
                    <div>
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
                <div class="col-sm">
                    <label class="label">Nazwisko</label>
                    <div>
                        <form:input path="surname" cssClass="form-control"></form:input>
                    </div>
                    <div>
                        <form:errors path="surname"></form:errors>
                    </div>
                </div>
                <div class="col-sm">
                    <label class="label">Adres Email</label>
                    <div>
                        <form:input path="email" cssClass="form-control"></form:input>
                    </div>
                    <div>
                        <form:errors path="email"></form:errors>
                    </div>
                </div>
                <div class="col-sm">
                    <label class="label">Haslo</label>
                    <div>
                        <form:password path="password" cssClass="form-control"></form:password>
                    </div>
                    <div>
                        <form:errors path="password"></form:errors>
                    </div>
                </div>
                <div class="col-sm">
                    <div class="form-group form-group--buttons">
                        <button class="btn btn-primary btn-user btn-block" type="submit">Edytuj konto admina</button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>

<jsp:include page="../static/footer.jsp"/>