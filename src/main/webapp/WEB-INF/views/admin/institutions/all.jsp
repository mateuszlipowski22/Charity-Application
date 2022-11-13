<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../static/header.jsp"/>

<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="m-0 font-weight-bold text-primary">
                Lista aktualnych fundacji<br>
            </h1>
        </div>
        <c:if test="${empty institutionsDTO}">
            <div class="card-header py-3">
                <h1 class="m-0 font-weight-bold text-primary">
                    Brak aktualnych fundacji<br>
                    <br>
                </h1>
            </div>
        </c:if>

        <c:if test="${not empty institutionsDTO}">
            <table class="table is-fullwidth is-bordered" style="width:100%">
                <thead>
                <tr>
                    <th style="width:10%">Numer</th>
                    <th style="width:20%">Nazwa</th>
                    <th>Opis</th>
                    <th style="width:20%">Akcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="institution" items="${institutionsDTO}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${institution.name}</td>
                        <td>${institution.description}</td>
                        <td>
                            <nav class="navbar">
                                <div class="container">
                                    <div class="form-group form-group--buttons">
                                        <a href="/admin/institutions/${institution.id}/edit" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                                            <span class="text">Edytuj</span>
                                        </a>
                                    </div>
                                    <div class="form-group form-group--buttons">
                                        <a href="/admin/institutions/${institution.id}/delete" class="btn btn-primary btn-icon-split">
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
            <a href="/admin/institutions/add" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                <span class="text">Dodaj nową fundację</span>
            </a>
        </div>
    </div>
</div>

<jsp:include page="../static/footer.jsp"/>