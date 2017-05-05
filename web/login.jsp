<%-- 
    Document   : login
    Created on : Apr 12, 2017, 2:45:32 PM
    Author     : Caleb Jones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login to Your Account | TOBA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <h1>Customer Login</h1>
                <p>Please enter your account credentials below to access your account.</p>
                <form action="Login" method="post">
                    <div class="field">
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username" required>
                    </div>
                    <div class="field">
                        <label for="password">Password:</label>
                        <input type="password" name="password" id="password" required>
                    </div>
                    <input type="submit" value="Register" id="submit" class="button">
                </form>
                <p><a href="password_reset.jsp">Forgot password?</a></p>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
