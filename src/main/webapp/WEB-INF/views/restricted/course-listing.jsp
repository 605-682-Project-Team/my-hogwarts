<!DOCTYPE html>
<html>
<head>
    <%@ include file="fragments/resources.jsp" %>
    <title>My Hogwarts Courses</title>
</head>


<%@page import="edu.hogwarts.persistence.entity.Course" %>
<%@page import="edu.hogwarts.persistence.entity.Course.CourseCategory" %>

<body class="bg-light">
<%@ include file="fragments/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <form action="course-listing" method="post">
                <div class="card">
                    <div class="card-header">Filters</div>
                    <div class="card-body">
                        <h5 class="card-title">Category</h5>
                        <%
                            CourseCategory checked;
                            String checkedStr = request.getParameter("category");
                            if (checkedStr == null || checkedStr.isEmpty()) {
                                checked = null;
                            } else {
                                checked = CourseCategory.valueOf(checkedStr);
                            }

                        %>
                        <div class="radio">
                            <label><input type="radio" name="category"
                                          value="<%= CourseCategory.CORE %>" <%if (CourseCategory.CORE.equals(checked)) { %>
                                          checked <% } %>><%= CourseCategory.CORE.display() %>
                            </label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="category"
                                          value="<%= CourseCategory.ELECTIVE %>" <%if (CourseCategory.ELECTIVE.equals(checked)) { %>
                                          checked <% } %>><%= CourseCategory.ELECTIVE.display() %>
                            </label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="category"
                                          value="<%= CourseCategory.EXTRA_CURRICULAR %>" <%if (CourseCategory.EXTRA_CURRICULAR.equals(checked)) { %>
                                          checked <% } %>><%= CourseCategory.EXTRA_CURRICULAR.display() %>
                            </label>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-success btn-md btn-block" type="submit">Refresh</button>
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
                    Iterable<Course> courses = (Iterable<Course>) request.getAttribute("courses");
                    for (Course course : courses) {
                %>
                <tr>
                    <td><a href="course-listing/<%= course.getId() %>"><%= course.getName() %>
                    </a></td>
                    <td><%= course.getProfessor() %>
                    </td>
                    <td><%= course.getCategory().display() %>
                    </td>
                    <td>
                        <form action="<%= request.getContextPath() %>/restricted/shopping-cart/add-course/<%= course.getId() %>"
                              method="post">
                            <input type="submit" class="btn btn-primary btn-md" value="Add to Cart"/>
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