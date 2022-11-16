<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../../static/header.jsp"/>
</header>

<section class="help">

    <div class="help--slides active">
        <div class="container">
            <div>
                <h1 class="m-0 font-weight-bold text-primary">
                    Lista Twoich zbiórek<br>
                </h1>
            </div>
            <c:if test="${empty donationsDTO}">
                <div class="card-header py-3">
                    <h1 class="m-0 font-weight-bold text-primary">
                        Brak twoich zbiórek<br>
                        <br>
                    </h1>
                </div>
            </c:if>

            <div class="container">
                <c:if test="${not empty donationsDTO}">
                    <table style="width:100%" border="1">
                        <thead>
                        <tr>
                            <th style="width:10%">Numer</th>
                            <th style="width:50%">Fundacja</th>
                            <th style="width:15%">Status</th>
                            <th style="width:15%">Data odbierania</th>
                            <th style="width:10%">Akcje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="donation" items="${donationsDTO}" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${donation.institutionDTO.name}<br>
                                        ${donation.institutionDTO.description}
                                </td>
                                <td>${donation.status}</td>
                                <td>${donation.pickUpDate}</td>
                                <td>
                                    <nav class="navbar">
                                        <div class="container">
                                            <div class="form-group form-group--buttons">
                                                <a href="/user/donation/${donation.id}/show"
                                                   class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                                                    <span class="text">Pokaż</span>
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
            </div>

        </div>
    </div>
</section>

<jsp:include page="../../static/footer.jsp"/>

