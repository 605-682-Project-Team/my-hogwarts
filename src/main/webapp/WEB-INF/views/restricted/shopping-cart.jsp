<!DOCTYPE html>
<html>
<head>
<%@ include file="fragments/resources.jsp" %>
<title>My Hogwarts Shopping Cart</title>
</head>

<%@page import="edu.hogwarts.persistence.entity.Course"%>
<%@page import="edu.hogwarts.persistence.entity.CourseMaterial"%>
<%@page import="edu.hogwarts.util.HogwartsConstants"%>
<%@page import="edu.hogwarts.util.ShoppingCart"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>

<body class="bg-light">
	 <%@ include file="fragments/navbar.jsp" %>
	 
	 <% 
	 	// navbar.jsp defines shoppingCart
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
		}
		Set<Course> courses = shoppingCart.getCourses();
		Map<CourseMaterial, Integer> courseMaterials = shoppingCart.getCourseMaterials();
		
		double courseSubtotal = HogwartsConstants.COURSE_FEE * courses.size();
		
		double courseMaterialSubtotal = 0.0;
		for (CourseMaterial cm : courseMaterials.keySet()) {
			courseMaterialSubtotal += cm.getPrice() * courseMaterials.get(cm);
		}
	%>
	 
	 <div class="container">
		<div class="row">
		 	<div class="col-md-8">
			 	<h4>Courses</h4>
			 	<table class="table table-hover">
					<thead>
						<tr>
							<th>Course Name</th>
							<th>Professor</th>
							<th>Category</th>
							<th>Price</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<% for (Course course : courses) {  %>
						<tr>
							<td><a href="course-listing/<%= course.getId() %>"><%= course.getName() %></a></td>
							<td><%= course.getProfessor() %></td>
							<td><%= course.getCategory() %></td>
							<td><%= HogwartsConstants.COURSE_FEE_STRING %> </td>
							<td>
								<form action="<%= request.getContextPath() %>/restricted/shopping-cart/remove-course/<%= course.getId() %>" method="post">
									<input type="submit" class="btn btn-danger btn-md" value="Remove" />
								</form>
							</td>
						</tr>
						<% } %>
					</tbody>
				</table>
				<% if (courses.size() == 0) { %>
					<p class="font-italic text-center">No courses in cart.</p>
				<% } %>
		
				<hr/>
			</div>
			<div class="col-md-4">
				<br/><br/>
				<form action="<%= request.getContextPath() %>/restricted/shopping-cart/checkout" method="post">
		 			<div class="card">
		 				<div class="card-header text-center"><h5>Purchase Summary</h5></div>
		 				<div class="card-body">
		 					<div class="row">
								<div class="font-weight-bold text-right col-md-7">Courses:</div><div class="text-right col-md-5"><%= String.format("$%.2f", courseSubtotal) %></div>
							</div>
							<div class="row">
								<div class="font-weight-bold text-right col-md-7">Course Materials:</div><div class="text-right col-md-5"><%= String.format("$%.2f", courseMaterialSubtotal) %></div>
							</div>
							<hr>
							<div class="row">
								<div class="font-weight-bold text-right col-md-7">Total:</div><div class="text-right col-md-5"><%= String.format("$%.2f", courseSubtotal + courseMaterialSubtotal) %></div>
							</div>
		 				</div>
		 				<div class="card-footer text-center">
		 					<button class="btn btn-success btn-md" type="submit">Checkout</button>
		 				</div>
		 			</div>
					</form>
			</div>
		</div>
		<h4>Course Materials</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Name</th>
						<th>Quantity</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<% 
						for (CourseMaterial courseMaterial : courseMaterials.keySet()) { 
					%>
					<tr>
						<td><img class="material-icon" src="<%= request.getContextPath() %>/resources/images/course-materials/<%= courseMaterial.getImageName() %>" height="100" width="100"></td>
						<td class="align-middle" ><a href="course-material-listing/<%= courseMaterial.getId() %>"><%= courseMaterial.getName() %></a></td>
						<td class="align-middle">
							<form id="formUpdate<%= courseMaterial.getId() %>" action="<%= request.getContextPath() %>/restricted/shopping-cart/update-course-material/<%= courseMaterial.getId() %>" method="post">
								<input style="width:2.5em" name="quantity" type="number" value="<%= courseMaterials.get(courseMaterial) %>"/>x<%= String.format("$%.2f", courseMaterial.getPrice()) %>
							</form>
						</td>
						<td class="align-middle"><%= String.format("$%.2f", courseMaterial.getPrice() * courseMaterials.get(courseMaterial)) %></td>	
						<td class="align-middle text-right" style="width:13em" >
								
								<button id="Update<%= courseMaterial.getId() %>" class="btn btn-warning btn-md">Update</button>
								
								<form style="display: inline-block;" action="<%= request.getContextPath() %>/restricted/shopping-cart/remove-course-material/<%= courseMaterial.getId() %>" method="post">
									<input type="submit" class="btn btn-danger btn-md" value="Remove" />
								</form>
						</td>
					</tr>
					<% } %>
				</tbody>
			</table>
			<% if (courses.size() == 0) { %>
				<p class="font-italic text-center">No course materials in cart.</p>
			<% } %>
	 </div>
	 
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

<script>
	$(document).ready(function() {
		$("[id^=Update]").click(function(event) {
			$("[id=form" + event.target.id + "]").submit();
		});
	});
</script>

</html>