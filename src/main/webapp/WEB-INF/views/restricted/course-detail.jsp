<!DOCTYPE html>
<html>
<head>
<%@ include file="fragments/resources.jsp" %>

<title>My Hogwarts Courses</title>
</head>

<%@page import="edu.hogwarts.util.HogwartsConstants"%>
<%@page import="edu.hogwarts.persistence.entity.Course"%>
<%@page import="edu.hogwarts.persistence.entity.CourseMaterial"%>

<%
	Course course = (Course) request.getAttribute("course");
%>

<body class="bg-light">
	 <%@ include file="fragments/navbar.jsp" %>
	 <% if (course == null) { %>
	 	<h2>No course found!</h2>
	 <% } else { %>
	 
	 <div class="jumbotron">
  		<h2 class="display-4"><%= course.getName() %></h2>
  		<p><b>Professor: </b> <%= course.getProfessor() %> </p>
  		<p><b>Category: </b> <%= course.getCategory() %> </p>
  		<p class="lead"><%= course.getDescription() %></p>
  		<form action="<%= request.getContextPath() %>/restricted/shopping-cart/add-course/<%= course.getId() %>" method="post">
			<input type="submit" class="btn btn-primary btn-lg" value="Add to Cart" />
		</form>
  		<hr class="my-4">
  		<h4>Required Materials</h4>
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
					for (CourseMaterial courseMaterial : course.getCourseMaterials()) { 
				%>
				<tr>
					<td><img class="material-icon" src="<%= request.getContextPath() %>/resources/images/course-materials/<%= courseMaterial.getImageName() %>" height="100" width="100"></td>
					<td class="align-middle" ><a href="<%= request.getContextPath() %>/restricted/course-material-listing/<%= courseMaterial.getId() %>"><%= courseMaterial.getName() %></a></td>
					<td class="align-middle"><%= String.format("$%.2f", courseMaterial.getPrice()) %></td>
					<td class="align-middle">
						<form action="<%= request.getContextPath() %>/restricted/shopping-cart/add-course-material/<%= courseMaterial.getId() %>" method="post">
							<input type="submit" class="btn btn-primary btn-md" value="Add to Cart" />
						</form>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	 
	 <% } %>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

</html>