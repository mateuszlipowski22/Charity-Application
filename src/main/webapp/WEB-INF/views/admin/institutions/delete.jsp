<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../static/header.jsp"/>

<div class="container-fluid">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="m-0 font-weight-bold text-primary">Usunięcie fundacji</h1>
        </div>
        <div class="card-body">
            <div class="form-group">
                <p class="title" style="marker-offset: 30px">
                    Czy na pewno chcesz usunąć poniższą fundację?
                </p>            </div>
            <div class="form-group">
                <p>Nazwa:<br> ${institutionDTO.name}</p>
            </div>
            <div class="form-group">
                <p>Opis:<br> ${institutionDTO.description}</p>
            </div>
            <div class="row">
                <form method="post" action="/admin/institutions/delete">
                    <input type="hidden" name="id" value="${institutionDTO.id}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="col-sm">
                        <button type="submit" class="btn btn-primary btn-icon-split">Tak</button>
                    </div>
                </form>
                <form method="get" action="/admin/institutions/">
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