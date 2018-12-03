<!DOCTYPE html>
<html>
<head>
    <%@ include file="fragments/resources.jsp" %>

    <title>My Hogwarts Course Material</title>
</head>

<%@page import="edu.hogwarts.persistence.entity.CourseMaterial" %>

<%
    CourseMaterial courseMaterial = (CourseMaterial) request.getAttribute("courseMaterial");
%>

<body class="bg-light">
<%@ include file="fragments/navbar.jsp" %>
<% if (courseMaterial == null) { %>
<h2>No course materials found!</h2>
<% } else { %>

<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <h2 class="display-4"><%= courseMaterial.getName() %>
                </h2>
                <p><b>Price: </b> <%= String.format("$%.2f", courseMaterial.getPrice()) %>
                </p>
                <p class="lead"><%= courseMaterial.getDescription() %>
                </p>
                <br/>
                <form action="<%= request.getContextPath() %>/restricted/shopping-cart/add-course-material/<%= courseMaterial.getId() %>"
                      method="post">
                    <input type="submit" class="btn btn-primary btn-lg" value="Add to Cart"/>
                </form>
            </div>
            <div class="col-md-3">
                <img class="material-icon"
                     src="<%= request.getContextPath() %>/resources/images/course-materials/<%= courseMaterial.getImageName() %>"
                     height="300" width="300">
            </div>
        </div>
    </div>
</div>

<% } %>
<p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

</html>