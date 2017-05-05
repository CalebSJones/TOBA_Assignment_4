<%-- 
    Document   : account_activity
    Created on : Apr 12, 2017, 2:46:04 PM
    Author     : Caleb Jones
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Account Activity | TOBA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <h1>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</h1>
                        <p>View your account overview below.</p>
                        <table>
                            <tr>
                                <td>First Name</td>
                                <td>${sessionScope.user.firstName}</td>
                            </tr>
                            <tr>
                                <td>Last Name</td>
                                <td>${sessionScope.user.lastName}</td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td>${sessionScope.user.phone}</td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td>${sessionScope.user.address}</td>
                            </tr>
                            <tr>
                                <td>City</td>
                                <td>${sessionScope.user.city}</td>
                            </tr>
                            <tr>
                                <td>State</td>
                                <td>${sessionScope.user.state}</td>
                            </tr>
                            <tr>
                                <td>Zip Code</td>
                                <td>${sessionScope.user.zip}</td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td>${sessionScope.user.email}</td>
                            </tr>
                            <tr>
                                <td>Username</td>
                                <td>${sessionScope.user.username}</td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td>${sessionScope.user.password}</td>
                            </tr>
                        </table>
                        <h2>Accounts</h2>
                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <c:forEach var="account" items="${accounts}">
                            <tr>
                                <td>${account.type}</td>
                                <td>${account.balance}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h1>Not Logged In</h1>
                        <p>Sorry, but you are not logged in to your account. Please <a href="login.jsp">login</a> to your account before continuing.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
