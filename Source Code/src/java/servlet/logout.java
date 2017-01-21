package servlet;

import accounting.account.Account;
import accounting.customer.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webstore.authentication.Authentication;


public class logout extends HttpServlet {
    private final String view = "/WEB-INF/home/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
    	if(session != null){
    		session.invalidate();
    	}
        }catch(Exception ex){
            
        }
        response.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
    	if(session != null){
    		session.invalidate();
    	}
        }catch(Exception ex){
            
        }
        response.sendRedirect("/home");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
