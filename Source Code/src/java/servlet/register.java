package servlet;

import accounting.account.Account;
import accounting.customer.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webstore.authentication.Authentication;


public class register extends HttpServlet {
    private final String view = "/WEB-INF/home/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){ response.sendRedirect("/home"); return; }
        response.sendRedirect("/auth/register");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){ response.sendRedirect("/home"); return; }
        try{
            String email = request.getParameter("email");
            String password = request.getParameter("pwd");
            String cpassword = request.getParameter("cpwd");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            Account acc = new Account();
            Customer cus = new Customer();
            Authentication auth = new Authentication();
            if(auth.validateRegister(email, password, cpassword, acc.selectAccountByEmail(email))){
                Integer accid = acc.insertAccount(acc.compressDataProduct(null, email, password));
                Boolean result = cus.insertCustomer(cus.compressDataProduct(null, accid, firstname, lastname, phone, address));
                if(auth.register(result)){
                    acc.regisComfirm();
                    response.sendRedirect("/auth/login");
                    return;
                }
                
            }
        }catch(Exception ex){
            
        }
        response.sendRedirect("/auth/register");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
