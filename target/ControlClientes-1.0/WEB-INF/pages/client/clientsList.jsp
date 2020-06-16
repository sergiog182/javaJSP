<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="en_US" />

<section id="clientsList">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Clients</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Residue</th>
                                <th>Options</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="client" items="${clients}">
                                <tr>
                                    <td>${client.clientId}</td>
                                    <td>${client.name} ${client.lastname}</td>
                                    <td> <fmt:formatNumber value="${client.residue}" type="currency" /> </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ControlServlet?action=edit&clientId=${client.clientId}" class="btn btn-secondary">
                                            <i class="fas fa-edit"></i> Edit
                                        </a>
                                        &nbsp;
                                        <a href="${pageContext.request.contextPath}/ControlServlet?action=delete&clientId=${client.clientId}" class="btn btn-danger" onclick="return confirm('Are you sure?')">
                                            <i class="fas fa-trash"></i> Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- total cards -->
            <div class="col-md-3">
                <!-- Residue -->
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total residue</h3>
                        <h5 class="display-5">
                            <fmt:formatNumber value="${totalResidue}" type="currency" />
                        </h5>
                    </div>
                </div>

                <!-- clients -->
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total clients</h3>
                        <h5 class="display-5">
                            <i class="fas fa-users"></i> ${totalClients}
                        </h5>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/pages/client/addClient.jsp" />