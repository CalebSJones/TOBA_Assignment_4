<%-- 
    Document   : success.jsp
    Created on : Apr 10, 2017, 1:00:29 PM
    Author     : Caleb Jones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Your Account Has Been Created | TOBA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <h1>Your account has been successfully created!</h1>
                <p>Please review the information you entered below and verify its validity.</p>
                <table class="account-details">
                    <tr><td>First Name</td><td>${sessionScope.user.firstName}</td></tr>
                    <tr><td>Last Name</td><td>${sessionScope.user.lastName}</td></tr>
                    <tr><td>Phone</td><td>${sessionScope.user.phone}</td></tr>
                    <tr><td>Address</td><td>${sessionScope.user.address}</td></tr>
                    <tr><td>City</td><td>${sessionScope.user.city}</td></tr>
                    <tr><td>State</td><td>${sessionScope.user.state}</td></tr>
                    <tr><td>Zip</td><td>${sessionScope.user.zip}</td></tr>
                    <tr><td>Email</td><td>${sessionScope.user.email}</td></tr>
                    <tr><td>Username</td><td>${sessionScope.user.username}</td></tr>
                    <tr><td>Password</td><td>${sessionScope.user.password}</td></tr>
                </table>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
