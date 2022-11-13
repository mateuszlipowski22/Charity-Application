<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../static/header.jsp"/>

<div class="container-fluid">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="m-0 font-weight-bold text-primary">Zmiana dostępu użytkownika</h1>
        </div>
        <div class="card-body">
            <div class="form-group">
                <p class="title" style="marker-offset: 30px">Czy na pewno chcesz
                    <c:if test="${userDTO.enabled==true}"> zablokowac </c:if>
                    <c:if test="${userDTO.enabled==false}"> odblokowac </c:if>
                    konto poniższego użytkownika?
                </p>            </div>
            <div class="form-group">
                <p>Imie:<br> ${userDTO.name}</p>
            </div>
            <div class="form-group">
                <p>Nazwisko:<br> ${userDTO.surname}</p>
            </div>
            <div class="form-group">
                <p>Email:<br> ${userDTO.email}</p>
            </div>
            <div class="form-group">
                <p>Aktywnosc:<br> ${userDTO.enabled}</p>
            </div>
            <div class="row">
                <form method="post" action="/admin/users/toggleActivity">
                    <input type="hidden" name="id" value="${userDTO.id}"/>
                    <div class="col-sm">
                        <button type="submit" class="btn btn-primary btn-icon-split">Tak</button>
                    </div>
                </form>
                <form method="get" action="/admin/users/">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-primary btn-icon-split">Nie</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<jsp:include page="../static/footer.jsp"/>