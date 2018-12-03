<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="edu.hogwarts.persistence.entity.Course" %>
<%@ page import="edu.hogwarts.persistence.entity.CourseMaterial" %>
<%@ page import="edu.hogwarts.persistence.entity.User" %>
<%@ page import="edu.hogwarts.util.MailUtilGmail" %>
<%@page import="javax.mail.MessagingException" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>

!DOCTYPE html>
<html>
<head>
    <%@ include file="fragments/resources.jsp" %>
    <title>My Hogwarts Checkout</title>
</head>

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

    String message = "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<title>My Hogwarts Checkout</title>" +
            "</head>" +
            "<body class=\"bg-light\">" +
            " 	    <p align=\"center\">A confirmation email has been sent. Thanks for placing your order! Here is a summary:</p>" +
            "	<div class=\"col-md-8\">" +
            " 		<h4>Courses</h4>" +
            " 		<table>" +
            "			<thead>" +
            "				<tr>" +
            "					<th>Course Name</th>" +
            "					<th>Professor</th>" +
            "					<th>Category</th>" +
            "					<th>Price</th>" +
            "					<th></th>" +
            "				</tr>" +
            "			</thead>" +
            "			<tbody>";

    for (Course course : courses) {
        Long courseID = course.getId();
        String courseName = course.getName();
        String courseProfessor = course.getProfessor();
        Course.CourseCategory courseCategory = course.getCategory();
        String courseFee = HogwartsConstants.COURSE_FEE_STRING;

        message += "				<tr>" +
                "					<td> " + courseID + "" + courseName + "</td>" +
                "					<td> " + courseProfessor + "</td>" +
                "					<td> " + courseCategory + "</td>" +
                "					<td> " + courseFee + "</td>" +
                "					<td>" +
                "				</tr>" +
                "			</tbody>" +
                "		</table>";
    }
    if (courses.size() == 0) {
        message += "		<p class=\"font-italic text-center\">No courses in cart.</p>";
    }

    message += "		<hr/> " +
            "	</div>" +
            "	<h4>Course Materials</h4>" +
            "	 		<table class=\"table table-hover\"> " +
            "			<thead>" +
            "				<tr>" +
            "					<th></th>" +
            "					<th>Name</th>" +
            "					<th>Quantity</th>" +
            "					<th>Price</th>" +
            "					<th></th>" +
            "				</tr>" +
            "			</thead>" +
            "			<tbody>";

    for (CourseMaterial courseMaterial : courseMaterials.keySet()) {
        Long materialID = courseMaterial.getId();
        String materialName = courseMaterial.getName();
        Double materialsTotal = courseMaterial.getPrice() * courseMaterials.get(courseMaterial);

        message += "				<tr>" +
                "					<td class=\"align-middle\" > " + materialID + "" + materialName + "</td> " +
                "					<td class=\"align-middle\"> " +
                " 					</td>" +
                "					<td class=\"align-middle\">" + materialsTotal + " </td> " +
                "					<td class=\"align-middle text-right\" style=\"width:13em\" > " +
                "					</td> " +
                "				</tr>";
    }
    message += "			</tbody>" +
            "		</table>";
    if (courses.size() == 0) {
        message += " <p class=\"font-italic text-center\">No course materials in cart.</p>";
    }
    message += " <hr/>" +
            " <h3> Your total is: $" + (courseSubtotal + courseMaterialSubtotal) + " </h3>" +
            " </div" +
            " <p class=\"mt-5 mb-3 text-muted text-center\">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p> " +
            " </body> " +
            " </html>";

    User user = (User) session.getAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER);
    if (user == null) {
        user = new User();
    }

    String emailAddress = user.getEmail();

    // send email to user
    String to = emailAddress;
    String from = "webappdeveljhu@gmail.com";
    String subject = "Confirmation from  Hogwarts!";
    boolean isBodyHTML = true;
    try {
        MailUtilGmail.sendMail(to, from, subject, message, isBodyHTML);
    } catch (MessagingException e) {
        String errorMessage
                = "ERROR: Unable to send email. "
                + "Check Tomcat logs for details.<br>"
                + "NOTE: You may need to configure your system "
                + "as described in chapter 14.<br>"
                + "ERROR MESSAGE: " + e.getMessage();
        request.setAttribute("errorMessage", errorMessage);
        this.log(
                "Unable to send email. \n"
                        + "Here is the email you tried to send: \n"
                        + "=====================================\n"
                        + "TO: " + emailAddress + "\n"
                        + "FROM: " + from + "\n"
                        + "SUBJECT: " + subject + "\n"
                        + "\n"
                        + message + "\n\n");
    }
%>
<p align="center">A confirmation email has been sent. Thanks for placing your order! Here is a summary:</p>

<div class="container">
    <div class="row">
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
            <% for (Course course : courses) { %>
            <tr>
                <td><a href="course-listing/<%= course.getId() %>"><%= course.getName() %>
                </a></td>
                <td><%= course.getProfessor() %>
                </td>
                <td><%= course.getCategory() %>
                </td>
                <td><%= HogwartsConstants.COURSE_FEE_STRING %>
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
            <td><img class="material-icon"
                     src="<%= request.getContextPath() %>/resources/images/course-materials/<%= courseMaterial.getImageName() %>"
                     height="100" width="100"></td>
            <td class="align-middle"><a
                    href="course-material-listing/<%= courseMaterial.getId() %>"><%= courseMaterial.getName() %>
            </a></td>
            <td class="align-middle">
            </td>
            <td class="align-middle"><%= String.format("$%.2f", courseMaterial.getPrice() * courseMaterials.get(courseMaterial)) %>
            </td>
            <td class="align-middle text-right" style="width:13em">
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% if (courses.size() == 0) { %>
    <p class="font-italic text-center">No course materials in cart.</p>
    <% } %>
    <hr/>

    <h3 align="center">Your total is: <%=String.format("$%.2f", courseSubtotal + courseMaterialSubtotal) %>
    </h3>
</div>


<p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>
</html>