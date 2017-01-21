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

public class admin_login extends HttpServlet {
    private final String view = "/WEB-INF/admin/login.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") != null){ response.sendRedirect("/admin"); return; }
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("pwd");
            
            Admin admin = new Admin();
            List result = admin.selectAdminLogin(username, password);
            if(!result.isEmpty()){
                HttpSession session = request.getSession();
                session.setAttribute("admin", true);
                response.sendRedirect("/admin");
                return ;
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
