/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import customer.User;
import customer.Account;
import customer.Account.Type;
import data.UserDB;
import data.AccountDB;
import data.PasswordUtil;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Caleb Jones
 */
public class NewCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url;
        
        // get paramters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");

        // Validate the parameters.
        if (firstName == null || lastName == null || phone == null || address == null
            || city == null || state == null || zip == null || email == null
            || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty()
            || address.isEmpty() || city.isEmpty() || state.isEmpty()
            || zip.isEmpty() || email.isEmpty()) {
            
            String message = "Please fill out all of the form fields.";
            url = ("/new_customer.jsp");
        } else {
            // Create a new user.
            String username = lastName + zip;
            String password = "welcome1";
            
            // Hash and salt password.
            String saltedAndHashedPassword;
            try {
                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);
            } catch (NoSuchAlgorithmException ex) {
                saltedAndHashedPassword = ex.getMessage();
            }
            
            // Set session scope.
            HttpSession session = request.getSession();
            User user = new User(firstName, lastName, phone, address, city, state,
                    zip, email, username, saltedAndHashedPassword);
            session.setAttribute("user", user);
            UserDB.insert(user); // Create user in Database.
            
            user.setPassword(password); // Allow user to see plain text password.
            
            // Create a Savings account with $25.
            Account savings = new Account(Type.Savings, 25.00, user);
            AccountDB.insert(savings);
            
            // Create a Checking account with $0.
            Account checking = new Account(Type.Checking, 0.00, user);
            AccountDB.insert(checking);
            
            List<Account> accounts = Arrays.asList(savings, checking);
            request.setAttribute("accounts", accounts);
            
            // Redirect to the success page.
            url = ("/Success.jsp");
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is a servlet that creates new customers as users.";
    }// </editor-fold>

}
