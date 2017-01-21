package servlet;

import dashboard.management.warehouses.WarehousesManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import warehouses.inventory.Inventory;

public class admin_product extends HttpServlet {
    private final String view = "/WEB-INF/admin/product.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
        Inventory inv = new Inventory();
        WarehousesManagement pdm = new WarehousesManagement();
        List listproduct = pdm.viewProduct(inv.selectProduct());
        request.setAttribute("listproduct", listproduct);
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
