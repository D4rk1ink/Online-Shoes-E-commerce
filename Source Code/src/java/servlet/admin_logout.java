package servlet;

import accounting.account.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class admin_logout extends HttpServlet {
    private final String view = "/WEB-INF/admin/login.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
    	if(session != null){
    		session.invalidate();
    	}
        }catch(Exception ex){
            
        }
        response.sendRedirect("/admin/login");
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
        response.sendRedirect("/admin/login");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
