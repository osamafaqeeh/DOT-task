
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<div class="wrapper fadeInDown">
    <div id="formContent">

        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="login_command">
            <input type="text" id="username"  name="user_name" placeholder="user name">
            <input type="text" id="password"  name="password" placeholder="password">
            <input type="submit" value="Log In">
            <div class="text-warning" style="color: red">${requestScope.message}</div>
        </form>
    </div>
</div>
</html>
