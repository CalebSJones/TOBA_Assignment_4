package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;

import customer.User;
import customer.Account;
import data.AccountDB;
import customer.Transaction;


/**
 *
 * @author Caleb Jones
 */
// @WebServlet(urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {

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
        User user = (User) session.getAttribute("user");
        
        List<Account> accounts = AccountDB.getAccounts(user);
        request.setAttribute("accounts", accounts);
        
        String url = ("/transaction.jsp");
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
        long accountIdFrom = Integer.parseInt(request.getParameter("from"));
        long accountIdTo = Integer.parseInt(request.getParameter("to"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        // Query Accounts.
        Account accountFrom = AccountDB.getAccount(accountIdFrom);
        Account accountTo = AccountDB.getAccount(accountIdTo);
        
        // Perform transactions.
        accountFrom.debit(amount);
        accountTo.credit(amount);
        Transaction transaction = new Transaction(amount);
        
        // Update database.
        AccountDB.update(accountFrom);
        AccountDB.update(accountTo);
        
        // Update session accounts.
        List<Account> accounts = AccountDB.getAccounts(user);
        request.setAttribute("accounts", accounts);
        
        String url = ("/transaction.jsp");
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
