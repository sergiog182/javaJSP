<%
    String title = request.getParameter("title");
    String icon = request.getParameter("icon");
%>

<header id="main-header" class="py-2 bg-info text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1><i class="<%= icon %>"></i> <%= title %></h1>
            </div>
        </div>
    </div>
</header>
