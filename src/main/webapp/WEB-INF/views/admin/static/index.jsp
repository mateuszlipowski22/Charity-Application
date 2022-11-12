<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h1 class="m-0 font-weight-bold text-primary">Strona administratora ${currentUserDTO.name}</h1>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <h3>Imie: ${currentUserDTO.name}</h3>
                            </div>
                            <div class="form-group">
                                <h3>Nazwisko: ${currentUserDTO.surname}</h3>
                            </div>
                            <div class="form-group">
                                <h3>Adress email: ${currentUserDTO.email}</h3>
                            </div>
                            <div class="form-group form-group--buttons">
                                <a href="#" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                        </span>
                                    <span class="text">Edytuj dane</span>
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

<jsp:include page="footer.jsp"/>
