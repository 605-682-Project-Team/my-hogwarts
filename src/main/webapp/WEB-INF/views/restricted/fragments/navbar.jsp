<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="edu.hogwarts.util.HogwartsConstants"%>
<%@page import="edu.hogwarts.util.ShoppingCart"%>

<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<img class="nav-bar-icon" src="../resources/images/hogwarts-crest.png"
			alt="First slide"> <a class="navbar-brand" href="dashboard">MyHogwarts</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="dashboard">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="account">Account</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="course-listing">Courses</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="course-material-listing">Course Materials</a></li>
				<li class="nav-item mt-2 mt-md-0"><a class="nav-link"
					href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
			<span class="mt-2 mt-md-0"> <span class="pr-3 text-light">Logged
					in as: <b><c:out value='${sessionScope.currentUser.firstname}' /></b>
			<%
				int itemsInCart = 0;
				ShoppingCart shoppingCart = null;
				synchronized(session.getId().intern()) {
					shoppingCart = (ShoppingCart) session.getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
				}
				if (shoppingCart != null) {
					itemsInCart = shoppingCart.getNumberOfItems();
				}
			%>
			</span> <a href="shopping-cart" class="btn btn-primary btn-md"> Shopping
					Cart <span class="badge badge-light"><%= itemsInCart %></span></a>
			</span>
		</div>
	</nav>
</header>
<br/>