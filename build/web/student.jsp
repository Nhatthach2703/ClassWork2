<%-- 
    Document   : student
    Created on : Jan 18, 2024, 9:39:15 AM
    Author     : Xuan Vinh
--%>

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Student List</h2>

        <form action="StudentServlet" method="get">
            <label>Number of Students:</label>
            <input type="text" name="numberOfStudents">
            <button type="submit">Generate</button>
        </form> 
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Student> studentList = (List<Student>) request.getAttribute("data");
                    if (studentList != null) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        for (Student student : studentList) {
                %>
                <tr>
                    <td><%= student.getId()%></td>
                    <td><%= student.getName()%></td>
                    <td><% if (student.isGender()) {
                        %>
                        <input type="checkbox" checked/>
                        <% } else { %>
                        <input type="checkbox"/>
                        <% }%>
                    <td><%= dateFormat.format(student.getDob())%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
            <h1>basdvf </h1>
    </body>
</html>
