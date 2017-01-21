package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import warehouses.inventory.Inventory;
import webstore.searchengines.SearchEngines;

public class auth extends HttpServlet {
    private final String view = "/WEB-INF/auth/auth.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){ response.sendRedirect("/home"); return; }
        Inventory inv = new Inventory();
        SearchEngines seg = new SearchEngines();
        List person = seg.viewBrand(inv.selectPerson());
        request.setAttribute("listperson", person);
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){ response.sendRedirect("/home"); return; }
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
