package servlet;

import accounting.account.Account;
import accounting.customer.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webstore.authentication.Authentication;
import webstore.shoppingcart.ShoppingCart;


public class login extends HttpServlet {
    private final String view = "/WEB-INF/home/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){ response.sendRedirect("/home"); return; }
        response.sendRedirect("/auth/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){ response.sendRedirect("/home"); return; }
        try{
            String email = request.getParameter("email");
            String password = request.getParameter("pwd");
            
            Account acc = new Account();
            Customer cus = new Customer();
            Authentication auth = new Authentication();
            List listsession = new ArrayList();
            if(auth.login(acc.selectAccountByAuth(email, password))){
                listsession.add(auth.getSession());
                listsession.add(new ShoppingCart("public_key_omise"));
                HttpSession session = request.getSession();
                session.setAttribute("user", listsession);
                response.sendRedirect("/home");
                return ;
            }
            
        }catch(Exception ex){
            
        }
        response.sendRedirect("/auth/login");       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
