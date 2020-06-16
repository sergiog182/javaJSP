<div class="modal fade" id="addClientBox">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Add Client</h5>
                <button class="close" data-dismiss="modal">
                    &times;
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ControlServlet?action=add" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input class="form-control" type="text" id="name" name="name" required/>
                    </div>
                    <div class="form-group">
                        <label for="lastname">Lastname:</label>
                        <input class="form-control" type="text" id="lastname" name="lastname" required/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input class="form-control" type="email" id="email" name="email" required/>
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone number:</label>
                        <input class="form-control" type="number" id="phoneNumber" name="phoneNumber" required/>
                    </div>
                    <div class="form-group">
                        <label for="residue">Residue:</label>
                        <input class="form-control" type="number" step="any" id="residue" name="residue" required/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
            
        </div>
    </div>
</div>