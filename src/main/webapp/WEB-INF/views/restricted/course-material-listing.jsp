<!DOCTYPE html>
<html>
<head>
    <%@ include file="fragments/resources.jsp" %>

    <title>My Hogwarts Course Materials</title>
</head>
<%@page import="edu.hogwarts.persistence.entity.CourseMaterial" %>

<body class="bg-light">
<%@ include file="fragments/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <form action="course-material-listing" method="post">
                <div class="card">
                    <div class="card-header">Filters</div>
                    <div class="card-body">
                        <h5 class="card-title">Name</h5>
                        <%
                            String name = (String) request.getParameter("courseMaterialName");
                            if (name == null) {
                                name = "";
                            }
                        %>
                        <input type="text" name="courseMaterialName" value="<%= name %>"/>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-success btn-md" type="submit">Refresh</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-9">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    Iterable<CourseMaterial> courseMaterials = (Iterable<CourseMaterial>) request.getAttribute("courseMaterials");
                    for (CourseMaterial courseMaterial : courseMaterials) {
                %>
                <tr>
                    <td><img class="material-icon"
                             src="<%= request.getContextPath() %>/resources/images/course-materials/<%= courseMaterial.getImageName() %>"
                             height="100" width="100"></td>
                    <td class="align-middle"><a
                            href="course-material-listing/<%= courseMaterial.getId() %>"><%= courseMaterial.getName() %>
                    </a></td>
                    <td class="align-middle"><%= String.format("$%.2f", courseMaterial.getPrice()) %>
                    </td>
                    <td class="align-middle">
                        <form action="<%= request.getContextPath() %>/restricted/shopping-cart/add-course-material/<%= courseMaterial.getId() %>"
                              method="post">
                            <input type="submit" class="btn btn-primary btn-md" value="Add to Cart"/>
                        </form>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

</html>