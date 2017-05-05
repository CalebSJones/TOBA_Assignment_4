package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import customer.User;

/**
 *
 * @author Caleb Jones
 */
@WebServlet(name="LoginServlet", urlPatterns={"/Login"})
public class LoginServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (request.getParameter("submit") == "Admin") {
            User user = (User) session.getAttribute("user");
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                response.sendRedirect("/admin/reports.jsp");
            } else {
                response.sendRedirect("/admin/login_error.html");
            }
        }
        
        if(session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                response.sendRedirect("account_activity.jsp"); // Successful login from session user.
            }
        } else if(username.equals("jsmith@toba.com") && password.equals("letmein")) {
            response.sendRedirect("account_activity.jsp"); // Successful login with test credentials.
            
            // Create new user in Session Scope.
            User user = new User(username, password);
            session.setAttribute("user", user);
        } else {
            response.sendRedirect("login_failure.jsp"); // Login failed.
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
