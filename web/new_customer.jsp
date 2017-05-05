<%-- 
    Document   : new_customer
    Created on : Apr 12, 2017, 2:47:00 PM
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
                <h1>Customer Registration</h1>
                <p>Please fill out all of your information to register.</p>
                <form action="NewCustomerServlet" method="post">
                    <div class="field">
                        <label for="firstName">First Name:</label>
                        <input type="text" name="firstName" id="firstName" required>
                    </div>
                    <div class="field">
                        <label for="lastName">Last Name:</label>
                        <input type="text" name="lastName" id="lastName" required>
                    </div>
                    <div class="field">
                        <label for="phone">Phone:</label>
                        <input type="text" name="phone" id="phone" required>
                    </div>
                    <div class="field">
                        <label for="address">Address:</label>
                        <input type="text" name="address" id="address" required>
                    </div>
                    <div class="field">
                        <label for="city">City:</label>
                        <input type="text" name="city" id="city" required>
                    </div>
                    <div class="field">
                        <label for="state">State:</label>
                        <input type="text" name="state" id="state" required>
                    </div>
                    <div class="field">
                        <label for="zip">Zipcode:</label>
                        <input type="number" name="zip" id="zip" required>
                    </div>
                    <div class="field">
                        <label for="email">Email:</label>
                        <input type="email" name="email" id="email" required>
                    </div>
                    <input type="submit" value="Register" id="submit" class="button">
                </form>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
