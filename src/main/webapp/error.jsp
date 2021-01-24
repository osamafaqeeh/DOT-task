
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>error page</title>
</head>
<body>

<p>requestURI  : ${pageContext.errorData.requestURI}</p>

<p>servletName  : ${pageContext.errorData.servletName}</p>

<p> statusCode  :${pageContext.errorData.statusCode}</p>

<p>throwable :${pageContext.errorData.throwable}</p>

</body>
</html>
