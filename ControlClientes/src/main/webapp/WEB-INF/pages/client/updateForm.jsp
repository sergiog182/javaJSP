<section id="editClient">
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Client Data</h4>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/ControlServlet?action=update" method="POST" class="was-validated">
                            <input type="hidden" value="${client.clientId}" name="clientId" />
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input class="form-control" type="text" name="name" value="${client.name}" required/>
                            </div>
                            <div class="form-group">
                                <label for="lastname">Lastname:</label>
                                <input class="form-control" type="text" name="lastname" value="${client.lastname}" required/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input class="form-control" type="email" name="email" value="${client.email}" required/>
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber">Phone number:</label>
                                <input class="form-control" type="number" name="phoneNumber" value="${client.phoneNumber}" required/>
                            </div>
                            <div class="form-group">
                                <label for="residue">Residue:</label>
                                <input class="form-control" type="number" step="any" name="residue" value="${client.residue}" required/>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-success">
                                    <i class="fas fa-check"></i> Update
                                </button>
                                &nbsp;
                                <a href="index.jsp" class="btn btn-danger">
                                    <i class="fas fa-long-arrow-alt-left"></i> Cancel
                                </a>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>