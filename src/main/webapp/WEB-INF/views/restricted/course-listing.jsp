<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../resources/images/hogwarts_crest_icon.ico">
<link href="../resources/css/lib/bootstrap.min.css" rel="stylesheet">
  <link href="../resources/css/dashboard.css" rel="stylesheet">
<script src="../resources/js/lib/jquery-3.3.1.min.js"></script>
<script src="../resources/js/lib/bootstrap.min.js"></script>
<script src="../resources/js/lib/popper.min.js"></script>

<title>My Hogwarts Courses</title>
</head>

<body class="bg-light">
	 <%@ include file="fragments/navbar.jsp" %>
	 <div class="container">
	 	<div class="row" >
	 		<div class="col-md-3">
	 			<div class="card">
	 				<div class="card-header">Filters</div>
	 				<div class="card-body">
 						<h5 class="card-title">Professor</h5>
 						<p>professor check boxes</p>
	 				</div>
	 				<hr />
	 				<div class="card-body">
 						<h5 class="card-title">Category</h5>
 						<p>category checkboxes</p>
	 				</div>
	 				<div class="card-footer">
	 					<a href="course-listing" class="btn btn-success btn-md"> Refresh </a>
	 				</div>
	 			</div>
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
	 					<tr>
	 						<td><a href="">Potions</a></td>
	 						<td>Severus Snape</td>
	 						<td>Core</td>
	 						<td><a href="course-listing" class="btn btn-primary btn-md"> Add to Cart </a></td>
	 					</tr>
	 					<tr>
	 						<td><a href="">Defense Against the Dark Arts</a></td>
	 						<td>Remus Lupin</td>
	 						<td>Core</td>
	 						<td><a href="course-listing" class="btn btn-primary btn-md"> Add to Cart </a></td>
	 					</tr>
	 				</tbody>
	 			</table>
	 		</div>
	 	</div>
	 </div>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

</html>