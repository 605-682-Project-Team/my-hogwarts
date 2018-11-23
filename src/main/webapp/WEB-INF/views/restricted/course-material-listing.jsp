<!DOCTYPE html>
<html>
<head>
<%@ include file="fragments/resources.jsp" %>

<title>My Hogwarts Course Materials</title>
</head>
<%@page import="edu.hogwarts.persistence.entity.CourseMaterial"%>

<body class="bg-light">
	 <%@ include file="fragments/navbar.jsp" %>
	 <div class="container">
	 	<div class="row" >
	 		<div class="col-md-3">
	 			<form action="course-listing" method="post">
		 			<div class="card">
		 				<div class="card-header">Filters</div>
		 				<div class="card-body">
	 						<h5 class="card-title">Category</h5>
<%-- 	 						<%
// 	 							CourseCategory checked;
// 	 							String checkedStr = request.getParameter("category");
// 	 							if (checkedStr == null || checkedStr.isEmpty()) {
// 	 								checked = null;
// 	 							} else {
// 	 								checked = CourseCategory.valueOf(checkedStr);
// 	 							}
	 							
	 						%> --%>
<!-- 	 						<div class="radio"> -->
<%-- 	  							<label><input type="radio" name="category" value="<%= CourseCategory.CORE %>" <%if (CourseCategory.CORE.equals(checked)) { %> checked <% } %>><%= CourseCategory.CORE %></label> --%>
<!-- 							</div> -->
<!-- 							<div class="radio"> -->
<%-- 							    <label><input type="radio" name="category" value="<%= CourseCategory.ELECTIVE %>" <%if (CourseCategory.ELECTIVE.equals(checked)) { %> checked <% } %>><%= CourseCategory.ELECTIVE %></label> --%>
<!-- 							</div> -->
<!-- 							<div class="radio"> -->
<%-- 	  							<label><input type="radio" name="category" value="<%= CourseCategory.EXTRA_CURRICULAR %>" <%if (CourseCategory.EXTRA_CURRICULAR.equals(checked)) { %> checked <% } %>><%= CourseCategory.EXTRA_CURRICULAR %></label> --%>
<!-- 							</div> -->
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
	 						<th>Course Name</th>
	 						<th>Professor</th>
	 						<th>Category</th>
	 						<th></th>
	 					</tr>
	 				</thead>
	 				<tbody>
	 					<% 
	 						Iterable<CourseMaterial> courseMaterials = (Iterable<CourseMaterial>) request.getAttribute("courseMaterials");
	 						for (CourseMaterial courseMaterial : courseMaterials) { 
	 					%>
	 					<tr>
							<td><img class="material-icon" src="<%= request.getContextPath() %>/resources/images/course-materials/<%= courseMaterial.getImageName() %>" height="100" width="100"></td>
							<td class="align-middle" ><a href="course-material-listing/<%= courseMaterial.getId() %>"><%= courseMaterial.getName() %></a></td>
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
	 	</div>
	 </div>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

</html>