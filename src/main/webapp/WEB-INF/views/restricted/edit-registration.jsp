<!DOCTYPE html>
<html>
<head>
<%@ include file="fragments/resources.jsp" %>

<title>My Hogwarts Account</title>
</head>

<%@page import="edu.hogwarts.persistence.entity.User"%>
<%@page import="edu.hogwarts.util.HogwartsConstants"%>

<%
	User user = (User) session.getAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER);
	if (user == null) {
		user = new User();
	}
%>

<body class="bg-light">
	 <%@ include file="fragments/navbar.jsp" %>
	 <br/>
	 <div class="container">
		<form action="user/update" method="post">
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="firstname">First name</label> <input type="text"
						class="form-control" id="firstname" name="firstname" value="<%= user.getFirstname() %>"required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="lastname">Last name</label> <input type="text"
						class="form-control" id="lastname" name="lastname" value="<%= user.getLastname() %>" required>
				</div>
			</div>
			<div class="mb-3">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email" placeholder="someone@example.com" value="<%= user.getEmail() %>"
					required>
			</div>
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password" value="<%= user.getPassword() %>" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="passwordConfirmation">Password Confirmation</label> <input
						type="password" class="form-control" id="passwordConfirmation"
						oninput="check(this)" required>
				</div>
			</div>
			<hr class="mb-4">
			<div class="mb-3">
				<label for="streetAddress">Address</label> <input type="text"
					class="form-control" id="streetAddress" name="streetAddress" value="<%= user.getStreetAddress() %>" required>
			</div>
			<div class="row">
				<div class="col-md-4 mb-3">
					<label for="city">City</label> <input type="text"
						class="form-control" id="city" name="city" value="<%= user.getCity() %>" required>
				</div>
				<div class="col-md-4 mb-3">
					<label for="state">State</label> <input type="text"
						class="form-control" id="state" name="state" value="<%= user.getState() %>" required>
				</div>
				<div class="col-md-4 mb-3">
					<label for="zipcode">Zipcode</label> <input type="text"
						class="form-control" id="zipcode" name="zipcode" maxlength="5" minlength="5" value="<%= user.getZipcode() %>"
						required>
				</div>
			</div>
			<hr class="mb-4">
			<div class="row">
				<div class="col-md-4 mb-3">
					<label for="year">Year</label> <select
						class="custom-select d-block w-100" id="year" name="year" required>
						<% for (int i = 1; i <= 7; i++) { %>
							<option value="<%= i%>" <%= (i == user.getYear()) ? "selected" : "" %>><%= i %></option>
						<% } %>
					</select>
				</div>
				<div class="col-md-4 mb-3">
					<label for="muggleBorn">MuggleBorn</label> <select
						class="custom-select d-block w-100" id="muggleBorn" name="muggleBorn" required>
						<option value=""></option>
						<option value="true" <%= (user.isMuggleborn()) ? "selected" : "" %>>Yes</option>
						<option value="false" <%= (!user.isMuggleborn()) ? "selected" : "" %>>No</option>
					</select>
				</div>
			</div>
			<button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
		</form>
	</div>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

<script type='text/javascript'>
	function check(input) {
		if (input.value != document.getElementById('password').value) {
			input.setCustomValidity('Password Must be Matching.');
		} else {
			// input is valid -- reset the error message
			input.setCustomValidity('');
		}
	}
</script>

</html>