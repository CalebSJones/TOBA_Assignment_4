<%-- 
    Document   : password_reset
    Created on : Apr 10, 2017, 1:33:40 PM
    Author     : Caleb Jones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset your password | TOBA</title>
    </head>
    <body>
        <jsp:include page="header.html" />
        <h1>Reset Your Password</h1>
        <form action="PasswordReset" method="post">
            <input type="text" name="password" id="password" value="${user.password}">
            <input type="submit" value="Submit">
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
