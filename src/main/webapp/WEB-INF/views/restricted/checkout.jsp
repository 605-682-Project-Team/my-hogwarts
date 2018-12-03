<!DOCTYPE html>
<html>
<head>
    <%@ include file="fragments/resources.jsp" %>
    <title>My Hogwarts Checkout</title>
    <style>
        label {
            /* To make sure that all labels have the same size and are properly aligned */
            display: inline-block;
            width: 120px;
            text-align: left;
            font-weight: bold;
        }
    </style>
    <script>
        function openPage(pageURL) {
            window.location.href = pageURL;
        }
    </script>

</head>

<%@page import="edu.hogwarts.persistence.entity.Course" %>
<%@page import="edu.hogwarts.persistence.entity.CourseMaterial" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>

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
            <div class="card">
                <div class="card-header text-center"><h5>Order Summary</h5></div>
                <div class="card-body">
                    <div class="row">
                        <div class="font-weight-bold text-right col-md-7">Courses:</div>
                        <div class="text-right col-md-5"><%= String.format("$%.2f", courseSubtotal) %>
                        </div>
                    </div>
                    <div class="row">
                        <div class="font-weight-bold text-right col-md-7">Course Materials:</div>
                        <div class="text-right col-md-5"><%= String.format("$%.2f", courseMaterialSubtotal) %>
                        </div>
                    </div>
                    <hr>
                    <form action="" method="post">
                        <input type="hidden" name="action" value="add">
                        <div class="row">
                            <div class="font-weight-bold text-right col-md-7">Credit Card Type:</div>
                            <div class="text-right col-md-5">
                                <input type="radio" name="optRadio" value="Discover"> Discover
                                <input type="radio" name="optRadio" value="Master Card"> Master Card
                                <input type="radio" name="optRadio" value="VISA"> VISA
                            </div>
                        </div>
                        <div class="row">
                            <div class="font-weight-bold text-right col-md-7">Credit Card Number:</div>
                            <div class="text-right col-md-5">
                                <input type="text" name="ccNumber" maxlength="16" value="" required autofocus><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="font-weight-bold text-right col-md-7">Expiration Date:</div>
                            <div class="text-right col-md-5">
                                <select name="month">
                                    <option>January</option>
                                    <option>February</option>
                                    <option>March</option>
                                    <option>April</option>
                                    <option>May</option>
                                    <option>June</option>
                                    <option>July</option>
                                    <option>August</option>
                                    <option>September</option>
                                    <option>October</option>
                                    <option>November</option>
                                    <option>December</option>
                                </select>
                                <select name="day">
                                    <option>2018</option>
                                    <option>2019</option>
                                    <option>2020</option>
                                    <option>2021</option>
                                    <option>2022</option>
                                    <option>2023</option>
                                    <option>2024</option>
                                    <option>2025</option>
                                    <option>2026</option>
                                    <option>2027</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <hr>
                <div class="row">
                    <div class="font-weight-bold text-right col-md-7">Total:</div>
                    <div class="text-right col-md-5"><%= String.format("$%.2f", courseSubtotal + courseMaterialSubtotal) %>
                    </div>
                </div>
                <form action="<%= request.getContextPath() %>/restricted/shopping-cart/confirmation" method="post">
                    <button class="btn btn-success btn-md btn-block" type="submit">Place Order</button>
                </form>
            </div>
        </div>
    </div>
</div>

<p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>


</html>