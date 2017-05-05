/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Caleb Jones
 */
public class LogRequestFilter implements Filter {

    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext sc = filterConfig.getServletContext();
        
        String logString = filterConfig.getFilterName() + " | ";
        logString += "Servlet path: " + httpRequest.getServletPath() + " | ";
        
        Cookie[] cookies = httpRequest.getCookies();
        
        String cookiesString = "";
        if (cookies != null) {
            for (Cookie c : cookies)
                cookiesString += c.getName() + "=" + c.getValue() + " ";
        }
        logString += cookiesString;
        sc.log(logString);
        
        chain.doFilter(httpRequest, response);
    }
    
    @Override
    public void destroy() {
        filterConfig = null;
    }
}
