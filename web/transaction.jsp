<%-- 
    Document   : transaction
    Created on : Apr 12, 2017, 2:48:58 PM
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
        <script>
            function isNumber(input)
            {
                var charCode = (input.which) ? input.which : input.keyCode;
                if (charCode != 46 && charCode > 31
                        && (charCode < 48 || charCode > 57))
                    return false;

                return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="header.html" />
        <main>
            <div>
                <h1>Transaction Page</h1>
                <table>
                    <tr>
                        <th>Type</th>
                        <th>Balance</th>
                    </tr>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach var="account" items="${accounts}">
                        <tr>
                            <td>${account.getAccountType()}</td>
                            <td>${account.balance}</td>
                        </tr>
                    </c:forEach>
                </table>
                <form action="transaction" method="POST">
                    <div class="transfer-from">
                        Transfer from
                        <select name="from">
                            <c:forEach var="account" items="${accounts}">
                                <option value="${account.getAccountId()}">${account.getAccountType()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="transfer-to">
                        Transfer to
                        <select name="to">
                            <c:forEach var="account" items="${accounts}">
                                <option value="${account.getAccountId()}">${account.getAccountType()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="amount">
                        <input type="text" name="amount" onkeypress="return isNumber(event)">
                    </div>
                    <input type="submit" value="Submit Transaction">
                </form>
            </div>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>
