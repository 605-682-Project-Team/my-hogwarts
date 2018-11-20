
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="resources/images/hogwarts_crest_icon.ico">
<link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/lib/bootstrap.min.js"></script>
<link href="resources/css/login.css" rel="stylesheet">
<title>My Hogwarts</title>
</head>
<body class="text-center">
	<form class="form-signin" action="login" method="POST">
		<img class="mb-4" src="resources/images/hogwarts-crest.png" alt=""
			width="200" height="200" />
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" id="inputEmail" name="email" class="form-control"
			placeholder="Email address" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" name="password" class="form-control"
			placeholder="Password" required>
		<span>
			Don't have an account?
			<a href="register">Sign up</a>
		</span>
		<br/><br/>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
	</form>
</body>
</html>