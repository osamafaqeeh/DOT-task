
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Students</title>
</head>

<body>
<div class="container">
    <div class="row">
        <h2>Add new Student Information</h2>
        <form method="post" action="${pageContext.request.contextPath}/controller" class="form-inline">
            <input type="hidden" name="command" value="add_student">
            <div class="form-group">
                <label for="student_name">Student name:</label>
                <input type="name"
                       class="form-control" id="student_name" name="name"
                       placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="country">Country:</label>
                <input type="address"
                       class="form-control" id="country" name="country"
                       placeholder="Enter country">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#NUM</th>
                    <th scope="col">Student Name</th>
                    <th scope="col">Country</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.list}" var="student" varStatus="loopCounter">
                    <tr>
                        <th scope="row">${loopCounter.count}</th>
                        <td>${student.name}</td>
                        <td>${student.country}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
