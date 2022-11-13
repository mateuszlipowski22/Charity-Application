<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../static/header.jsp"/>

<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="m-0 font-weight-bold text-primary">
                Lista aktualnych administratorów<br>
            </h1>
        </div>
        <c:if test="${empty adminsDTO}">
            <div class="card-header py-3">
                <h1 class="m-0 font-weight-bold text-primary">
                    Brak aktualnych administratorów<br>
                    <br>
                </h1>
            </div>
        </c:if>

        <c:if test="${not empty adminsDTO}">
            <table class="table is-fullwidth is-bordered" style="width:100%">
                <thead>
                <tr>
                    <th style="width:10%">Numer</th>
                    <th style="width:20%">Imie</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th style="width:20%">Akcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="admin" items="${adminsDTO}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${admin.name}</td>
                        <td>${admin.surname}</td>
                        <td>${admin.email}</td>
                        <td>
                            <nav class="navbar">
                                <div class="container">
                                    <div class="form-group form-group--buttons">
                                        <a href="/admin/admins/${admin.id}/edit" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                                            <span class="text">Edytuj</span>
                                        </a>
                                    </div>
                                    <div class="form-group form-group--buttons">
                                        <a href="/admin/admins/${admin.id}/delete" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                                            <span class="text">Usun</span>
                                        </a>
                                    </div>
                                </div>
                            </nav>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <div class="form-group form-group--buttons">
            <a href="/admin/admins/add" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                <span class="text">Dodaj nowego administratora</span>
            </a>
        </div>
    </div>
</div>

<jsp:include page="../static/footer.jsp"/>