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
                    Szczegóły zbiórki<br>
                </h1>
            </div>

            <div class="container">
                    <table style="width:100%" border="1">
                        <tr>
                            <th style="width:50%">Fundacja</th>
                            <th style="width:50%">${donationDTO.institutionDTO.name}<br>
                                ${donationDTO.institutionDTO.description}
                            </th>
                        </tr>
                        <tr>
                            <th style="width:50%">Data utworzenia wpisu</th>
                            <th style="width:50%">${donationDTO.createdOn}</th>
                        </tr>
                        <tr>
                            <th style="width:50%">Status</th>
                            <th style="width:50%">${donationDTO.status}</th>
                        </tr>
                        <tr>
                            <th style="width:50%">Data zmiany statusu</th>
                            <th style="width:50%">${donationDTO.updatedStatusDate}</th>
                        </tr>
                        <tr>
                            <th style="width:50%">Data odebrania</th>
                            <th style="width:50%">${donationDTO.pickUpDate}</th>
                        </tr>
                        <tr>
                            <th style="width:50%">Data utworzenia wpisu</th>
                            <th style="width:50%">
                                <c:forEach var="category" items="${donationDTO.categoriesDTO}" varStatus="loop">
                                    ${loop.count} ${category.name}<br>
                                </c:forEach>
                            </th>
                        </tr>
                    </table>
            </div>

            <div>
                <h1 class="m-0 font-weight-bold text-primary">
                    Zaaktualizuj status zbiórki<br>
                </h1>
            </div>

            <div class="container">
                <table style="width:100%" border="1">
                    <form:form modelAttribute="donationDTO" method="post" action="/user/donation/changeStatus">
                    <tr>
                        <th>
                                <form:select path="status">
                                    <form:option value="-" label="--Please Select--"/>
                                    <form:options items="${status}"/>
                                </form:select>
                                <input type="hidden" name="id" value="${donationDTO.id}" />
                        </th>
                        <th>
                            <div class="form-group form-group--buttons">
                                <button class="btn" type="submit">Zmień status</button>
                            </div>
                        </th>
                    </tr>
                    </form:form>

                </table>
            </div>


            <nav class="navbar">
                <div class="container">
                    <div class="form-group form-group--buttons">
                        <a href="/user/donation/all"
                           class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                            <span class="text">Moje zbiórki</span>
                        </a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</section>

<jsp:include page="../../static/footer.jsp"/>

