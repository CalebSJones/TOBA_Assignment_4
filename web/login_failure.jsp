<%-- 
    Document   : login_failure
    Created on : Apr 12, 2017, 2:46:46 PM
    Author     : Caleb Jones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA - Titan Online Banking Application</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <h1>Login Failed</h1>
                <p>The incorrect information has been entered. Please return to the <a href="Login.html">Login</a> page and try again.</p>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
